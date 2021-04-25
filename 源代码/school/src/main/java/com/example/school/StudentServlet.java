package com.example.school;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.VO.*;
import JavaBean.DAO.DAOFactory;

@WebServlet(name = "StudentServlet", urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if (action.equals("info")) {
			this.info(request, response);
		}
		if (action.equals("addcheck")) {
			this.addcheck(request, response);
		}
		if (action.equals("application")) {
			this.application(request, response);
		}
		if (action.equals("addapplication")) {
			this.addapplication(request, response);
		}

	}
	protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("UNAME");
		Student s;
		try {
			s = DAOFactory.getIDAOInstance().findstudent(id);
			request.setAttribute("modeName", "每日打卡");
			request.setAttribute("mainPage", "student/info.jsp");
			request.setAttribute("student", s);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void addcheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			Checkifo c = new Checkifo();
			c.setSid(request.getParameter("id"));
			c.setSname(request.getParameter("name"));
			c.setDate(request.getParameter("date"));
			c.setHealthy(request.getParameter("healthy"));
			c.setAddress(request.getParameter("address"));

            DAOFactory.getIDAOInstance().addcheck(c);
			Student s = DAOFactory.getIDAOInstance().findstudent(request.getParameter("id"));
			request.setAttribute("student", s);
			request.setAttribute("mainPage", "student/info.jsp");
			request.setAttribute("modeName", "每日打卡");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void application(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("UNAME");
		Student s;
		try {
			s = DAOFactory.getIDAOInstance().findstudent(id);
			request.setAttribute("modeName", "每日打卡");
			request.setAttribute("mainPage", "student/application.jsp");
			request.setAttribute("student", s);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	protected void addapplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("UNAME");
		try {
			Application a = new Application();
			a.setSid(request.getParameter("id"));
			a.setSname(request.getParameter("name"));
			a.setDate(request.getParameter("date"));
			a.setReason(request.getParameter("reason"));
			a.setTid(request.getParameter("tid"));
			a.setTname(request.getParameter("tname"));
			DAOFactory.getIDAOInstance().addapplication(a);

			Student s = DAOFactory.getIDAOInstance().findstudent(id);
			request.setAttribute("modeName", "申请出校");
			request.setAttribute("mainPage", "student/application.jsp");
			request.setAttribute("student", s);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
