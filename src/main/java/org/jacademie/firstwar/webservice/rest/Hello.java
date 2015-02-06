package org.jacademie.firstwar.webservice.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jacademie.firstejb.entity.Student;
import org.jacademie.firstejb.service.HelloBeanLocal;

@Path("/hello")
@RequestScoped
public class Hello {
	
	@EJB
	private HelloBeanLocal helloBean;
	
	@GET
	@Produces("text/plain")
	public String getMessage() {
		return "Hello World !";
	}	
	
	
	@Path("/{name}")
	@GET
	@Produces("text/plain")
	public String getMessage(@PathParam("name") String name) {	
		return "Hello " + name + " !";
	}
	
	
	@POST
	@Consumes("text/plain")
	@Produces("text/plain")
	public String postMessage(String name) {
		return "Hello " + name + " !";
	}
	
	
	@Path("/students")
	@GET
	@Produces({"application/xml"})
	public FindStudentsResponse findStudents() {
		
		FindStudentsResponse result = new FindStudentsResponse();
		result.setStudents(this.helloBean.findAllStudents());
		
		return result;
	}
	
	@Path("/student/{num}")
	@GET
	@Produces({"application/xml", "application/json"})
	public Student findStudentById(@PathParam("num") Integer num) {
		
		return this.helloBean.findStudentByNum(num);
	}
	
	@Path("/student")
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	public String createStudent(Student student) {
		
		Integer num = this.helloBean.createStudent(student);
		
		return "{ \"num\" :  \"" + num + "\" }";
	}
	

}
