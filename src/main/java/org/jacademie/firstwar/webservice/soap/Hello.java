package org.jacademie.firstwar.webservice.soap;

import java.util.Collection;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.jacademie.firstejb.entity.Student;
import org.jacademie.firstejb.service.HelloBeanLocal;

@WebService
public class Hello {

	private String message = "Hello ";
	
	@EJB
	private HelloBeanLocal helloBean;
	
	public Hello() {
	}
	
	@WebMethod
	@WebResult(name="response")
	public String sayHello(@WebParam(name="name") String name) {
		return message + name + " !!!";
	}
	
	@WebMethod
	@WebResult(name="Student")
	public Collection<Student> findStudents() {
		
		return this.helloBean.findAllStudents();
	}
	
	@WebMethod
	@WebResult(name="Student")
	public Student findStudentById(@WebParam(name="num") Integer num) {
		
		return this.helloBean.findStudentByNum(num);
	}
	
	@WebMethod
	@WebResult(name="Id")
	public Integer createStudent(@WebParam(name="Student") Student student) {
		
		return this.helloBean.createStudent(student);
	}
	
}
