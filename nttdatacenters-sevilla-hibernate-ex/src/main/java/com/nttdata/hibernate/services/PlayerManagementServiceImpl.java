package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Player;
import com.nttdata.hibernate.persistence.PlayerDaoI;
import com.nttdata.hibernate.persistence.PlayerDaoImpl;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Implementación del servicio de jugadores.
 * 
 * @author NTT Data Sevilla
 *
 */
public class PlayerManagementServiceImpl implements PlayerManagementServiceI {

	/** DAO: NTTDATA_HEX_PLAYER */
	private PlayerDaoI playerDao;

	/**
	 * Método constructor.
	 */
	public PlayerManagementServiceImpl(final Session session) {
		this.playerDao = new PlayerDaoImpl(session);
	}

	@Override
	public void insertNewPlayer(final Player newPlayer) {

		// Verificación de nulidad e inexistencia.
		if (newPlayer != null && newPlayer.getPlayerId() == null) {

			// Insercción del nuevo jugador.
			playerDao.insert(newPlayer);
		}

	}

	@Override
	public void updatePlayer(final Player updatedPlayer) {

		// Verificación de nulidad y existencia.
		if (updatedPlayer != null && updatedPlayer.getPlayerId() != null) {

			// Actualización del jugador.
			playerDao.update(updatedPlayer);
		}

	}

	@Override
	public void deletePlayer(final Player deletedPlayer) {

		// Verificación de nulidad y existencia.
		if (deletedPlayer != null && deletedPlayer.getPlayerId() != null) {

			// Eliminación del jugador.
			playerDao.delete(deletedPlayer);
		}

	}

	@Override
	public Player searchById(final Long playerId) {

		// Resultado.
		Player player = null;

		// Verificación de nulidad.
		if (playerId != null) {

			// Obtención del jugador por ID.
			player = playerDao.searchById(playerId);
		}

		return player;
	}

	@Override
	public List<Player> searchByName(final String name) {

		// Resultado.
		List<Player> playersList = new ArrayList<Player>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del jugador por nombre.
			playersList = playerDao.searchByName(name);
		}

		return playersList;
	}

	@Override
	public List<Player> searchAll() {

		// Resultado.
		List<Player> playersList = new ArrayList<Player>();

		// Obtención de jugadores.
		playersList = playerDao.searchAll();

		return playersList;
	}

	@Override
	public List<Player> searchByNameAndTeamBudget(String namePattern, Double budget) {
		
		// Resultado.
		List<Player> playersList = new ArrayList<Player>();

		// Obtención de jugadores.
		playersList = playerDao.searchByNameAndTeamBudget(namePattern, budget);

		return playersList;
	}

}
