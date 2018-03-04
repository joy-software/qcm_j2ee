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

import com.master.datascale.projet.bean.Qcm;
import com.master.datascale.projet.dao.IDAOQcm;
import com.master.datascale.projet.dao.impl.DAOQcm;



public class ActionTeacher extends Action {
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		System.out.println("Je suis dans ActionTeacher");
		String forward = "teacher";
		
//		request.getSession().removeAttribute("user");
//		request.getSession().removeAttribute("login");
//		request.getSession().removeAttribute("success");
//		request.getSession().removeAttribute("validate");
//		request.getSession().removeAttribute("teachers");
		
		String url = request.getServletPath();
		
		if(url.equalsIgnoreCase("/createQcm.do"))
		{
			List<Qcm> qcms = (List<Qcm>) request.getSession().getAttribute("qcms");
			
			IDAOQcm daoQcm = (DAOQcm)context.getBean("DAOQcm");

			Qcm donnees = (Qcm)form;
			
			daoQcm.save(donnees);
			
			qcms.add(donnees);
			
			request.getSession().setAttribute("qcms", qcms);
			
			System.out.println("Votre identité: "+donnees);
			
		}		
		if(url.equalsIgnoreCase("/qcm_del.do"))
		{
			List<Qcm> qcms = (List<Qcm>) request.getSession().getAttribute("qcms");
			int position = Integer.parseInt(request.getParameter("qcmId"));
			
			IDAOQcm daoQcm = (DAOQcm)context.getBean("DAOQcm");

			Qcm donnees = qcms.get(position);
			
			daoQcm.delete(donnees);
			
			qcms.remove(position);
			
			request.getSession().setAttribute("qcms", qcms);
		}		

		return mapping.findForward(forward);
	}

}
