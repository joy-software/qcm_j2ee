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
 * The Action that handles the teacher requests
 * @author Joy Jedidja
 *
 */
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
		System.out.println("Url  "+url);
		
		if(url.equalsIgnoreCase("/createQcm.do"))
		{
			List<Qcm> qcms = (List<Qcm>)request.getSession().getAttribute("qcms");
			
			IDAOQcm daoQcm = (DAOQcm)context.getBean("DAOQcm");
			
			Teacher teacher = (Teacher) request.getSession().getAttribute("user");	

			Qcm donnees = (Qcm)form;
			
			System.out.println("La propriétaire: "+teacher);
			
			
			donnees.setTeacher(teacher);
			
			daoQcm.save(donnees);
			
			qcms.add(donnees);
			
			request.getSession().setAttribute("qcms", qcms);
			
			System.out.println("Votre identite: "+donnees);
			
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
		if(url.equalsIgnoreCase("/qcm_addQ.do"))
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

		
		if(url.equalsIgnoreCase("/createQuestion.do"))
		{
			IDAOQuestion daoQcm = (DAOQuestion)context.getBean("DAOQuestion");
			
			Qcm qcm = (Qcm) request.getSession().getAttribute("selectedQcm");	

			Question donnees = (Question)form;

			donnees.setQcm(qcm);
			
			daoQcm.save(donnees);
			
			qcm.getQuestions().add(donnees);
			
			request.getSession().setAttribute("selectedQcm", qcm);	
		}		
		
		if(url.equalsIgnoreCase("/createAnswer.do"))
		{
			
			IDAOAnswer daoQcm = (DAOAnswer)context.getBean("DAOAnswer");
						
			 List<Question> quests = (List<Question>) request.getSession().getAttribute("quests");	
			
			
			int position = Integer.parseInt(request.getParameter("questionId"));
			
			Map<Integer,List<Answer>> questions = (Map<Integer, List<Answer>>) request.getSession().getAttribute("questions");	
			Question question = quests.get(position);
			
			List<Answer> values = questions.get(position);
			
			Answer donnees = (Answer)form;
			
			donnees.setQuestion(question);
			
			daoQcm.save(donnees);

			questions.remove(position);
			
			question.getAnswers().add(donnees);
			
			values.add(donnees);
			
			
			questions.put(position, values);
			
			request.getSession().setAttribute("questions",questions);
			
			//*/
		}		

		return mapping.findForward(forward);
	}

}
