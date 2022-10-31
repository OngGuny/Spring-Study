$(function(){

   //모든 버튼에 대해 프리벤트 걸어놔서 새로나 방지함 1회성으로만 데이터 전달.

  $('#regBtn').click(function(event){
   event.preventDefault();
    location.href = "/board/boardInsert";
  });
  
  //수정버튼 클릭시 수정 처리
    $("#updateBtn").click(function(event){
     if(confirm("정말 tnwj일꺼?")){
  	   $("#dForm").submit();
     } else{
    	 return false;
     }
	   
  	});
  
    //삭제버튼 클릭시 삭제 처리
    $('#deleteBtn').click(function(event){
     event.preventDefault();
    if(confirm("정말 죽일꺼?")){
  	   location.href = "/board/delete?bno="+$(this).attr("bno");
     } else{
    	 return false;
     }
     
  });
 
    //목록버튼 클릭시 목록으로~
    $('#listBtn').click(function(event){
     event.preventDefault();
    location.href = "/";
  });
  
  
});