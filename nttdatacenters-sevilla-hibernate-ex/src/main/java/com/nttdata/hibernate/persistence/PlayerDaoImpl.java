package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_PLAYER
 * 
 * @author NTT Data Sevilla
 *
 */
public class PlayerDaoImpl extends CommonDaoImpl<Player> implements PlayerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public PlayerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> searchByName(final String name) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<Player> playersList = session.createQuery("FROM Player WHERE name=" + name).list();

		return playersList;
	}

	@Override
	public List<Player> searchByNameAndTeamBudget(final String namePattern, final Double budget) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Player> cquery = cb.createQuery(Player.class);
		final Root<Player> rootP = cquery.from(Player.class);
		final Join<Player, Team> pJoinT = rootP.join("team");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String> get("name"), namePattern);
		final Predicate pr2 = cb.gt(pJoinT.<Double> get("budget"), budget);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		// Ordenación descendente (mayor a menor) de presupuestos.
		cquery.orderBy(cb.desc(pJoinT.get("budget")));

		// Ejecución de consulta.
		final List<Player> results = session.createQuery(cquery).getResultList();

		return results;
	}

}
