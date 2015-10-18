package com.codeCoder.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeCoderAPI extends HttpServlet {

	private static final long serialVersionUID = 7864063388460272352L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		IBaseService iBaseService = new CodeCoderService();

		PrintWriter out = resp.getWriter();
		out.println(iBaseService.action(req));
		out.flush();
		out.close();

	}

}
