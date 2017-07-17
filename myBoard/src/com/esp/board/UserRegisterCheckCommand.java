package com.esp.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ajax 서블릿  annotation추가됨 --> import javax.servlet.annotation.WebServlet;
@WebServlet("/UserRegisterCheckCommand")
public class UserRegisterCheckCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userID = request.getParameter("userID");
		response.getWriter().write(BoardDao.getInstance().checkUser(userID) + ""); 
		//checkUser는 정수값 리턴한다. 문자열 형태로 리턴하기 위해 공백 문자 "" 를 append 처리 하였다. 
	}
}
