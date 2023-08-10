<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.0.js"integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="param">
		<table>
			<tr>
				<td><input name="list[0].code" value="c1"></td>
				<td><input name="list[0].codeNm" value="바나나"></td>
				
			</tr>
			<tr>
				<td><input name="list[1].code" value="c2"></td>
				<td><input name="list[1].codeNm" value="사과"></td>
				
			</tr>
			<tr>
				<td><input name="list[2].code" value="c3"></td>
				<td><input name="list[2].codeNm" value="키위"></td>
				
			</tr>
		</table>
		<button>등록</button>
	</form>


	<form id="frm">
		<table>
			<tr>
				<td><input name="code" value="c1"></td>
				<td><input name="codeNm" value="바나나"></td>
				
			</tr>
			<tr>
				<td><input name="code" value="c2"></td>
				<td><input name="codeNm" value="사과"></td>
				
			</tr>
			<tr>
				<td><input name="code" value="c3"></td>
				<td><input name="codeNm" value="키위"></td>
				
			</tr>
		</table>
		<button type="button">ajax등록</button>
	</form>

	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/js/json.min.js"></script>
	<script>
		$.ajax({
			url:"",
			method:"",
			data:"",
			contentType:"",
			success:function(){
				
			}
		})
	</script>
</body>
</html>