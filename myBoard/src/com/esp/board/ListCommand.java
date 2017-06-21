package com.esp.board;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements Command {

	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
        
		List<Article> list = BoardDao.getInstance().getBoardList();
//        List<Article> list = dao.getBoardList();
        System.out.println(list.size());
        request.setAttribute("list", list);
        
        return false;
	}

}
