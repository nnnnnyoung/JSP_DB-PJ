package com.human.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.DAO.boardDAO;
import com.human.VO.boardVO;

/**
 * Servlet implementation class wrAction
 */
@WebServlet("/comAction")
public class comAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comAction() {
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
		
		boardVO bvo=new boardVO();
		int wno=Integer.parseInt(request.getParameter("wno"));
		
		bvo.setNum(wno);
		bvo.setName(request.getParameter("name"));
		bvo.setContent(request.getParameter("content"));
		bvo.setId(request.getParameter("id"));
		
		boardDAO.comIn(bvo);
		
		response.sendRedirect("boderView?wno="+wno); //redirect  boardList서블릿으로 이동한다.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
