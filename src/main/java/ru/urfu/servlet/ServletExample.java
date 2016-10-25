package ru.urfu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FirstServlet", urlPatterns = { "/servlet" })
public class ServletExample extends HttpServlet {
	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.err.println("ServletExample init!");
		super.service(req, res);
	}

	protected void doGet_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.write("hello my dear friend");

	}

	protected void doGet_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.write("<h1>hello my dear friend</h1>");

		Collections.list(req.getParameterNames()).forEach(s -> out.println(
				s + ": " + Arrays.stream(req.getParameterValues(s)).collect(Collectors.joining(",")) + "<br>"));

	}

	protected void doGet_3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession();
		String name = session.getId();

		out.write("<h1>hello my dear friend, " + name + "</h1>");
	}

	protected void doGet_4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String NAME = "name";
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();

		String name = req.getParameter(NAME);
		if (name != null) {
			session.setAttribute(NAME, name);
		} else {
			name = (String) session.getAttribute(NAME);
			if (name == null)
				name = session.getId();
		}

		out.write("<h1>hello my dear friend, " + name + "</h1>");
	}


	protected void doGet_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setHeader("Server", "My Twitter Server");
		resp.setHeader("Content-type", "text/xml"); // resp.setContentType("text/xml");
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // resp.sendError(404);
		out.write("<h1>hello my dear friend</h1>");
	}

	protected void doGet_6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher; 
		requestDispatcher = req.getRequestDispatcher("/form.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service ServletExample");
		super.service(req, resp);
	}

}
