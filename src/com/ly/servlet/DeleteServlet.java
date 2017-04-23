package com.ly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.car.Car;
import com.ly.user.User;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();  
		  
        // ��ȡsession�����ʹ��JSESSIONIDû���ҵ��򴴽�һ��  
        HttpSession session = request.getSession();  
        // ��ȡsession��������Ϊuser�Ķ���  
        User user = (User) session.getAttribute("user");  
        // ��ȡsession��������Ϊcar�Ķ���  
        Car car = (Car) session.getAttribute("car");  
  
        // ������Ҫɾ���Ĺ��ﳵ���id  
        String id = request.getParameter("id");  
  
        // ����û��ѵ�¼��������ִ�У�������ҳ�������ʾ��Ϣ  
        if (user != null) {  
            // ��car�������ʱ���ŴӴ˹��ﳵ��ɾ�����ﳵ���ת���idҲ��Ϊ��  
            if (car != null && id != null && !"".equals(id)) {  
                car.remove(id);  
  
                out.println("ɾ���ɹ�<br/>");  
                out.println("<a href='/buy.html'>��������</a><br/>");  
                out.println("<a href='/list'>�����б�</a><br/>");  
            } else {  
                out.println("Ҳ��û����...");  
            }  
        } else {  
            out.println("��û��¼����ֹ������<a href='/login.html'>���ص�¼</a>");  
        }  
	}
}
