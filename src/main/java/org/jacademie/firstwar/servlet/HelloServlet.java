package org.jacademie.firstwar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jacademie.firstejb.entity.Student;
import org.jacademie.firstejb.service.HelloBeanLocal;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	
	@EJB
	private HelloBeanLocal helloBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
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
		
		pw.println(helloBean.sayHello("World"));
		
		pw.println("<BR/>");
		
		Collection<Student> students = helloBean.findAllStudents();
				
		pw.println("<UL>");
		
		for (Student student : students) {
		
			pw.println("<LI>");
			pw.println(student.getName());
			pw.println("</LI>");
		}
		
		pw.println("</UL>");
		
		pw.println("</BODY>");
		pw.println("</HTML>");
	}
}
