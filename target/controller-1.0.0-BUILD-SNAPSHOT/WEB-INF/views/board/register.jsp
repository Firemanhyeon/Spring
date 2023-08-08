<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Boad Register</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel-heading">Board Register</div>
        <div class="panel-body">
            <form role="form" action="/board/register" method="post">
                <div class="form-group">
                    <label >Title</label>
                    <input type="text" class="form-control" name="title">
                </div>
                <div class="form-group">
                    <label>Content</label>
                    <textarea name="content" cols="30" rows="4" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label >Writer</label>
                    <input type="text" class="form-control" name="writer">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                <button type="reset" class="btn btn-default">Reset</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>