package org.jacademie.firstwar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageSenderServlet
 */
@WebServlet("/MessageSenderServlet")
public class MessageSenderServlet extends HttpServlet {
       
	@Resource(mappedName="jms/__defaultConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/Queue")
	private Queue queue;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSenderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Random random = new Random();
			int ticketNumber = random.nextInt(1000);
			
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			
			TextMessage message = session.createTextMessage();
			message.setText("Ticket number to treat : " + ticketNumber);
			
			messageProducer.send(message);
			
			messageProducer.close();
			session.close();
			connection.close();
			
			response.setContentType("text/html");
			
			PrintWriter pw = response.getWriter();
			pw.println("<HTML>");
			pw.println("<BODY>");
			
			pw.println("Your request has been taken into account.");
			pw.println("Here is your ticket number : " + ticketNumber);
			
			pw.println("</BODY>");
			pw.println("</HTML>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
