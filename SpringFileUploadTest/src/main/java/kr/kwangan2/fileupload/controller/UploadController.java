package kr.kwangan2.fileupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kwangan2.fileupload.domain.AttachFileDTO;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadAjax")
	public void uploadAjax() {

	}

	@PostMapping(
		   value="/uploadAjaxAction",
		   produces=MediaType.APPLICATION_JSON_UTF8_VALUE
		   )
   @ResponseBody // 제이슨 받아서 제이슨으로 던지려ㅑ고 함. DB에 넣으려고! 
   public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
	   log.info("길이길이길이"+uploadFile.length);
	   List<AttachFileDTO> list = new ArrayList<>();
	   
      String uploadFolder = "C:/upload";
      
      String uploadFolderPath = getFolder();
      
      File uploadPath = new File(uploadFolder, uploadFolderPath);
      
      if(uploadPath.exists() == false) {
         uploadPath.mkdirs();
      }
      
      for (MultipartFile multipartFile : uploadFile) {
    	  
    	  AttachFileDTO attachFileDTO = new AttachFileDTO();
    			  
    	  
         log.info("================================");

         String originalFilename = multipartFile.getOriginalFilename();
         log.info("upload file name: " + originalFilename);
         log.info("upload file size: " + multipartFile.getSize());
         log.info("isEmpty: " + multipartFile.isEmpty());
         log.info("getName: " + multipartFile.getName());
//         try {
//            byte[] bytes = multipartFile.getBytes();
//            int bytesLength = bytes.length;
//            char[] chars = new char[bytesLength];
//            String str = "";
//            for (int i = 0; i < bytesLength; i++) {
//               str += chars[i];
//               
//            }
//            log.info("getBytes: " + str);
//            log.info("getInputStream: " + multipartFile.getInputStream());
//         } catch (IOException ioe) {
//            ioe.printStackTrace();
//         }
         log.info("================================");

         originalFilename = originalFilename.substring(originalFilename.lastIndexOf("\\") + 1);
         attachFileDTO.setFileName(originalFilename);
         UUID uuid = UUID.randomUUID();
         originalFilename = uuid.toString()+"_"+originalFilename;
         
         
         try {
        	 File saveFile = new File(uploadPath,originalFilename);
            multipartFile.transferTo(saveFile);
            
            
            attachFileDTO.setUuid(uuid.toString());
            attachFileDTO.setUploadPath(uploadFolderPath);
            
            if(checkImageType(saveFile)) {
            	attachFileDTO.setImage(true);
            	FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + originalFilename));
            	Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
            	thumbnail.close();
            }
            list.add(attachFileDTO);
            
         } catch (Exception ex) {
            ex.printStackTrace();
         }
      } // for
      
      return new ResponseEntity<>(list,HttpStatus.OK); //타입 명시 안하면 <> 안써도 된다. 
   } // uploadAjaxPost

	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		log.info("fileName: " + fileName);
		File file = new File("c:\\upload\\" + fileName);
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header, HttpStatus.OK
					);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return result;
	}
	
	
	// 파일 다운로드 
	@GetMapping(
			value="/download",
			produces=MediaType.APPLICATION_OCTET_STREAM_VALUE
			)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent ,String fileName){

		Resource resource = new FileSystemResource("c:\\upload\\"+fileName);

		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		
		//remove UID
		String resourceOriginName = resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			String downloadName = null;
			
			if(userAgent.contains("Edge")) {
				log.info("Edge Browser");
				downloadName = URLEncoder.encode(resourceName,"UTF-8");
			}else {
				log.info("Chrome browser");
				downloadName = new String(resourceName.getBytes("UTF-8"),"ISO-8859-1");
			}
			
			log.info("downloadName : " + downloadName);
			headers.add("Content-Disposition", "attachment; fimename=" + new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
//파일 삭제
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile : " +fileName);
		File file;
		
		try {
			file = new File("c:\\upload\\"+URLDecoder.decode(fileName,"UTF-8"));
			file.delete();
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName : "+largeFileName);
				
				file = new File(largeFileName);
				
				file.delete();
			}
					
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
	
	
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return (contentType!=null ? contentType.startsWith("image") : false); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

} // class
