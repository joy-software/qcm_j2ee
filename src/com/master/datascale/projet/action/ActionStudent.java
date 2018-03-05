package com.master.datascale.projet.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.master.datascale.projet.bean.Answer;
import com.master.datascale.projet.bean.Qcm;
import com.master.datascale.projet.bean.Question;
import com.master.datascale.projet.bean.Teacher;
import com.master.datascale.projet.dao.IDAOAnswer;
import com.master.datascale.projet.dao.IDAOQcm;
import com.master.datascale.projet.dao.IDAOQuestion;
import com.master.datascale.projet.dao.impl.DAOAnswer;
import com.master.datascale.projet.dao.impl.DAOQcm;
import com.master.datascale.projet.dao.impl.DAOQuestion;


/**
 * The Action that handles all the student manipulations
 * @author Joy Jedidja
 *
 */
public class ActionStudent extends Action {
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		System.out.println("Je suis dans ActionTeacher");
		String forward = "student";
		
//		request.getSession().removeAttribute("user");
//		request.getSession().removeAttribute("login");
//		request.getSession().removeAttribute("success");
//		request.getSession().removeAttribute("validate");
//		request.getSession().removeAttribute("teachers");
		
		String url = request.getServletPath();
		System.out.println("Url  "+url);
		
		if(url.equalsIgnoreCase("/qcm_try.do"))
		{
			List<Qcm> qcms = (List<Qcm>) request.getSession().getAttribute("qcms");
			int position = Integer.parseInt(request.getParameter("qcmId"));
			
			Qcm donnees = qcms.get(position);
			
			List<Question> quests = new ArrayList<>();
			Map<Integer,List<Answer>> questions = new HashMap<>();
			
			int i = 0;
			for(Question question : donnees.getQuestions())
			{
				quests.add(question);
				List<Answer> answers  = new ArrayList<>();
				for(Answer answer : question.getAnswers())
				{
					answers.add(answer);
				}
				questions.put(i, answers);
				i++;
			}
			
			request.getSession().setAttribute("questions",questions);
			request.getSession().setAttribute("quests",quests);
			request.getSession().setAttribute("selectedQcm",donnees);
		}

	
		return mapping.findForward(forward);
	}

}
