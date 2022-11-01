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
	formSetting(".selectLink",["select"], "/board/select");

	// 리스트 페이지에서 페이지 번호 링크 처리
	formSetting(".pageNumLink",["list"],"/board/list");

	//조회페이지에서 목록버튼 클릭처리
	formSetting("#listBtn",["list"],"/board/list");
	
	//검색 버튼 클릭 시 검색 폼 서밋
	$('#searchBtn').click(function(event){
		$('#searchForm').submit();
	});
	
});// $(function(){})

// CSS 클래스명, InputElement의 Name 속성의 값들, 이동할 경로 
	function formSetting(cssType, nameValues, actionURI ){
		$(cssType).click(function(event){
			event.preventDefault();
			$("input[name='pageNum']").val($(this).attr('pageNum'));
			$("input[name='action']").val(nameValues[0]);
			$("input[name='bno']").val($(this).attr("bno"));
			$("#actionForm").attr("action", actionURI);
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