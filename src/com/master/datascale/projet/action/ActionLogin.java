package com.master.datascale.projet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.master.datascale.projet.bean.User;
import com.master.datascale.projet.dao.IDAOUser;
import com.master.datascale.projet.dao.impl.DAOUser;



public class ActionLogin extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		
		IDAOUser daoUser = (DAOUser)context.getBean("DAOUser");
		
		User donnees = (User)form;
		
		boolean check = daoUser.checkCredentials(donnees.login, donnees.password);
		
		request.getSession().setAttribute("login",new Boolean(check));
		

		System.out.println("Je suis dans ActionLogin");
		System.out.println("Votre identité: "+donnees);
		
		if(!check){
			return mapping.findForward("login");
		}
		else
		{

			return mapping.findForward("admin");
		}
		
	}

}
