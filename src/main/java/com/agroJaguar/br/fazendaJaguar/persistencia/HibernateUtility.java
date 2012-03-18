package com.agroJaguar.br.fazendaJaguar.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.richfaces.application.push.Session;

public class HibernateUtility {
	
	public static Session getSession() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
		return null;
	}
}