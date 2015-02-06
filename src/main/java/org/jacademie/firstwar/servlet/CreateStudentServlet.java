package org.jacademie.firstwar.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jacademie.firstejb.entity.Student;
import org.jacademie.firstejb.service.HelloBeanLocal;

/**
 * Servlet implementation class CreateStudent
 */
@WebServlet("/CreateStudent")
public class CreateStudentServlet extends HttpServlet {

	@EJB
	private HelloBeanLocal helloBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateStudentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			sb = new StringBuilder("");
		}

		if (!"".equals(sb.toString())) {
			
			Student student = new Student();
			student.setName(sb.toString());
			
			helloBean.createStudent(student);
	
			response.setContentType("text/plain");
	
			PrintWriter pw = response.getWriter();
	
			pw.println("Student created with num : " + student.getNum());
		}
		else {
			response.setContentType("text/plain");
			
			PrintWriter pw = response.getWriter();
	
			pw.println("No student created");
		}
	}
}
