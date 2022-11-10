<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 20px;
}
.uploadResult ul li span {
	coloer: white;
}


.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:100%;
  height:100%;
  background-color: gray; 
  z-index: 100;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}

.bigPicture img {
	width : 600px;
}
</style>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	function showImage(fileCallPath){ // a 태그에서 직접 호출하려고 밖에다가 쓴거임.
	alert(fileCallPath);
	$(".bigPictureWrapper").css("display","flex").show();
	
	$(".bigPicture")
	.html("<img src='/display?fileName=" +encodeURI(fileCallPath)+"'>")
	.animate({width:'0%',height:'0%'},1000); 
	}


	$(document).ready(function() {
		//정규식 써서 파일 크기랑 이름 필터로 걸러냄.
		var regex = new RegExp("(.*?)\.(exe|sh|jar|msi|com|php|jsp|asp)$");
		var maxSize = 5242880;

		function checkFileSize(fileSize) {
			if (fileSize >= maxSize) {
				alert("업로드 하실 수 있는 파일 사이즈는 최대 5MB 입니다. 이새끼야.");
				return false;
			}
			return true;
		}
		;
		function checkExtensions(fileName) {
			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드 하실 수 없습니다!");
				return false;
			}
			return true;
		}
		;

		var cloneObj = $(".uploadDiv").clone(); // readonly 라 수정 할 수 없기 때문에 클론을 만들어서 수정한다. 

		$("#uploadBtn").on("click", function(e) {
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;

			console.log(files);

			for (var i = 0; i < files.length; i++) {
				if (!checkExtensions(files[i].name)) {
					return false;
				}

				if (!checkFileSize(files[i].size)) {
					return false;
				}
				formData.append("uploadFile", files[i]);
			}

			$.ajax({
				url : '/uploadAjaxAction',
				processData : false, //데이터 처리
				contentType : false, // MIME 타입 ( application / xml ...)
				data : formData, //요청시 전송 데이터
				type : 'POST', // HTTP Method 
				dataType : "JSON", // 응답시 전송 받는 데이터의 타입 
				success : function(result) {//result : 응답 데이터

					console.log(result);
					showUploadedFile(result);
					$(".uploadDiv").html(cloneObj.html()); //클론 초기화  첨부파일 다시 추가 할 수 있도록.
				}
			});//ajax

			//업로드한 파일 목록처리.
			var uploadResult = $(".uploadResult ul");

			function showUploadedFile(uploadedResultArr) {
				var str = "";

				$(uploadedResultArr).each(function(i, obj) {
					str += "<li>" + obj.fileName + "<li>";
				});
				uploadResult.append(str);
			}

			function showUploadedFile(uploadedResultArr) {
				var str = "";

				$(uploadedResultArr).each(function(i, obj) {
					if(!obj.image){
						var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
						str += "<li><div><a href='/download?fileName="+fileCallPath+"'>"
								+"<img src='/resources/img/attach.png'>"
							 +obj.fileName+"</a>"+"<span data-file=\'"+fileCallPath+"\'data-type='file'> x </span>"+"</div></li>"
							 
					}else {
						var fileCallPath = encodeURIComponent( obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
						
						var originPath = obj.uploadPath+"\\"+obj.uuid+ "_"+obj.fileName;
						originPath = originPath.replace(new RegExp(/\\/g),"/");
						
						str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='/display?fileName="+fileCallPath+"'></a>"+
								"<span data-file=\'"+fileCallPath+"\' data-type='image'> x </span>"
								+"</li>";
					}
				});
				uploadResult.append(str);
			}//showuploadfile
			
			//.사라지게 하는 펑션
			$(".bigPictureWrapper").on("click",function(e){
				setTimeout(()=>{
					$(this).hide();
				},1000);
			});
			
			//x 이벤트 처리
			$(".uploadResult").on("click","span",function(e){
				var targetFile = $(this).data("file");
				var type = $(this).data("type");
				console.log(targetFile);
			
				$.ajax({
					url: '/deleteFile',
					data:{fileName:targetFile, type:type},
					dataType : 'text',
					type : 'POST',
					success : function(result){
						alert(result);
					}
			
			});//ajax2
		});
			
		});
	});
</script>

</head>
<body>
	<h1>Upload with AJAX</h1>
<div class='bigPictureWrapper'>
  <div class='bigPicture'>
  </div>
</div>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple />
	</div>
	<div class="uploadResult">
		<!-- 첨부파일 이름 목록으로 만들기 위한 공간 -->
		<ul>

		</ul>
	</div>

	<div>
		<button id="uploadBtn">upload</button>
	</div>


</body>
</html>