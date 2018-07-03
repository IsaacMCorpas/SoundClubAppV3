package com.soundclub.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import com.soundclub.models.Usuario;

public class UsuarioEMTest extends com.soundclub.persistence.Test {
	private static Logger logger = Logger.getLogger("UsuarioEMTest");

	@BeforeClass
	public static void setUpClass() {
		//setUpContext();
	}

	
	//Este test pasa la lista de usuarios
	
	@Test
	public void testListaUsuarios() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			UsuarioEM usuEM = UsuarioEM.getInstance();
			List<Usuario> listaUsuarios= usuEM.getLista();
			
			logger.log(Level.INFO, "listaUsuarios..." + listaUsuarios);
			assertTrue(listaUsuarios != null && !listaUsuarios.isEmpty());

		} catch (Exception ex) {			
			ex.printStackTrace();
			System.out.println("Error :" + ex);
			fail();
		}

		logger.log(Level.INFO, "Fin de test...");
	}
	
	
	//Este test comprueba si guarda los usuarios
	//datos enviados: null
	
	@Test
	public void testUsuarioSave() {
		logger.log(Level.INFO, "Entrando al test...");
		
		try {
			
			UsuarioEM usuEM = UsuarioEM.getInstance();
			usuEM.save(null);
			
		
		}catch (Exception ex) {			
			ex.printStackTrace();
			System.out.println("Error :" + ex);
			fail();
		}

		logger.log(Level.INFO, "Fin de test...");
	}
	
	//Este test comprueba si carga los usuarios 
	//datos enviados: null
	
	
	@Test
	public void testUsuarioUpadate() {
		logger.log(Level.INFO, "Entrando al test...");
		
		try {
			
			UsuarioEM usuEM = UsuarioEM.getInstance();
			usuEM.update(null);
			
		
		}catch (Exception ex) {			
			ex.printStackTrace();
			System.out.println("Error :" + ex);
			fail();
		}

		logger.log(Level.INFO, "Fin de test...");
	}
	
}


