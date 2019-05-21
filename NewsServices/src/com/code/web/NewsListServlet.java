package com.code.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.domain.News;
import com.code.domain.PageBean;
import com.code.services.INewsServices;
import com.code.services.impl.NewsServicesImpl;

/**
 * Servlet implementation class NewsListServlet
 */
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String currentPage = request.getParameter("currentPage");
		//System.out.println(currentPage);
		INewsServices servicesImpl = new NewsServicesImpl();
		int currenPage = Integer.parseInt(currentPage);
		int pageSize = 10;
		PageBean<News> pageBean = servicesImpl.findByPage(currenPage, pageSize);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
