package com.esp.board;

import java.util.List;

public class ListVo {    
    private List<Article> list;
    private int totalPage;
    private int listItemNo;
    private int firstPage;
    private int lastPage;
    private int prevPage;
    private int nextPage;
    private int startRecord;
    private int endRecord;
    
    public List<Article> getList() {
        return list;
    }
    public void setList(List<Article> list) {
        this.list = list;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getListItemNo() {
        return listItemNo;
    }
    public void setListItemNo(int listItemNo) {
        this.listItemNo = listItemNo;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getFirstPage() {
        return firstPage;
    }
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }
    public int getLastPage() {
        return lastPage;
    }
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getStartRecord() {
        return startRecord;
    }
    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }
    public int getEndRecord() {
        return endRecord;
    }
    public void setEndRecord(int endRecord) {
        this.endRecord = endRecord;
    }	    
}
