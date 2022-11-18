<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.human.VO.boardVO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th colspan="1">글번호</th>
				<td colspan="3">${board.getNum()}</td>
			</tr>
			<tr>
				<th colspan="1">작성자</th>
				<td colspan="1">${board.getName()}</td>
				<th colspan="1">비밀글</th>
				<td colspan="1">${board.getChkbox()}</td>
			</tr>
			<tr>
				<th colspan="1">작성일</th>
				<td colspan="3">${board.getIndate()}</td>
			</tr>
			<tr>
				<th colspan="1">제목</th>
				<td colspan="3">${board.getTitle()}</td>
			</tr>
			<tr>
				<th colspan="1">내용</th>
				<td colspan="3">${board.getContent()}</td>
			</tr>


		</table>

		<table>
			<th colspan=4>댓글 작성</th>
			<form id="com" action="comAction">
			<tr>
				<th colspan="1">아이디</th>

				<td colspan="1"><input type="text" id="id" name="id">
					<input type="hidden" value="${board.getNum()}" name="wno">
				</td>

				<th colspan="1">이름</th>
				<td colspan="1"><input type="text" name="name" id="name"></td>
			</tr>

			<tr>
				<th colspan="1">내용</th>
				<td colspan="2"><textarea cols="80" rows="8" name="content"></textarea></td>
				<td colspan="2"><input type="button" value="등록" onclick=chk()></td>
			</tr>
			</form>
		</table>


		<table>
			<tr>
				<th colspan="4">댓글</th>
			</tr>
			<tr>
				<td colspan="1">ID</td>
				<td colspan="1">이름</td>
				<td colspan="1">댓글</td>
				<td colspan="1">작성일자</td>


			</tr>
			<%
         	ArrayList<boardVO> clist=(ArrayList)request.getAttribute("comment");
         	if(clist.size()==0){
         		out.print("<tr class='record'>");

         		out.print("<td colspan='4'>등록된 댓글이 없습니다.</td>");
         		out.print("</tr>");
         	}else{

	         	for(int i=0; i<clist.size(); i++){
	         		boardVO bvo=clist.get(i);
	         		out.print("<tr class='record'>");
	         		out.print("<td>"+bvo.getId()+"</td>");
	         		out.print("<td>"+bvo.getName()+"</td>");
	         		out.print("<td>"+bvo.getContent()+"</td>");
	         		out.print("<td>"+bvo.getIndate()+"</td>");
	         		out.print("</tr>");
	         	}	     		
	     	}
         %>

		</table>
		<br> <br> 
			<form id="modi" action="modiForm">
			<input type="hidden" value="${board.getNum()}" name=modi >
			<input type="submit" value="게시글 수정" > 
			</form>
			<form id="del" action="delForm">
			<input type="hidden" value="${board.getNum()}" name=del >
			<input type="submit" value="게시글 삭제" onclick="del()">
			</form> 
			<input type="button" value="게시글 리스트" onclick="location.href='boardList';"> 
			<input type="button" value="게시글 등록" onclick="location.href='wrForm';">
	</div>

	<script type="text/javascript">
	var useId=/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,}/;
	
	chk=()=>{
		var id=document.getElementById('id').value;
		if(!useId.test(id)){
			alert('ID는 8글자 이상, 특수문자 포함해 주세요');
		}else{
			document.getElementById('com').submit();
			alert('등록완료');			
		}		
	}
	
	del=()=>{
		alert('삭제완료');
	}

	
	
	</script>
</body>
</html>