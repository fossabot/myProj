package com.esp.board;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class BoardDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private static final BoardDao instance = new BoardDao();
	
	private BoardDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://172.20.10.5:3306/Board","root", "choon27");
			if (conn != null)
				System.out.println("DB Connect Ok");
			
		} catch (ClassNotFoundException e) {
			System.out.println("[ClassNotFound] " + e.getMessage());
		} catch (SQLException e){
			System.out.println("[SQLExcept] " + e.getMessage());
		}			
	}
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public List<Article> getBoardList() {
		List<Article> list = new ArrayList<Article>();
        String sql = "select * from board";
        
        try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
			    Article article = new Article();
			    article.setNo(rs.getInt("id"));
			    article.setTitle(rs.getString("title"));
			    article.setPath(rs.getString("path"));
			    article.setContent(rs.getString("contents"));
			    article.setName(rs.getString("name"));
			    
			    list.add(article);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
        return list;
	}

	public List<Article> getSearchRecord(String keyword) {
		String sql = "select title,path,name from board where title=?";
		List<Article> list = new ArrayList<Article>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, keyword);
			rs = stmt.executeQuery();
			while (rs.next()) {
			    Article article = new Article();
			    article.setNo(rs.getInt("id"));
			    article.setTitle(rs.getString("title"));
			    article.setPath(rs.getString("path"));
			    article.setContent(rs.getString("contents"));
			    article.setName(rs.getString("name"));
			    
			    list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void write(Article article) {		
		try {
			String sql = "insert into board(title,name,path,contents) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,article.getTitle().toString());
			stmt.setString(2, article.getName().toString());
			stmt.setString(3, article.getPath().toString());
			stmt.setString(4, article.getContent().toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public Article selectOne(int no) {
		Article article = new Article();
		String sql = "select * from board where id = ?";	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			while (rs.next()) {
			    article.setNo(rs.getInt("id"));
			    article.setTitle(rs.getString("title"));
			    article.setPath(rs.getString("path"));
			    article.setContent(rs.getString("contents"));
			    article.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	public void update(Article article) {
		
	}

	public void delete(int no) {
		try {
			String sql = "delete from board WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
