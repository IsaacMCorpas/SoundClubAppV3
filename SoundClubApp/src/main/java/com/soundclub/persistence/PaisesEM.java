package com.soundclub.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soundclub.models.Pais;
import com.soundclub.models.Usuario;

public class PaisesEM extends EntityManager  {
	private static PaisesEM instance=null;
	
	public static final PaisesEM getInstance() {
		if(instance==null) { instance=new PaisesEM();}
		return instance;
	}
	
	protected PaisesEM() {
		super();
	}
	private void ManejoException(Exception e) {
		System.out.println("Ha ocurrido un erro en la entity Manager de País ::"+e);
		e.printStackTrace();
		
	}
	
	public List<Pais> getListaPais() {
		List<Pais>  listaPais=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Pais";
			listaPais=session.createQuery(sql,Pais.class).getResultList();
			t.commit();
			session.close();
			
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return listaPais;
	}
	public Pais getPaisID( int idPais) {
		Pais pais=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Pais WHERE cid="+idPais;
			pais=session.createQuery(sql,Pais.class).getSingleResult();
			t.commit();
			session.close();
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return pais;
	}
}
