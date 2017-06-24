package com.esp.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, InterruptedException {
		request.setCharacterEncoding("UTF-8");
		boolean flag = false;
		File file = null;
		InputStream in = null;
		OutputStream os = null;
		String filename = request.getParameter("filename");
		
		try {
			file = new File("/Users/zack27/temp",filename);
			in = new FileInputStream(file);
		} catch(FileNotFoundException e) {
			flag = false;
			System.out.println(e.getMessage());
		}
				
		String client = request.getHeader("User-Agent");
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "JSP Generated Data");
		
		if(flag == false) {
			if(client.indexOf("MSIE") != -1) {
				response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("KCS5601"),"ISO8859_1"));
			}else{
				filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
				
				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
				response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
			
			response.setHeader("Content-Length", ""+file.length());
			
			os = response.getOutputStream();
			byte b[] = new byte[(int)file.length()];
			int leng = 0;
			while((leng = in.read(b)) > 0) {
				os.write(b,0,leng);
			}
		}else{
			response.setContentType("text/html;charset=UTF-8");
			
		}
		
		in.close();
		os.close();
		return true;
	}

}
