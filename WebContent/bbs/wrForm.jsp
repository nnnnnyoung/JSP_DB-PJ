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
      <form name="frm" method="post" action="wrAction">
         <input type="hidden" name="command" value="board_write">
         <table>
			<tr>
               <th>글번호</th>
               <td><% int num=(int)request.getAttribute("num"); 
               out.print(num+1);   
               %>
               
               </td>
            </tr>
            <tr>
               <th>작성자</th>
               <td><input type="text" name="name">  비밀글 설정<input id="checkbox" type="checkbox" size="70" name=chkbox value="Y">  * 필수    </td>
            </tr>
           <tr>
               <th>ID</th>
               <td><input type="text" size="70" name="id">  * 필수</td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="title"></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="text" size="70" name="pass"> * 필수</td>
            </tr>            
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="content"></textarea></td>
            </tr>
          
            
         </table>
         <br>
         <br> <input type="submit" value="등록"> <input type="reset"
            value="다시 작성"> <input type="button" value="목록">
      </form>
   </div>
   
   
</body>

<script>

	function is_checked() {
	  
	// 1. checkbox element를 찾습니다.
	const checkbox = document.getElementById('checkbox');

	// 2. checked 속성을 체크합니다.
	const is_checked = checkbox.checked;

	// 3. 결과를 출력합니다.
	document.getElementById('result').innerText = is_checked;
	  
	}


</script>
</html>