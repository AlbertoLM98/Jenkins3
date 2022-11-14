package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_MATCH
 * 
 * @author NTT Data Sevilla
 *
 */
public interface MatchDaoI extends CommonDaoI<Match> {

	/**
	 * Obtiene partidos por localización.
	 * 
	 * @param location
	 * @return List<Match>
	 */
	public List<Match> searchByLocation(final String location);

}
