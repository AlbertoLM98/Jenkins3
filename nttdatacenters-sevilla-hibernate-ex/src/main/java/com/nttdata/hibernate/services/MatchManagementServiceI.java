package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Match;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Interface del servicio de partidos.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface MatchManagementServiceI {

	/**
	 * Inserta un nuevo partido.
	 * 
	 * @param newMatch
	 */
	public void insertNewMatch(final Match newMatch);

	/**
	 * Actualiza un partido existente.
	 * 
	 * @param updatedMatch
	 */
	public void updateMatch(final Match updatedMatch);

	/**
	 * Elimina un partido existente.
	 * 
	 * @param deletedMatch
	 */
	public void deleteMatch(final Match deletedTeam);

	/**
	 * Obtiene un partidos mediante su ID.
	 * 
	 * @param matchId
	 */
	public Match searchById(final Long matchId);

	/**
	 * Obtiene todos los partidos existentes.
	 * 
	 * @return List<Match>
	 */
	public List<Match> searchAll();

}
