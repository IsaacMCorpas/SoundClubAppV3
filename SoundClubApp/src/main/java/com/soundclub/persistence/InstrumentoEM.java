package com.soundclub.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soundclub.models.Instrumento;
import com.soundclub.models.Usuario;


public class InstrumentoEM extends EntityManager {
	
	private static InstrumentoEM instance=null;
	
	public static final InstrumentoEM getInstance() {
		if(instance==null) { instance=new InstrumentoEM();}
		return instance;
	}
	
	protected InstrumentoEM() {
		super();
	}
	
	private void ManejoException(Exception e) {
		System.out.println("Ha ocurrido un erro en la entity Manager de Instrumento ::"+e);
		e.printStackTrace();
		
	}

	public List<Instrumento> getListaInstrumento() {
		List<Instrumento>  listaInstrumento=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Instrumento";
			listaInstrumento=session.createQuery(sql,Instrumento.class).getResultList();
			t.commit();
			session.close();
			
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return listaInstrumento;
	}
	
	public Instrumento getInstrumentoID(int idInstrumento) {
		Instrumento instrumento=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Instrumento WHERE iid"+idInstrumento;
			instrumento=session.createQuery(sql,Instrumento.class).getSingleResult();
			t.commit();
			session.close();
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return instrumento;
	}
	
	
	public boolean save(Instrumento reg) {
		boolean isOK=false;
		try {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(reg);
		t.commit();
		isOK=true;
		session.close();
		} catch (Exception e) {
			ManejoException(e);
			
		}
		return isOK;

	}
	public boolean update(Instrumento actu) {
		boolean isOK=false;
		try {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.update(actu);
		t.commit();
		isOK=true;
		session.close();
		} catch (Exception e) {
			ManejoException(e);
			
		}
		return isOK;

	}


	
}
