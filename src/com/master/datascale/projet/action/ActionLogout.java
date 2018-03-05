package com.master.datascale.projet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * The Action that handles the logout
 * @author Joy Jedidja
 *
 */
public class ActionLogout extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("Je suis dans ActionLogout");
		
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("login");
		request.getSession().removeAttribute("success");
		request.getSession().removeAttribute("validate");
		request.getSession().removeAttribute("teachers");
		request.getSession().removeAttribute("qcms");
		request.getSession().removeAttribute("selectedQcm");
		request.getSession().removeAttribute("questions");
		
		String forward = "login";
		return mapping.findForward(forward);
	}

}
