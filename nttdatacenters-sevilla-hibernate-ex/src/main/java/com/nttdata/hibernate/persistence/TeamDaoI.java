package com.nttdata.hibernate.persistence;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_TEAM
 * 
 * @author NTT Data Sevilla
 *
 */
public interface TeamDaoI extends CommonDaoI<Team> {

	/**
	 * Obtención de equipo por nombre.
	 * 
	 * @param name
	 * @return Team
	 */
	public Team searchByName(final String name);

}
