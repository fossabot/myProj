package com.esp.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
		
		MultipartRequest multi = null;
		int sizeLimit = 10 * 1024 * 1024 ; // 10메가입니다.
		String savePath = "C:\\Temp";//request.getRealPath("/upload");
//		System.out.println(savePath);
		multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy()); 
		
		Article article = new Article();
		String fileName = multi.getFilesystemName("filename");
		System.out.println(fileName);
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		
		article.setName(writer);
		article.setTitle(title);
		article.setContent(content);
		article.setPath(fileName);
		
//		BoardDao dao = new BoardDao();
//		dao.write(article);
		BoardDao.getInstance().write(article);
		
		return true;
	}

}
