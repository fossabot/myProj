package com.esp.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		
		ArticleDTO article = BoardDao.getInstance().selectOne(Integer.parseInt(id));
		request.setAttribute("article", article);
		return false;
	}

}
