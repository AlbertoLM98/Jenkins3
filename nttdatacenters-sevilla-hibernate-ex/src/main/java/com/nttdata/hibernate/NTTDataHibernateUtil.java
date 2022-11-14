package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Clase de configuración
 * 
 * @author NTT Data Sevilla
 *
 */
public class NTTDataHibernateUtil {

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Generación de factoría de sesiones.
	 */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
			
		} catch (final Throwable ex) {

			// Error de inicialización.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
