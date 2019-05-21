package com.code.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.code.domain.Category;
import com.code.domain.News;
import com.code.services.ICategoriesServices;
import com.code.services.impl.CategoriesServicesImpl;

/**
 * Servlet implementation class CategoriesServlet
 */
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求参数
		String cidStr = request.getParameter("cid");
		String startNidStr = request.getParameter("startnid");
		String countStr = request.getParameter("count");
		int cid = 0;
		int startNid = 0;
		int count = 0;
		cid = Integer.parseInt(cidStr);
		startNid = Integer.parseInt(startNidStr);
		count = Integer.parseInt(countStr);

		

		// 转换成JSON对象
		JSONObject jsonObject = new JSONObject();
		
		try {
			ICategoriesServices servicesImpl = new CategoriesServicesImpl();
			List<Map<String, Object>> list = new ArrayList<>();
			List<News> listNews = servicesImpl.getSpecifyCategoryNews(cid, startNid, count);
			for (News news : listNews) {
				Map<String, Object> map = new HashMap<>();
				map.put("nid", news.getNid());
				map.put("title", news.getTitle());
				map.put("digest", news.getDigest());
				map.put("source", news.getSource());
				map.put("ptime", news.getPtime());
				list.add(map);
			}
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("totalnum", listNews.size());
			jsonObject2.put("newslist", list);

			jsonObject.put("ret", 0);
			jsonObject.put("msg", "ok");
			jsonObject.put("data", jsonObject2);
			
		} catch (Exception e) {
			e.printStackTrace();
			try
			{
				jsonObject.put("ret", 1);
				jsonObject.put("msg", e.getMessage());
				jsonObject.put("data", "");
			} catch (JSONException ex)
			{
				ex.printStackTrace();
			}
		}
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
