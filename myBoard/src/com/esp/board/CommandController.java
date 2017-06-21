package com.esp.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String command;
	private Command cmd;
	private HashMap<String,Command> commandMap;
	private HashMap<String,String> viewMap;
	private ServletContext sc;
	private RequestDispatcher rd;
	private boolean isRedirect;
	
	public CommandController(){
		super();
		System.out.println("CommandController »ý¼º");
		command = null;
		cmd = null;
		sc = null;
		rd = null;
		isRedirect = false;
		
		viewMap = new HashMap<String,String>();
		commandMap = new HashMap<String,Command>();
		commandMap.put("/list.do", new ListCommand());
		commandMap.put("/write.do", new WriteCommand());
		commandMap.put("/delete.do", new DeleteCommand());
		viewMap.put("/list.do", "/BoardList.jsp");
		viewMap.put("/write_form.do", "/WriteForm.jsp");
		viewMap.put("/write.do", "list.do");
		viewMap.put("/delete.do", "list.do");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String contextPath = request.getContextPath();
        command = uri.substring(contextPath.length());
        
        System.out.println(command);     
        
        try {
        	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
        	
        	cmd = commandMap.get(command);
        	if(cmd != null)
        		isRedirect = cmd.execute(request, response);
        	
        	String view = viewMap.get(command).toString();
        	if (isRedirect == false) {       		
        		System.out.println(view + " forward");
        		RequestDispatcher disp = request.getRequestDispatcher(view);
        		disp.forward(request, response);
        	} else {
        		System.out.println(view + " sendRedirect");
        		response.sendRedirect(view);
        	}       	
        	System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");      	
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doPost(request,response);
	}
}
