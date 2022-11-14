package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_PLAYER
 * 
 * @author NTT Data Sevilla
 *
 */
public interface PlayerDaoI extends CommonDaoI<Player> {

	/**
	 * Obtiene jugadores por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<Player>
	 */
	public List<Player> searchByNameAndTeamBudget(final String namePattern, final Double budget);
	
	/**
	 * Obtiene jugadores por nombre.
	 * 
	 * @param name
	 * @return List<Player>
	 */
	public List<Player> searchByName(final String name);

}
