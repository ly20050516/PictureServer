package com.ly.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.car.Car;
import com.ly.car.CarItem;
import com.ly.user.User;

public class BuyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String product = request.getParameter("product");

		Integer number = null; // ����
		try {
			// ���յ�����һ��String������ת��ΪInteger�����ת��ʧ�ܣ�����ҳ�������ʾ��Ϣ
			number = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			out.println("�����Ƿ���<a href='/buy.html'>������д</a><br/>");
			return;
			// e.printStackTrace();
		}

		// ͨ��JSESSIONID,��ȡsession�������û�л�ȡ�������´���һ��session����
		HttpSession session = request.getSession();
		// ��session�л�ȡuser���ԵĶ���
		User user = (User) session.getAttribute("user");
		// ��session�л�ȡcar���ԵĶ���
		Car car = (Car) session.getAttribute("car");

		// ֻ�е��û��ѵ�¼���һ�Ʒ��������Ϊ��ʱ���������������ﳵ
		if (user != null && product != null && number != null) {

			CarItem carItem = new CarItem(); // �������ﳵ��
			// UUID.randomUUID().toString()��һ������Ҳ��ظ����ַ��������㹺�ﳵ��Ĳ�ѯ
			carItem.setId(UUID.randomUUID().toString());
			carItem.setProduct(product);
			carItem.setNumber(number);

			// ������ﳵΪ�գ��򴴽�һ�����ﳵ������ӵ�Session
			if (car == null) {
				car = new Car();
				session.setAttribute("car", car);
			}

			car.add(carItem);

			out.println("����ɹ�<br/>");
			out.println("<a href='/buy.html'>��������</a><br/>");
			out.println("<a href='/list'>�����б�</a><br/>");
		} else {
			out.println("<a href='/login.html'>���¼</a><br/>");
		}
	}

}
