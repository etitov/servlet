package ru.urfu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.util.MultiMap;

@WebServlet(urlPatterns = { "/saveUser" })
public class SaveUserInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		Collections.list(req.getParameterNames()) .forEach(s -> out.println(s +
				  " " + Arrays.stream(req.getParameterValues(s))
				  .collect(Collectors.joining(","))) );
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String body = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
	
		
		HttpURI uri = new HttpURI("/servlet?"+body);
		MultiMap<String> mm = new MultiMap<>();
		uri.decodeQueryTo(mm);
		
		
		out.println(body);
	}

	
	
}
