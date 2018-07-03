package com.soundclub.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soundclub.models.Genero_Musical;
import com.soundclub.models.Usuario;


public class Genero_MusicalEM extends EntityManager{
	
	private static Genero_MusicalEM instance=null;
	
	public static final Genero_MusicalEM getInstance() {
		if(instance==null) { instance=new Genero_MusicalEM();}
		return instance;
	}
	
	protected Genero_MusicalEM() {
		super();
	}
	private void ManejoException(Exception e) {
		System.out.println("Ha ocurrido un erro en la entity Manager de País ::"+e);
		e.printStackTrace();
		
	}
	
	public List<Genero_Musical> getListaGenero_Musical() {
		List<Genero_Musical>  listaGenero_Musicals=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Genero_Musical";
			listaGenero_Musicals=session.createQuery(sql,Genero_Musical.class).getResultList();
			t.commit();
			session.close();
			
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return listaGenero_Musicals;
	}
	public Genero_Musical getGenero_MusicalID( int idGenero_Musical) {
		Genero_Musical genero_musica=null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Usuario WHERE mid="+idGenero_Musical;
			genero_musica=session.createQuery(sql,Genero_Musical.class).getSingleResult();
			t.commit();
			session.close();
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return genero_musica;
	}
	
	
	
	
}
