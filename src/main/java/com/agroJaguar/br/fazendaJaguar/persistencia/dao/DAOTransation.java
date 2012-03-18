package com.agroJaguar.br.fazendaJaguar.persistencia.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DAOTransation implements DAOInterface {

	@PersistenceContext(unitName = "TRACUS")
	EntityManagerFactory em;
	
	public DAOTransation() {
		
	}
	
	/**
	 * Obter uma lista de objetos
	 */
	public List<?> obterObjetos(String consulta, Class<?> classe) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();
        try{
        	EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	Query query = em.createQuery(consulta.toString(),classe);
        	return query.getResultList();
        	
        }finally{
        	em.close();
        }
	}
	
	/**
	 * Obter uma lista de objetos
	 */
	public Object findObjeto(Integer idSelecionado,Class<?> classe) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();
        try{
        	EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	return em.find(classe, idSelecionado);
        }finally{
        	em.close();
        }
	}
	
	/**
	 * Inserir um objeto novo
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public void inserir(Object o) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();
        
		try {
			EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	em.persist(o);
        	entr.commit();
		}finally{
        	em.close();
        }
	}

	/**
	 * Excluir objeto
	 * @param o
	 * @throws Exception
	 */
	public void excluir(Object o,Class<?> classe) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();
         
        try {
			EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	Object obj = em.find(classe, o);
        	em.remove(obj);
        	entr.commit();
		}finally{
        	em.close();
        }		
	}
	
	/**
	 * Alterar
	 * @param o
	 * @throws Exception
	 */
	public void alterar(Object o) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();

        try {
			EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	em.merge(o);
        	entr.commit();
		}finally{
        	em.close();
        }
	}

	/**
	 * Obter objeto
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public Object obterObjeto(String consulta, Class<?> classe) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRACUS");
        EntityManager em = emf.createEntityManager();
        try{
        	EntityTransaction entr = em.getTransaction();
        	entr.begin();
        	Query query = em.createQuery(consulta.toString(),classe);
        	if (query.getResultList() != null || !query.getResultList().isEmpty()) {
    			Iterator it = query.getResultList().iterator();
    			return (it.hasNext() ? (Object) it.next() : null);
    		}
        	HashMap map = new HashMap();
        	map.put("nome", query);
    		return null;
        }finally{
        	em.close();
        }
	}
}
