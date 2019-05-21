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

import com.code.dao.INewsDao;
import com.code.dao.impl.NewsDaoImpl;
import com.code.domain.News;
import com.code.services.INewsServices;
import com.code.services.impl.NewsServicesImpl;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String nidStr= request.getParameter("nid");
		int nid = 0;
		nid = Integer.parseInt(nidStr);
		JSONObject jsonObject = new JSONObject();
		try {
			INewsServices servicesImpl = new NewsServicesImpl();
			News news = servicesImpl.getNews(nid);
			JSONObject jsonObject2 = new JSONObject();
			Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("nid", news.getNid());
			hashMap.put("title", news.getTitle());
			hashMap.put("body", news.getBody());
			hashMap.put("source", news.getSource());
			hashMap.put("ptime", news.getPtime());
			jsonObject2.put("news", hashMap);
			
			jsonObject.put("ret", 0);
			jsonObject.put("msg", "ok");
			jsonObject.put("data", jsonObject2);
		}catch(Exception e){
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
