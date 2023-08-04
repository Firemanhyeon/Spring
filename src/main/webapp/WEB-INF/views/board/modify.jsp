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
            <form role="form" action="/board/modify" method="post">
                <div class="form-group">
                    <label >Bno</label>
                    <input type="text" class="form-control" name="bno"  readonly value="<c:out value='${board.bno }'/>">
                </div>
                <div class="form-group">
                    <label >Title</label>
                    <input type="text" class="form-control" name="title"  value="<c:out value='${board.title }'/>">
                </div>
                <div class="form-group">
                    <label>Content</label>
                    <textarea name="content" cols="30" rows="4" class="form-control"  ><c:out value="${board.content }"/></textarea>
                </div>
                <div class="form-group">
                    <label >Writer</label>
                    <input type="text" class="form-control" name="writer" readonly value="<c:out value='${board.writer }'/>">
                </div>
              <%--   <div class="form-group">
                    <label >RegDate</label>
                    <input type="text" class="form-control" name="regdate" readonly value="<c:out value='${board.regdate }'/>">
                </div>
                <div class="form-group">
                    <label >UpdateDate</label>
                    <input type="text" class="form-control" name="updatedate" readonly value="<c:out value='${board.updatedate }'/>">
                </div> --%>
                
                <button type="submit" class="btn btn-default" data-oper="modify">저장</button>
                <button type="submit" class="btn btn-default" data-oper="remove">삭제</button>
                <button type="submit" class="btn btn-default" data-oper="list">목록</button>
            </form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        var formObj = $('form');
        $('button').on('click',function(e){
            //dataset.operator
           var operation= $(this).data('oper');
            
            e.preventDefault();//기본 폼 
            
           if(operation=='remove'){
            formObj.attr('action','/board/remove');//form.action = /baord/remove
           }else if(operation =='list'){
            location.href='/board/list';
            return;
           }
           formObj.submit();
        })
    })
</script>

<jsp:include page="../includes/footer.jsp"></jsp:include>