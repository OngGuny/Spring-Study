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
  
    //목록버튼 클릭시 목록으로~
    $("#listBtn").click(function(event){
    location.href = "/";
  });

});