package com.ly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.car.Car;
import com.ly.car.CarItem;
import com.ly.user.User;

public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		Car car = (Car) session.getAttribute("car");
		User user = (User) session.getAttribute("user");

		if (user == null) {
			out.println("还没登录。<a href='/login.html'>请登录</a>");
			return;
		}

		out.println("<b>" + user.getUsername() + "</b> 的购物车<br/>");

		if (car != null) {
			for (CarItem carItem : car.list()) {
				out.println("商品：" + carItem.getProduct() + " 数量："
						+ carItem.getNumber() + " <a href='/delete?id="
						+ carItem.getId() + "'>删除</a>");
				out.println("<hr>");
			}
		} else {
			out.println("还没购物车，所以没内容");
		}
	}
}
