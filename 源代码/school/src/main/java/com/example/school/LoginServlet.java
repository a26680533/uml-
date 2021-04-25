package com.example.school;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.DAO.DAOFactory;
import JavaBean.VO.Student;
import JavaBean.VO.Teacher;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sort = request.getParameter("sort"); // 获得用户登录类型、用户名、密码
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if (sort.equals("student")) {
			Student s = new Student();
			s.setId(id);
			s.setPwd(pwd);
			try {
				if (DAOFactory.getIDAOInstance().findLogin(s)) {

					request.getSession().setAttribute("UNAME", id);
					request.getSession().setAttribute("sort", sort);
					request.getRequestDispatcher("main.jsp").forward(request, response);

				} else {

					request.setAttribute("error", "用户名或密码错误！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (sort.equals("teacher")) {

			Teacher t = new Teacher();
			t.setId(id);
			t.setPwd(pwd);
			try {
				if (DAOFactory.getIDAOInstance().findLogin(t)) {
					request.getSession().setAttribute("UNAME", id);
					request.getSession().setAttribute("sort", sort);
					request.getRequestDispatcher("main.jsp").forward(request, response);

				} else {// 发出错误提示
					request.setAttribute("error", "用户名或密码错误！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}



		}

	}
}
