package com.nttdata.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Match;
import com.nttdata.hibernate.persistence.Player;
import com.nttdata.hibernate.persistence.Team;
import com.nttdata.hibernate.services.ContractManagementServiceI;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.hibernate.services.MatchManagementServiceI;
import com.nttdata.hibernate.services.MatchManagementServiceImpl;
import com.nttdata.hibernate.services.PlayerManagementServiceI;
import com.nttdata.hibernate.services.PlayerManagementServiceImpl;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */
public class NTTDataMain {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final PlayerManagementServiceI playerService = new PlayerManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);
		final MatchManagementServiceI matchService = new MatchManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTSPORT_SYS";
		final Date updatedDate = new Date();

		// Generación de equipos.
		final Team teamA = new Team();
		teamA.setName("Río");
		teamA.setBudget(5000D);
		teamA.setUpdatedDate(updatedDate);
		teamA.setUpdatedUser(updatedUser);

		final Team teamB = new Team();
		teamB.setName("Mar");
		teamB.setBudget(4000D);
		teamB.setUpdatedDate(updatedDate);
		teamB.setUpdatedUser(updatedUser);

		// Generación de contratos.
		final Contract contract1 = new Contract();
		contract1.setSalary("1");
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);
		final Contract contract2 = new Contract();
		contract2.setSalary("2");
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);
		final Contract contract3 = new Contract();
		contract3.setSalary("3");
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);
		final Contract contract4 = new Contract();
		contract4.setSalary("4");
		contract4.setUpdatedDate(updatedDate);
		contract4.setUpdatedUser(updatedUser);

		// Generación de jugadores.
		final Player player1 = new Player();
		player1.setName("Noelia G.G.");
		player1.setBirthDate(new Date());
		player1.setTeam(teamA);
		player1.setUpdatedDate(updatedDate);
		player1.setUpdatedUser(updatedUser);
		player1.setContract(contract1);
		contract1.setPlayer(player1);

		final Player player2 = new Player();
		player2.setName("Estefanía C.M.");
		player2.setBirthDate(new Date());
		player2.setTeam(teamA);
		player2.setUpdatedDate(updatedDate);
		player2.setUpdatedUser(updatedUser);
		player2.setContract(contract2);
		contract2.setPlayer(player2);

		final Player player3 = new Player();
		player3.setName("Raúl T.R.");
		player3.setBirthDate(new Date());
		player3.setTeam(teamB);
		player3.setUpdatedDate(updatedDate);
		player3.setUpdatedUser(updatedUser);
		player3.setContract(contract3);
		contract3.setPlayer(player3);

		final Player player4 = new Player();
		player4.setName("Arturo B.D.L.");
		player4.setBirthDate(new Date());
		player4.setTeam(teamB);
		player4.setUpdatedDate(updatedDate);
		player4.setUpdatedUser(updatedUser);
		player4.setContract(contract4);
		contract4.setPlayer(player4);

		playerService.insertNewPlayer(player1);
		playerService.insertNewPlayer(player2);
		playerService.insertNewPlayer(player3);
		playerService.insertNewPlayer(player4);

		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);
		contractService.insertNewContract(contract4);

		// Consultas (JPA Criteria)
		List<Player> players = playerService.searchByNameAndTeamBudget("E%", 4500D);

		for (final Player player : players) {
			System.out.println(player.getName() + " | " + player.getTeam().getName() + " | " + player.getTeam().getBudget());
		}

		// Generación de partidos.
		final Match match1 = new Match();
		match1.setLocation("Sevilla");
		match1.setUpdatedDate(updatedDate);
		match1.setUpdatedUser(updatedUser);

		final List<Team> teamsList = new ArrayList<Team>();
		teamsList.add(teamA);
		teamsList.add(teamB);
		match1.setTeamsList(teamsList);

		matchService.insertNewMatch(match1);

		// Cierre de sesión.
		session.close();

	}

}
