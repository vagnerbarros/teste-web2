package br.com.yousoft.dao;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.yousoft.util.Constantes;
import br.com.yousoft.util.HibernateUtil;


public abstract class GenericDAO <T> {
	
	protected Session sessao;
	protected Transaction tx;
	protected Class<T> clazz;
	
	public GenericDAO(Class<T> clazz){
		this.clazz = clazz;
	}
	
	public T buscarPorId(Long id){
		try{
			sessao = HibernateUtil.getSession();
			T object = (T) sessao.get(clazz, id);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public T buscarPorChaveUnicaLong(Long longo, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			T object = (T) sessao.createCriteria(clazz).add(Restrictions.eq(coluna, longo)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public T buscarPorChaveUnicaString(String stringi, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			T object = (T) sessao.createCriteria(clazz).add(Restrictions.eq(coluna, stringi)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<T> buscarPorChaveEstrangeira(Long chaveEstrangeira, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			List<T> objects = sessao.createCriteria(clazz).add(Restrictions.eq(coluna, chaveEstrangeira)).list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public boolean salvarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(sessao!=null)
			sessao.close();
		}
	}
	
	public boolean salvarOuAtualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}

	public boolean atualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			sessao.setCacheMode(CacheMode.IGNORE);
			tx = sessao.beginTransaction();
			sessao.update(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public boolean mesclarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.merge(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public boolean deletarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public List<T> listarObjetos(){
		try{
			sessao = HibernateUtil.getSession();
			Criteria criteria = sessao.createCriteria(clazz);
			return criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
		
	public List<T> criarQuery(String query){
		try{
			sessao = HibernateUtil.getSession();
			Query select = sessao.createQuery(query);
			return select.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public T selectObjeto(String query){
		try{
			sessao = HibernateUtil.getSession();
			T obj = (T) sessao.createQuery(query).uniqueResult();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<T> buscarPorLike(String coluna, String queryPart){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.like(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.like("status", Constantes.ATIVO));
			List<T> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<T> buscarPorLikeIlimitado(String [] colunas, String [] querys){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			for(int i = 0; i < colunas.length; i++){
				c.add(Restrictions.like(colunas[i], querys[i], MatchMode.ANYWHERE));
			}
			List<T> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<T> buscarPorLikeIgnoreCase(String coluna, String queryPart){
		try{
			sessao = HibernateUtil.getSession();
			List<T> objets = sessao.createCriteria(clazz).add(Restrictions.ilike(coluna, queryPart, MatchMode.ANYWHERE)).list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
}
