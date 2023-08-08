<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Boad Read</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel-heading">Board Read Page</div>
        <div class="panel-body">
            <!-- <form role="form" action="/board/register" method="post"> -->
                <div class="form-group">
                    <label >Bno</label>
                    <input type="text" class="form-control" name="bno" readonly value="<c:out value='${board.bno }'/>">
                </div>
                <div class="form-group">
                    <label >Title</label>
                    <input type="text" class="form-control" name="writer" readonly value="<c:out value='${board.title }'/>">
                </div>
                <div class="form-group">
                    <label>Content</label>
                    <textarea name="content" cols="30" rows="4" class="form-control" readonly ><c:out value="${board.content }"/></textarea>
                </div>
                <div class="form-group">
                    <label >Writer</label>
                    <input type="text" class="form-control" name="writer" readonly value="<c:out value='${board.writer }'/>">
                </div>
                
               <!--  <button type="button" class="btn btn-default" onclick="location.href='modify?bno=${board.bno}'">Modify</button>
                <button type="button" class="btn btn-default">Delete</button> -->
            <!-- </form> -->
            <form id="operForm" action="/board/modify" method="get">
            	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>'>
            	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
            	<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'>
            	<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
            	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
            </form>
            <button data-oper="modify"class="btn btn-default">Modify</button>
            <button data-oper="list"class="btn btn-default">List</button>
        </div>
    </div>
</div>
<!-- 댓글시작 -->
<div id="replyList"></div>
<!-- 댓글끝 -->

<!-- 댓글등록시작 -->
<div>
	<form id="replyFrm">
		<input type="hidden" name="bno" value="271" >
		<input type="hidden" name="replyer" value="hong">
		<input type="text" name="reply">
		<button type="button" id="addReply">등록</button>
	</form>
</div>
<!-- 댓글등록끝 -->
<script src="/resources/js/reply.js"></script>

<script>
	var operForm = $('form');
	$('button[data-oper="modify"]').on('click',function(){
		operForm.attr('action','/board/modify').submit();//form태그의 이벤트 호출
	})
	$('button[data-oper="list"]').on('click',function(){
		operForm.find('#bno').remove();//list로 갈땐 파라미터로 글번호는 필요없음.
		operForm.attr('action','/board/list').submit();//form태그의 이벤트 호출
	})
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>