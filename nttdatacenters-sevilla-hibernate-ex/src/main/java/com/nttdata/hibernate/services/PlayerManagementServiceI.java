package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Player;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Interface del servicio de partidos.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface PlayerManagementServiceI {

	/**
	 * Inserta un nuevo jugador.
	 * 
	 * @param newPlayer
	 */
	public void insertNewPlayer(final Player newPlayer);

	/**
	 * Actualiza un jugador existente.
	 * 
	 * @param updatedPlayer
	 */
	public void updatePlayer(final Player updatedPlayer);

	/**
	 * Elimina un jugador existente.
	 * 
	 * @param deletedPlayer
	 */
	public void deletePlayer(final Player deletedPlayer);

	/**
	 * Obtiene un jugador mediante su ID.
	 * 
	 * @param playerId
	 */
	public Player searchById(final Long playerId);

	/**
	 * Obtiene un jugador por su nombre completo.
	 * 
	 * @param name
	 * @return List<Player>
	 */
	public List<Player> searchByName(final String name);

	/**
	 * Obtiene todos los jugadores existentes.
	 * 
	 * @return List<Player>
	 */
	public List<Player> searchAll();

	/**
	 * Obtiene jugadores por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<Player>
	 */
	public List<Player> searchByNameAndTeamBudget(final String namePattern, final Double budget);

}
