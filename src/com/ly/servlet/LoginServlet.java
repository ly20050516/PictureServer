package com.ly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.user.User;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取输出流
		PrintWriter out = response.getWriter();

		// 接收到的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null && username != null && !"".equals(username)
				&& password != null && !"".equals(password)) {

			user = new User();
			user.setPassword(password);
			user.setUsername(username);

			session.setAttribute("user", user);
			out.println("欢迎回来：<b>" + user.getUsername()
					+ "</b> <a href='/logout'>注销</a><br/>");
			out.println("<a href='/buy.html'>购物</a><br/>");
			out.println("<a href='/list'>管理购物</a>");
		} else if (user != null && username == null && password == null) {
			out.println("欢迎回来：<b>" + user.getUsername()
					+ "</b> <a href='/logout'>注销</a><br/>");
			out.println("<a href='/buy.html'>购物</a><br/>");
			out.println("<a href='/list'>管理购物</a>");
		} else {
			out.println("<a href='/login.html'>重新登录</a>");
		}
	}
}
