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
   <div id="wrap" align="center">
      <h1>질의응답 등록</h1>
      <form id="modi" name="frm" method="post" action="modiForm2">
         <input type="hidden" name="command" value="board_write">
         <table>
			<tr>
               <th>글번호</th>
               <td>
               	<input type="hidden" name="num" value="${modi.getNum()}">
            	   ${modi.getNum()}
               </td>
            </tr>
            <tr>
               <th>작성자</th>
               <td><input type="text" name="name" value="${modi.getName()}">  비밀글 설정<input id="checkbox" type="checkbox" size="70" name=chkbox value="Y">  * 필수    </td>
            </tr>
           <tr>
               <th>ID</th>
               <td><input type="text" size="70" value="${modi.getId()}" name="id" id='id'><input type="button" id="idchk" value="아이디 확인">   * 필수</td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" value="${modi.getTitle()}" name="title"></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="text" size="70" value="${modi.getPass()}" name="pass"> * 필수</td>
            </tr>            
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="content">${modi.getContent()}</textarea></td>
            </tr>
          
            
         </table>
         <br>
         <br> <input type="button" value="등록" onclick="chk()"> <input type="reset"
            value="다시 작성"> <input type="button" value="목록" onclick="location.href='boardList';">
      </form>
   </div>
   
   
</body>

<script>

	var useId=/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,}/;
	var chkId=false;
	
	document.getElementById('idchk').onclick=()=>{
		var id=document.getElementById('id').value;
		if(!useId.test(id)){
			alert('8글자 이상, 특수문자 포함해 주세요');
		}else{
			alert('사용가능한 아이디입니다.');
			chkId=true;			
		}		
	}
	
	chk=()=>{
		let join=document.getElementById('join');
		if(!chkId){
			alert('아이디 확인을 진행해주세요');			
		}else{
			document.getElementById('modi').submit();
			alert('등록완료');			
		}
	}
	
	


</script>
</html>