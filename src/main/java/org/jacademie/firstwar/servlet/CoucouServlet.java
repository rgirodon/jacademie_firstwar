package org.jacademie.firstwar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jacademie.firstejb.service.CoucouBeanLocal;

/**
 * Servlet implementation class CoucouServlet
 */
@WebServlet("/CoucouServlet")
public class CoucouServlet extends HttpServlet {
	
	@EJB
	private CoucouBeanLocal coucouBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoucouServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<HTML>");
		pw.println("<BODY>");
		
		pw.println(coucouBean.ditCoucou());
		
		pw.println("<BR/>");
		
		pw.println("</BODY>");
		pw.println("</HTML>");
	}
}
