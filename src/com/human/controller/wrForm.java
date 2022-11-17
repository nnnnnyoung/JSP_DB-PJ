package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.DAO.boardDAO;

/**
 * Servlet implementation class wrForm
 */
@WebServlet("/wrForm")
public class wrForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boardDAO bdao=new boardDAO() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wrForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int num=bdao.wrnum();
		System.out.println(num+"확인");
		String url="bbs/wrForm.jsp";
		RequestDispatcher dispacher= request.getRequestDispatcher(url);
		request.setAttribute("num", num);
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
