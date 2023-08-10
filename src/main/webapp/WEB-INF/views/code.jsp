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
		<button type="button" id="btnAdd">ajax등록</button>
	</form>

	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/js/json.min.js"></script>
	<script>
	$("#btnAdd").on('click',function(){
		let list=[];
		let arr=$('#frm').serializeArray();
		for(i=0;i<arr.length;i=i+2){
			list.push({ [arr[i].name] : arr[i].value,
						[arr[i+1].name] : arr[i+1].value})
		}
		console.log(list);
	})
		$.ajax({
			url:"/sample/addlist",
			method:"post",
			data: JSON.stringify(list) ,
			contentType:"application/json",
			success:function(result){
				console.log("응답결과:", result) 
			}
		})
	</script>
</body>
</html>