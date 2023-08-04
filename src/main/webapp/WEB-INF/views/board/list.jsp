<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List Page
				<button id="regBtn" class="btn btn-xs pull-right">Register New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${list }">
							<tr>
								<td><c:out value="${board.bno }"/></td>
								<td><a href="get?bno=${board.bno}"><c:out value="${board.title }"/></a></td>
								<td><c:out value="${board.writer }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- pagination -->
				<div class="pull-right">
                    <ul class="pagination">
                    	<c:if test="${pageMaker.prev }">
                    		<li class="paginate_button previous"><a href="#">Previous</a></li>
                    	</c:if>
                        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            <li class="pagenate_button ${pageMaker.cri.pageNum == num? 'active':''}"><a href="#">${num }</a></li>
                        </c:forEach>
                        <c:if test="${pageMaker.next }">
                    		<li class="paginate_button previous"><a href="#">Next</a></li>
                    	</c:if>
                    </ul>
                </div>
			</div>
		</div>
	</div>
</div>
<script>
    $(document).ready(function(){
        $('#regBtn').on('click',function(){
            location.href = '/board/register';
        })
    })
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>