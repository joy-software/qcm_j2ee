package com.master.datascale.projet.hbem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public HibernateUtil() {
		// TODO Auto-generated constructor stub
		
	}

	private static final SessionFactory sessionFactory;

    static {
        try {
   
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
        }
    }

    /**
     * Le thradLocal d'hibernate
     */
    public static final ThreadLocal session = new ThreadLocal();

    /**
     * Retourne la session courante d'hibernate
     * @return
     * @throws HibernateException
     */
    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Ouvre une nouvelle Session, si ce Thread n'en a aucune
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    /**
     * Fermer la session d'hibernate
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();
    }
}
