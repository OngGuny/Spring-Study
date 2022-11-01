package kr.kwangan2.springmvcboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.service.BoardService;
import kr.kwangan2.springmvcboard.util.PageCalc;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
   private BoardService boardService;
   
//   @GetMapping("/list")
//   public String listBoardVO(Model model) {
//      model.addAttribute("boardVOList", boardService.boardVOList());
//      return "boardList";
//   }

   @GetMapping("/list")
   public String listBoardVO(Criteria criteria, Model model) {
	   model.addAttribute("boardVOList", boardService.boardVOList(criteria));
	   model.addAttribute("pageCalc", 
			   new PageCalc(criteria, 
					   boardService.boardVOListCount(criteria))
			   				.calcPage());
	   return "boardList";
   }
   
   @GetMapping("/boardInsert")
   public String boardInsert() {
      return "boardInsert";
   }
   
   @PostMapping("/boardInsertProc")
   public String boardInsertProc(BoardVO boardVO, RedirectAttributes redirectAttributes) {
      boardService.insertBoardVO(boardVO);
      if(boardService.insertBoardVO(boardVO)>0) {
    	  redirectAttributes.addFlashAttribute("result", "success");
      }
      return "redirect:/";
   }

   @GetMapping("/select")
   public String selectBoardVO(@RequestParam("bno") Long bno, Model model) {
      model.addAttribute("boardVO", boardService.selectBoardVO(bno));
      return "boardUpdate";
   }

   @PostMapping("/updateProc")
   public String updateBoardVO(BoardVO boardVO, Criteria criteria,RedirectAttributes rttr) {
      if (boardService.updateBoardVO(boardVO) > 0) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/"+criteria.getListLink();
   }
   
   @GetMapping("/delete")
   public String deleteBoardVO(@RequestParam("bno") Long bno,Criteria criteria, RedirectAttributes rttr) {
      if (boardService.deleteBoardVO(bno) > 0) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/"+criteria.getListLink();
   }
}