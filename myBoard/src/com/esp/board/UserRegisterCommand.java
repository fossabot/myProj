package com.esp.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
		
		String userID = request.getParameter("userID");
		String userPassword1 = request.getParameter("userPassword1");
		String userPassword2 = request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userAge = request.getParameter("userAge");
		
		if(userPassword1.equals(userPassword2)) {
			request.getSession().setAttribute("messageType", "오류메시지");
			request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다.");
			return true;
		}
			
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserID(userID);
		userDTO.setUserPassword(userPassword1);
		userDTO.setUserName(userName);
		userDTO.setUserGender(userGender);
		userDTO.setUserEmail(userEmail);
		userDTO.setUserAge(Integer.parseInt(userAge));
		
		int ret = BoardDao.getInstance().registerUser(userDTO);
		
		if(ret < 1 ) {
			request.getSession().setAttribute("messageType", "오류메시지");
			request.getSession().setAttribute("messageContent", "회원가입이 실패했습니다.");
			return true;
		}
		return false;
	}

}
