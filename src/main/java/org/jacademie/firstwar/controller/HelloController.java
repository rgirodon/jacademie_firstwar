package org.jacademie.firstwar.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.jacademie.firstejb.service.HelloBeanLocal;

@ManagedBean
@RequestScoped
public class HelloController {

	@EJB
	private HelloBeanLocal helloBean;
	
	public String getWelcomeMessage() {
	
		return helloBean.sayHello();
	}
}
