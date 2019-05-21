package com.code.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.domain.News;
import com.code.services.INewsServices;
import com.code.services.impl.NewsServicesImpl;

/**
 * Servlet implementation class UpdateNewsServlet
 */
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateNewsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("nid");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String digest = request.getParameter("digest");
		String source = request.getParameter("source");
		String content = request.getParameter("content");

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ptime = sf.format(new Date());
		int nid = Integer.parseInt(id);
		int cid = Integer.parseInt(category);
		News news = new News(nid,cid, title, digest, content, source, ptime);
		//System.out.println(news);
		INewsServices servicesImpl = new NewsServicesImpl();
		servicesImpl.updateNews(news);
		request.getRequestDispatcher("/newsListServlet?currentPage=1").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
