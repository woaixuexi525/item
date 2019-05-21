package com.code.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.domain.News;
import com.code.services.INewsServices;
import com.code.services.impl.NewsServicesImpl;

public class NewsForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsForwardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		//System.out.println(cid);
		INewsServices servicesImpl = new NewsServicesImpl();
		News news = servicesImpl.getNews(Integer.parseInt(nid));
		//System.out.println(news);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/admin/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
