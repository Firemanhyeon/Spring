/*filename: reply.js */

console.log("댓글 처리")
replyList();


function replyList(){
	$.ajax({
		method: "get",        // == type
		url: "/replies/pages/271/1",
		//data: 필요없음
		//contentType:
		success: function(result){
			$("#replyList").html("");
			for(let i = 0 ; i<result.length;i++){
				$('#replyList').append(result[i].reply+'<br>');
				
			}
		},
		error:function(){}
	})
}

$("#addReply").on('click',function(){
	$.ajax({
		method:"post",
		url: "/replies/new",
		data: $("#replyFrm").serialize(),
		success: function(result){
			if(result=="success"){
				alert("등록완료")
				replyList();
			}else{
				alert("등록실패")
			}
		}
	})
})