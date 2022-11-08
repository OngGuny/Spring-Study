$(function(){

    $("button").click(function(event){
      event.preventDefault();
    });

  $("#regBtn").click(function(event){
    location.href = "/board/boardInsert";
  });
  
  //수정버튼 클릭시 수정 처리
    $("#updateBtn").click(function(event){
    if(confirm("정말 수정?")){
     $("#updateForm").submit();
     }else{
     	return false;
     }
  });
  
    //삭제버튼 클릭시 삭제 처리
    $("#deleteBtn").click(function(event){
    if(confirm("정말 삭제?")){
     location.href = "/board/delete?bno="+$(this).attr("bno");
     }
  });
	
	//리스트 페이지에서 제목 클릭시 조회페이지로 이동 
	addClickListener(".selectLink","selectFromList", "/board/select");

	// 리스트 페이지에서 페이지 번호 링크 처리
	addClickListener(".pageNumLink","listFormPaging","/board/list");

	//조회페이지에서 목록버튼 클릭처리
	addClickListener("#listBtn","listFormSelect","/board/list");
	
	//검색 버튼 클릭 시 검색 폼 서밋
	addClickListener("#searchBtn","listFormSearch","/board/list");
	
	//입력폼  서브밋/리셋
	$(".boardInsertBtns").click(function(){
		if($(this).attr("id") =="boardInsertSubmitBtn"){
		$("#boardInsertForm").submit();
		} else if($(this).attr("id") =="boardInsertResetBtn"){
		$("#boardInsertForm").reset();
		}
	});
	
	
});// $(function(){})

// 이벤트 타겟 엘리먼트, 명령, 이동할 경로
	function addClickListener(element, command, action){
		$(element).click(function(event){
			event.preventDefault();
			$("input[name='pageNum']").val($(this).attr('pageNum'));
			$("input[name='bno']").val($(this).attr('bno'));
			$("input[name='type']").val($("select[name='type']").val());
			$("input[name='keyword']").val($("input[name='keyword']").val());
			if(command=="listFormSearch"){
				$("input[name='pageNum']").val($("input[name='pn']").val());
			}
			$("#actionForm").attr("action",action);
			$("#actionForm").submit();
		});
	}
	


	
	
	
/* -----------------------------------------------------------------------------
  $("#regBtn").click(function(event){
    location.href = "/board/boardInsert";
  });
  
  //수정버튼 클릭시 수정 처리
    $("#updateBtn").click(function(event){
    if(confirm("정말 수정?")){
     $("#updateForm").submit();
     }else{
     	return false;
     }
  });
  
    //삭제버튼 클릭시 삭제 처리
    $("#deleteBtn").click(function(event){
    if(confirm("정말 삭제?")){
     location.href = "/board/delete?bno="+$(this).attr("bno");
     }
  });
  
    //목록버튼 클릭시 목록으로~
    $("#listBtn").click(function(event){
    location.href = "/";
  });

	//페이지 번호 링크처리 
	$(".pageNumLink").click(function(event){
	 	event.preventDefault(); 
		console.log($(this).attr("href"));
		$("input[name=pageNum]").val($(this).attr('data'));
		$("#actionForm").attr("action", "/board/list");
		$("#actionForm").submit();
	});




	formSetting(".move",["select"],"/board/select");

	//조회화면 이동시 폼데이터 설정
	$(".move").click(function(){
		event.preventDefault();
		$("input[name='pageNum']").val($(this).attr('href'));
		$("input[name='action']").val(select);
		$("#actionForm").attr("action", "/board/select");
		$("#actionForm").submit();
	})

});*/