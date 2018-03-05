package com.master.datascale.projet.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.master.datascale.projet.bean.Teacher;
import com.master.datascale.projet.dao.IDAOTeacher;
import com.master.datascale.projet.dao.impl.DAOTeacher;


/**
 * The Action Class for all the Administrator Stuffs
 * @author Joy Jedidja
 *
 */
public class ActionAdmin extends Action {
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		System.out.println("Je suis dans ActionAdmin");
		String forward = "admin";
		
//		request.getSession().removeAttribute("user");
//		request.getSession().removeAttribute("login");
//		request.getSession().removeAttribute("success");
//		request.getSession().removeAttribute("validate");
//		request.getSession().removeAttribute("teachers");
		
		String url = request.getServletPath();
		
		if(url.equalsIgnoreCase("/teacher_act.do"))
		{
			List<Teacher> teachers = (List<Teacher>) request.getSession().getAttribute("teachers");
			int position = Integer.parseInt(request.getParameter("teacherId"));
			Teacher teacher = teachers.get(position);
			
			teacher.setActivated(true);
			
			IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");

			daoTeacher.update(teacher);
			
			request.getSession().setAttribute("teachers", teachers);
			
		}
		if(url.equalsIgnoreCase("/teacher_dea.do"))
		{
			List<Teacher> teachers = (List<Teacher>) request.getSession().getAttribute("teachers");
			int position = Integer.parseInt(request.getParameter("teacherId"));
			Teacher teacher = teachers.get(position);
			
			teacher.setActivated(false);
			
			IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");

			daoTeacher.update(teacher);
			
			request.getSession().setAttribute("teachers", teachers);
			
		}
		if(url.equalsIgnoreCase("/teacher_del.do"))
		{
			List<Teacher> teachers = (List<Teacher>) request.getSession().getAttribute("teachers");
			int position = Integer.parseInt(request.getParameter("teacherId"));
			Teacher teacher = teachers.get(position);
			
			IDAOTeacher daoTeacher = (DAOTeacher)context.getBean("DAOTeacher");

			daoTeacher.delete(teacher);
			
			teachers.remove(position);
			
			for(Teacher teach : teachers)
			{
				System.out.println(teach.getId()+" "+teach.isActivated());
			}
			
			request.getSession().setAttribute("teachers", teachers);
			
		}

		
		return mapping.findForward(forward);
	}

}
