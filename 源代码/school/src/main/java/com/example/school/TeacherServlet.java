package com.example.school;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.VO.*;
import net.sf.json.JSONObject;
import JavaBean.DAO.DAOFactory;
import JavaBean.DBC.ResponseUtil;

@WebServlet(name = "TeacherServlet", urlPatterns = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action.equals("approve")) {
			this.approve(request, response);
		}
		if (action.equals("agree")) {
			this.agree(request, response);
		}
		if (action.equals("checkinfo")) {
			this.checkinfo(request, response);
		}

	}

	private void agree(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		try {
			String id = request.getParameter("id");
			String date = request.getParameter("date");
			String status = request.getParameter("status");
			flag = DAOFactory.getIDAOInstance().agree(id,date,status);
			JSONObject result = new JSONObject();
			result.put("success", flag);
			ResponseUtil.write(result, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void approve(HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("UNAME");
		List<Application> list = new ArrayList<>();
		try {
			list = DAOFactory.getIDAOInstance().application(id);

			request.setAttribute("modeName", "申请名单");
			request.setAttribute("mainPage", "teacher/approve.jsp");
			request.setAttribute("application", list);
			request.getRequestDispatcher("main.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	private void checkinfo(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = sdf.format(new Date());
		String id = (String) request.getSession().getAttribute("UNAME");
		List<Student> list = new ArrayList<>();
		try {
			list = DAOFactory.getIDAOInstance().checkinfo(id);

			request.setAttribute("modeName", "打卡情况");
			request.setAttribute("mainPage", "teacher/checkinfo.jsp");
			request.setAttribute("student", list);
			request.setAttribute("date", dateNow);
			request.getRequestDispatcher("main.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}