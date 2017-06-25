package com.esp.board;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
		String keyword = request.getParameter("keyword");
		List<Article> list = BoardDao.getInstance().getSearchRecord(keyword);
		request.setAttribute("list", list);
		return false;
	}

}
