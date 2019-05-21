package com.code.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.domain.User;
import com.code.services.IUserLoginServices;
import com.code.services.impl.UserLoginServicesImpl;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		User user = new User();
		user.setName(name);
		user.setPasswd(passwd);
		//System.out.println(name + passwd);
		IUserLoginServices servicesImpl = new UserLoginServicesImpl();
		boolean flag = servicesImpl.check(user);
		//System.out.println(flag);
		if(flag) {
			request.getRequestDispatcher("/admin/main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
