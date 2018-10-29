package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.AdsDao;
import com.housingboard.dao.AdsDaoImpl;
import com.housingboard.model.Ads;

/**
 * Servlet implementation class AdsSummary
 */
@WebServlet("/adDetails/*")
public class AdsSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdsSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		int adID = Integer.parseInt(pathParts[1].toString());
		System.out.println("adID " + adID);
		
		AdsDao summaryOfAd = new AdsDaoImpl();
		HttpSession session = request.getSession(false);
		Ads adDetails = summaryOfAd.getDetailsOfAd(adID);
		
		String viewName = "";
		if(adDetails == null) {
			session.setAttribute("message", "Something went wrong. Please try to login again.");
			viewName = "/suMessage.jsp";
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
//			dispatcher.forward(request, response);
		}else {
			request.setAttribute("summaryOfAd", adDetails);
			viewName = "/adsSummary.jsp";		

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adsSummary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		int adID = Integer.parseInt(pathParts[1].toString());
		System.out.println("adID " + adID);
		
		AdsDao summaryOfAd = new AdsDaoImpl();
		HttpSession session = request.getSession(false);
		Ads adDetails = summaryOfAd.getDetailsOfAd(adID);
		
		String viewName = "";
		if(adDetails == null) {
			session.setAttribute("message", "Something went wrong. Please try to login again.");
			viewName = "/suMessage.jsp";
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
//			dispatcher.forward(request, response);
		}else {
			request.setAttribute("summaryOfAd", adDetails);
			viewName = "/adsSummary.jsp";		

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
