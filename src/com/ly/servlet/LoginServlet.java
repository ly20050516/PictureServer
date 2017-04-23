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
		// ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ�����
		PrintWriter out = response.getWriter();

		// ���յ��Ĳ���
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
			out.println("��ӭ������<b>" + user.getUsername()
					+ "</b> <a href='/logout'>ע��</a><br/>");
			out.println("<a href='/buy.html'>����</a><br/>");
			out.println("<a href='/list'>������</a>");
		} else if (user != null && username == null && password == null) {
			out.println("��ӭ������<b>" + user.getUsername()
					+ "</b> <a href='/logout'>ע��</a><br/>");
			out.println("<a href='/buy.html'>����</a><br/>");
			out.println("<a href='/list'>������</a>");
		} else {
			out.println("<a href='/login.html'>���µ�¼</a>");
		}
	}
}
