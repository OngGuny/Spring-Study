
let replyService = (function(){
      function insertReplyVO(reply, callback){
         $.ajax({
        type : 'post',
        url : '/replies/insert',
        data : JSON.stringify(reply),
        contentType : "application/json; charset=utf-8",
        success : function(result, status, xhr){
          if(callback){
            callback(result);
          }
        },
        error : function(xhr,status,er){
          if(error){
            error(er);
          }
        }
      });
   }

    function listReplyVO(param, callback, error){
      var bno = param.bno;
      var page = param.page || 1;

      $.getJSON("/replies/pages/"+bno+"/"+page+".json",
      function(data){
        if(callback){
          //callback(data); 댓글개수 세어서 페이징하려고 
        callback(data.replyCnt, data.list);
        }
      }).fail(function(xhr, status, err){
        if(error){
          error();
        }
      });
    }

    function deleteReplyVO(rno,callback,error){
      $.ajax({
        type:'delete',
        url:'/replies/'+rno,
        success:function(result,status,xhr){
          if(callback){
            callback(result);
          }
        },
        error:function(xhr,status,er){
          if(error){
            error(er);
          }
        }
      });
    }

    function updateReplyVO(reply, callback, error){
      $.ajax({
        type : 'put',
        url : '/replies/'+reply.rno,
        data : JSON.stringify(reply),
        contentType : "application/json; charset=utf-8",
        success : function(result, status, xhr){
          if(callback){
            callback(result);
          }
        },
        erroror : function(xhr,status,er){
          if(erroror){
            error(er);
          }
        }
      });
    }

    function selectReplyVO(rno, callback, error){
      $.get("/replies/"+rno+".json",function(result){
        if(error){
          error();
        }
      });
    }

function displayTime(timeValue) {

      var today = new Date();

      var gap = today.getTime() - timeValue;

      var dateObj = new Date(timeValue);
      var str = "";

      if (gap < (1000 * 60 * 60 * 24)) { //얘가 하루. 

         var hh = dateObj.getHours();
         var mi = dateObj.getMinutes();
         var ss = dateObj.getSeconds();

         return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
               ':', (ss > 9 ? '' : '0') + ss ].join('');

      } else { // 차이가 24시간 이상 나면.. 이거하겠다.
         var yy = dateObj.getFullYear();
         var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
         var dd = dateObj.getDate();

         return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
               (dd > 9 ? '' : '0') + dd ].join('');
      }
   };   
   var modal = $(".modal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");
    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    
    $("#modalCloseBtn").on("click", function(e){
    	
    	modal.modal('hide');
    });
    
    
    
    $("#addReplyBtn").on("click", function(e){
        modal.find("input").val("");
        modal.find("input[name='replyer']").val(replyer);
        modalInputReplyDate.closest("div").hide();
        modal.find("button[id !='modalCloseBtn']").hide();
        modalRegisterBtn.show();
        $(".modal").modal("show");
      });
      
      
      
      modalRegisterBtn.on("click",function(e){
      
      var reply = {
            reply: modalInputReply.val(),
            replyer:modalInputReplyer.val(),
            bno:bnoValue
          };
      replyService.add(reply, function(result){
        
        alert(result);
        
        modal.find("input").val("");
        modal.modal("hide");

        //showList(1);
        showList(-1);
      });
    });

      
      
    return{
      insertReplyVO:insertReplyVO,
      listReplyVO:listReplyVO,
      deleteReplyVO:deleteReplyVO,
      updateReplyVO:updateReplyVO,
      selectReplyVO:selectReplyVO,
      displayTime : displayTime
    };
   
   })();
   
 