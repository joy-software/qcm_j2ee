package com.master.datascale.projet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.master.datascale.projet.bean.Student;
import com.master.datascale.projet.bean.Teacher;
import com.master.datascale.projet.dao.IDAOStudent;
import com.master.datascale.projet.dao.IDAOTeacher;
import com.master.datascale.projet.dao.impl.DAOStudent;
import com.master.datascale.projet.dao.impl.DAOTeacher;



public class ActionRegister extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		String url = request.getServletPath();
		String forward = "login";
		String type = "";
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		
		System.out.println(url); //Register.do
		System.out.println("Je suis dans ActionRegister");
		
		if(url.equalsIgnoreCase("/Register.do"))
		{
			type = request.getParameter("type");
			System.out.println(type);
			if(type.equalsIgnoreCase("teacher"))
			{
				forward = "t_register";
			}
			else
			{
				forward = "s_register";
			}
		}
		if(url.equalsIgnoreCase("/s_Register.do"))
		{
			IDAOStudent daoStudent = (DAOStudent)context.getBean("DAOStudent");
			
			Student donnees = (Student)form;
			
			Boolean loginValidate = daoStudent.validateLogin(donnees.getLogin());
			
			if(loginValidate)
			{
				request.getSession().removeAttribute("badlogin");
				donnees.setType(2);
				daoStudent.save(donnees);
				request.getSession().setAttribute("success","Registration complete, try login!!!");
				
				System.out.println("Votre identité: "+donnees);
			}
			else
			{
				request.getSession().removeAttribute("success");
				request.getSession().setAttribute("bad login","This login is already used!!");
				forward = "s_register";
			}
		}
		if(url.equalsIgnoreCase("/t_Register.do"))
		{
			IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");
			
			Teacher donnees = (Teacher)form;
			Boolean loginValidate = daoTeacher.validateLogin(donnees.getLogin());
			
			if(loginValidate)
			{
				request.getSession().removeAttribute("login");
				donnees.setType(1);
				daoTeacher.save(donnees);
				request.getSession().setAttribute("success","Registration complete, try login!!!");
				
				System.out.println("Votre identité: "+donnees);
			}
			else
			{
				request.getSession().removeAttribute("success");
				request.getSession().setAttribute("login","This login is already used!!");
				forward = "t_register";
			}
		}
		

		return mapping.findForward(forward);
				
	}

}
