package org.jacademie.firstwar.webservice.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jacademie.firstejb.entity.Student;

@XmlRootElement(name="findStudentsResponse")
public class FindStudentsResponse {

	private Collection<Student> students;

	public FindStudentsResponse() {
		this.students = new ArrayList<Student>();
	}
	
	@XmlElement(name="students")
	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	
}
