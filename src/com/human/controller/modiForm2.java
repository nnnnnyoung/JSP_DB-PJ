package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.DAO.boardDAO;
import com.human.VO.boardVO;

/**
 * Servlet implementation class wrForm
 */
@WebServlet("/modiForm2")
public class modiForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boardDAO bdao=new boardDAO() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modiForm2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		boardDAO boardDAO=new boardDAO(); 
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html; charset=UTF-8");
		
		String chkbox=request.getParameter("chkbox");
		int num=Integer.parseInt(request.getParameter("num"));
		boardVO boardvo=new boardVO(); 
		if(chkbox==null){
			boardvo.setChkbox("N");
		}else {
			boardvo.setChkbox("Y");
		}
		boardvo.setNum(num);
		boardvo.setName(request.getParameter("name"));
		boardvo.setId(request.getParameter("id"));
		boardvo.setTitle(request.getParameter("title"));
		boardvo.setPass(request.getParameter("pass"));
		boardvo.setContent(request.getParameter("content"));
		
		System.out.println(boardvo.getChkbox());
		
		if(boardvo.getName()!=null && boardvo.getId()!=null && boardvo.getPass()!=null) {
			boardDAO.update(boardvo);
			System.out.println("완료");
		}else {
			System.out.println("필수항목을 입력해주세요");
		}
		
		
		response.sendRedirect("boardList"); //redirect  boardList서블릿으로 이동한다.

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
