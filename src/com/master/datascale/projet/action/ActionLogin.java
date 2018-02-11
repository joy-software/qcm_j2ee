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
import com.master.datascale.projet.dao.IDAOTeacher;
import com.master.datascale.projet.dao.IDAOUser;
import com.master.datascale.projet.dao.impl.DAOTeacher;
import com.master.datascale.projet.dao.impl.DAOUser;



public class ActionLogin extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		System.out.println("Je suis dans ActionLogin");
		String forward = "login";
		
		
		if(request.getSession().getAttribute("user") != null)
		{
			User user = (User) request.getSession().getAttribute("user");
			int type = user.getType();
			System.out.println("Je suis dans user :"+ user);
			
			if(type == 0)
			{
				forward = "admin";
			}
			else
			{
				if(type == 1)
				{
					forward = "teacher";
				}
				else
				{
					forward = "student";
				}
			}
			
		}
		else
		{
						
			String url = request.getServletPath();
			
			if(!(url.equalsIgnoreCase("/s_Register.do") || url.equalsIgnoreCase("/t_Register.do")
					|| url.equals("/login.do")))
			{
				IDAOUser daoUser = (DAOUser)context.getBean("DAOUser");

				User donnees = (User)form;
				
				boolean check = daoUser.checkCredentials(donnees.getLogin(), donnees.getPassword());
				request.getSession().removeAttribute("login");
				request.getSession().removeAttribute("validate");
				
				System.out.println("Votre identité: "+donnees);

				if(!check){
					request.getSession().setAttribute("login",new Boolean(check));
				}
				else
				{
					User user = daoUser.getUser(donnees.getLogin(), donnees.getPassword());
					int type = user.getType();
					
					if(type == 1)
					{
						forward = "teacher";
						IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");

						if(daoTeacher.isValidated(user.getId()))
						{
							request.getSession().setAttribute("user",user);						
							forward = "teacher";
						}
						else
						{
							request.getSession().setAttribute("validate","Your account is not yet validated!! ");
							forward = "login";
						}
					}
					else
					{
						request.getSession().setAttribute("user",user);						
						if(type == 0)
						{
							IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");
							request.getSession().setAttribute("teachers",daoTeacher.getAll());
							forward = "admin";
						}
						else
						{
							forward = "student";
						}
					}
					request.getSession().removeAttribute("success");

				}
			}

		}				

		System.out.println(forward);
		return mapping.findForward(forward);
	}

}
