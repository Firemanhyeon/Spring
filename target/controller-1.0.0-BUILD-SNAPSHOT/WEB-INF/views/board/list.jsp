<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
							<table width="100%" class="table table-striped table-bordered table-hover">
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
											<td>
												<c:out value="${board.bno }" />
											</td>
											<td><a class="move" href="<c:out value='${board.bno}'/>">
													<c:out value="${board.title }" />
												</a></td>
											<td>
												<c:out value="${board.writer }" />
											</td>
											<td>
												<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" />
											</td>
											<td>
												<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }" />
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 검색조건 추가 -->
							<div class="row">
								<div class="col-lg-12">
									<form id="searchForm" action="/board/list" method="get">
										<select name="type">
											<option value="">----</option>
											<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : '' }"/> >제목</option>
											<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }"/> >내용</option>
											<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : '' }"/> >작성자</option>
											<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : '' }"/> >제목 or 내용</option>
											<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : '' }"/> >제목 or 작성자</option>
											<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW' ? 'selected' : '' }"/> >제목 or 내용 or 작성자</option>
										</select>
										<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>' >
										<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
										<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
										<button class="btn btn-detail">Search</button>
									</form>
								</div>
							</div>
							
							
							<!-- pagination -->
							<div class="pull-right">
								<ul class="pagination">
									<c:if test="${pageMaker.prev }">
										<li class="pagenate_button previous"><a
												href="${pageMaker.startPage-1}">Previous</a></li>
									</c:if>
									<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
										<li class="pagenate_button ${pageMaker.cri.pageNum == num? 'active':''}"><a
												href="${num }">${num }</a></li>
									</c:forEach>
									<c:if test="${pageMaker.next }">
										<li class="pagenate_button previous">
											<a href="${pageMaker.endPage+1}">Next</a>
										</li>
									</c:if>
								</ul>
							</div>
							
							<!-- end of paginate.. -->
							<form action="/board/list" method="get">
								<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
								<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
								<input type="hidden" name="type" value="${pageMaker.cri.type }">
								<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
							</form>

							<!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body">
											등록메세지
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save changes</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
					</div>
				</div>
			</div>
			<script>
				$(document).ready(function () {
					var result = '<c:out value="${result}" />';
					console.log(result)

					//모달창을 활요애서 메세지 보여주도록
					checkModal(result);
					//history객체에 state속성
					//state의 속성이 null:등록/수정/삭제 후  목록 페이지로 이동할 경우 값없는 객체를 하나 만들어주고 값이 있으면 모달창 안띄우고 없으면 모달창띄움
					console.log(history.state);
					history.replaceState({},null,null);
					console.log(history.state);
					function checkModal(result){
						if(result==''|| history.state){
							return;
						}
						if(result){
							$('.modal-body').html(result);
						}
						$('#myModal').modal('show')
					}
					
					$('#regBtn').on('click', function () {
						location.href = '/board/register';
					})

					var actionForm = $('form');
					$('.pagenate_button a').on('click', function (e) {
						e.preventDefault();
						//href의 속성이 페이지번호. form submit()
						actionForm.find('input[name="pageNum"]').val($(this).attr('href'));
						actionForm.submit();
					})
					
					//상세글보기 
					$('.move').on('click',function(e){
						e.preventDefault();
						bnoInput = '<input type="hidden" name="bno" value="'+$(this).attr('href')+'">';
						actionForm.append(bnoInput);
						actionForm.attr('action','/board/get')
						actionForm.submit();
					})
					
					//검색조건
					
					var searchForm =$('#searchForm');
					
					$('#searchForm button').on('click', function(e){
						if(!searchForm.find('option:selected').val()){
							alert('검색조건을 선택하세요')
							return false;
						}
						if(!searchForm.find('input[name="keyword"]').val()){
							alert('키워드를 입력하세요')
							return false;
						}
						searchForm.find('input[name="pageNum"]').val('1');
						searchForm.submit();
					})
				})

			</script>
			<jsp:include page="../includes/footer.jsp"></jsp:include>