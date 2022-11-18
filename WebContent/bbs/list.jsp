<%@page import="com.human.VO.boardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
	<%@ page import="java.util.*" %>
   <div id="wrap" align="center">
      <h1>질의응답 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="wrForm">질의응답 등록</a></td>
         </tr>
         <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>            
            <th>아이디</th>
            <th>작성일</th>
         </tr>
         <%
         	ArrayList<boardVO> al=(ArrayList)request.getAttribute("blist");
         	for(int i=0; i<al.size(); i++){
         		boardVO bvo=al.get(i);
         		out.print("<tr class='record'>");
         		out.print("<td><a href='"+request.getContextPath()+"/boderView?wno="+bvo.getNum()+"'>" + bvo.getNum() + "</td>");
         		if(bvo.getChkbox().equals("N")){
         			out.print("<td>"+bvo.getTitle()+"* </td>");
         		}else{
         			out.print("<td>"+bvo.getTitle()+"</td>");
         		}
         		out.print("<td>"+bvo.getName()+"</td>");
         		out.print("<td>"+bvo.getId()+"</td>");
         		out.print("<td>"+bvo.getIndate()+"</td>");
         		out.print("</tr>");
         	}
         %>

      </table>
   </div>
</body>


</html>