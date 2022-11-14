package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Team;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Interface del servicio de equipos.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface TeamManagementServiceI {

	/**
	 * Inserta un nuevo equipo.
	 * 
	 * @param newTeam
	 */
	public void insertNewTeam(final Team newTeam);

	/**
	 * Actualiza un equipo existente.
	 * 
	 * @param updatedTeam
	 */
	public void updateTeam(final Team updatedTeam);

	/**
	 * Elimina un equipo existente.
	 * 
	 * @param deletedTeam
	 */
	public void deleteTeam(final Team deletedTeam);

	/**
	 * Obtiene un equipos mediante su ID.
	 * 
	 * @param teamId
	 */
	public Team searchById(final Long teamId);

	/**
	 * Obtiene todos los equipos existentes.
	 * 
	 * @return List<Team>
	 */
	public List<Team> searchAll();

}
