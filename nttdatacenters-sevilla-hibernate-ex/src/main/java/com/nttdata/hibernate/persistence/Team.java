package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Entidad de tabla NTTDATA_HEX_TEAM
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_TEAM")
public class Team extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long teamId;

	/** Nombre del equipo */
	private String name;

	/** Presupuesto */
	private Double budget;

	/** Lista de jugadores relacionados */
	private List<Player> playersList;

	/** Lista de partdos relacionados */
	private List<Match> matchesList;

	/**
	 * @return the teamId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAM_ID")
	public Long getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId
	 *            the teamId to set
	 */
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false, unique = true)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the budget
	 */
	@Column(name = "BUDGET")
	@Digits(integer = 4, fraction = 2)
	@Min(value = 100, message = "Presupuesto inferior al mínimo.")
	@Max(value = 9999, message = "Presupuesto excede del máximo.")
	public Double getBudget() {
		return budget;
	}

	/**
	 * @param budget
	 *            the budget to set
	 */
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	/**
	 * @return the playersList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "team")
	public List<Player> getPlayersList() {
		return playersList;
	}

	/**
	 * @param playersList
	 *            the playersList to set
	 */
	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}

	/**
	 * @return the matchesList
	 */
	@ManyToMany(mappedBy = "teamsList")
	public List<Match> getMatchesList() {
		return matchesList;
	}

	/**
	 * @param matchesList
	 *            the matchesList to set
	 */
	public void setMatchesList(List<Match> matchesList) {
		this.matchesList = matchesList;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", budget=" + budget + ", playersList=" + playersList + ", matchesList=" + matchesList + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Team.class;
	}

	@Override
	public Long getId() {
		return this.teamId;
	}

	@Override
	public void setId(Long id) {
		this.teamId = id;
	}

}
