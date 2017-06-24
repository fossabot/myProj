package com.esp.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {

			System.out.println("DeleteCommand");
			String temp = request.getParameter("unit");
			if(temp != null) {
				String[] unit = temp.split(",");
				int size = unit.length;
				for(int i = 0;i<size;++i){
					System.out.println(unit[i].toString());
					BoardDao.getInstance().delete(Integer.parseInt(unit[i]));
				}
			}
			
		return true;
	}
}
