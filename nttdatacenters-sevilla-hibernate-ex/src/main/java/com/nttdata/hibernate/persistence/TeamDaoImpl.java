package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_TEAM
 * 
 * @author NTT Data Sevilla
 *
 */
public class TeamDaoImpl extends CommonDaoImpl<Team> implements TeamDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public TeamDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Team searchByName(final String name) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza equipo en función del nombre.
		final List<Team> teamsList = session.createQuery("FROM Team WHERE name=" + name).list();
		
		// Resultado.
		Team team = null;
		if(teamsList != null && teamsList.size() > 0) {
			team = teamsList.get(0);
		}

		return team;
	}

}
