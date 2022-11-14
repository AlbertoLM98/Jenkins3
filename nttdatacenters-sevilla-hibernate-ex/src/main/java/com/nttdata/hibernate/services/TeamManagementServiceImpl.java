package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Team;
import com.nttdata.hibernate.persistence.TeamDaoI;
import com.nttdata.hibernate.persistence.TeamDaoImpl;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Implementación del servicio de equipos.
 * 
 * @author NTT Data Sevilla
 *
 */
public class TeamManagementServiceImpl implements TeamManagementServiceI {

	/** DAO: NTTDATA_HEX_TEAM */
	private TeamDaoI teamDao;

	/**
	 * Método constructor.
	 */
	public TeamManagementServiceImpl(final Session session) {
		this.teamDao = new TeamDaoImpl(session);
	}

	@Override
	public void insertNewTeam(final Team newTeam) {

		// Verificación de nulidad e inexistencia.
		if (newTeam != null && newTeam.getTeamId() == null) {

			// Insercción del nuevo equipo.
			teamDao.insert(newTeam);
		}

	}

	@Override
	public void updateTeam(final Team updatedTeam) {

		// Verificación de nulidad y existencia.
		if (updatedTeam != null && updatedTeam.getTeamId() != null) {

			// Actualización del equipo.
			teamDao.update(updatedTeam);
		}

	}

	@Override
	public void deleteTeam(final Team deletedTeam) {

		// Verificación de nulidad y existencia.
		if (deletedTeam != null && deletedTeam.getTeamId() != null) {

			// Eliminación del equipo.
			teamDao.delete(deletedTeam);
		}

	}

	@Override
	public Team searchById(final Long teamId) {

		// Resultado.
		Team team = null;

		// Verificación de nulidad.
		if (teamId != null) {

			// Obtención del equipo por ID.
			team = teamDao.searchById(teamId);
		}

		return team;
	}

	@Override
	public List<Team> searchAll() {

		// Resultado.
		List<Team> teamsList = new ArrayList<Team>();

		// Obtención de equipos.
		teamsList = teamDao.searchAll();

		return teamsList;
	}

}
