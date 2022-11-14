package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Match;
import com.nttdata.hibernate.persistence.MatchDaoI;
import com.nttdata.hibernate.persistence.MatchDaoImpl;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Implementación del servicio de partidos.
 * 
 * @author NTT Data Sevilla
 *
 */
public class MatchManagementServiceImpl implements MatchManagementServiceI {

	/** DAO: NTTDATA_HEX_MATCH */
	private MatchDaoI matchDao;

	/**
	 * Método constructor.
	 */
	public MatchManagementServiceImpl(final Session session) {
		this.matchDao = new MatchDaoImpl(session);
	}

	@Override
	public void insertNewMatch(final Match newMatch) {

		// Verificación de nulidad e inexistencia.
		if (newMatch != null && newMatch.getMatchId() == null) {

			// Insercción del nuevo partido.
			matchDao.insert(newMatch);
		}

	}

	@Override
	public void updateMatch(final Match updatedMatch) {

		// Verificación de nulidad y existencia.
		if (updatedMatch != null && updatedMatch.getMatchId() != null) {

			// Actualización del partido.
			matchDao.update(updatedMatch);
		}

	}

	@Override
	public void deleteMatch(final Match deletedMatch) {

		// Verificación de nulidad y existencia.
		if (deletedMatch != null && deletedMatch.getMatchId() != null) {

			// Eliminación del partido.
			matchDao.delete(deletedMatch);
		}

	}

	@Override
	public Match searchById(final Long matchId) {

		// Resultado.
		Match match = null;

		// Verificación de nulidad.
		if (matchId != null) {

			// Obtención del partido por ID.
			match = matchDao.searchById(matchId);
		}

		return match;
	}

	@Override
	public List<Match> searchAll() {

		// Resultado.
		List<Match> matchesList = new ArrayList<Match>();

		// Obtención de partido.
		matchesList = matchDao.searchAll();

		return matchesList;
	}

}
