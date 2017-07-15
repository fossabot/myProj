package com.esp.board;

public class Article {
    private int no;
    private String title;
    private String content;
    private String path;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        if (content == null) content = "";
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setPath(String path) {
    	if (path.length() == 0)
    		this.path = "파일 저장 하지 않음.";
    	else 
    		this.path = path;
    }
    
    public String getPath() {
    	return this.path;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
}