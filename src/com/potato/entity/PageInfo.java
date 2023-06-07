package com.potato.entity;

import com.potato.service.GoodsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author potato
 * @PackageName:com.potato.entity
 * @Description: TODO  分页
 * @Date 2022-12-13 10:35
 */

public class PageInfo {
    List list; // 查询的数据

    int currentPage = 1; // 当前页号
    int recordSize = 5; // 第页记录数
    int recordCount  ; // 总记录数

    String uri ; // 请求地址
    String method ; // 请求方法

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPageCount(){
        return this.recordCount%this.recordSize==0 ?
               this.recordCount/this.recordSize :
               this.recordCount/this.recordSize+1;
    }

    /**
     * 构造方法
     * @param request
     */
    public PageInfo(HttpServletRequest request) {
        String currentPage = request.getParameter("currentPage");
        if (currentPage != null){
            this.setCurrentPage(Integer.valueOf(currentPage));
        }
        // 给url赋值
        this.uri = request.getRequestURI().toString();
        System.out.println("this.uri"+this.uri);

        String method = request.getParameter("method");
        if (method != null){
            this.method = method;
        }

        // 传递pageInfo
        request.setAttribute("pageInfo",this);
    }

//    GoodsServiceImpl goodsService = new GoodsServiceImpl();
//    PageInfo pageInfo = new PageInfo(req);
//            pageInfo.setRecordCount(client.size());
//            goodsService.selectPage(u.getId(),pageInfo);
//            session.setAttribute("pageInfo",pageInfo);


}
