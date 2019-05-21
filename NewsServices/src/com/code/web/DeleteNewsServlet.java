package com.code.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.services.INewsServices;
import com.code.services.impl.NewsServicesImpl;
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteNewsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("nid");
		//System.out.println(id);
		int nid = Integer.parseInt(id);
		INewsServices servicesImpl = new NewsServicesImpl();
		servicesImpl.deleteNews(nid);
		request.getRequestDispatcher("/newsListServlet?currentPage=1").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
