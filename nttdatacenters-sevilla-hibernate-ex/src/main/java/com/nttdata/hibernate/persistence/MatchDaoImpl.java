package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_MATCH
 * 
 * @author NTT Data Sevilla
 *
 */
public class MatchDaoImpl extends CommonDaoImpl<Match> implements MatchDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public MatchDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Match> searchByLocation(final String location) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza partidos en función de la localización.
		final List<Match> matchesList = session.createQuery("FROM Match WHERE location=" + location).list();

		return matchesList;
	}


}
