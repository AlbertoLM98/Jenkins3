package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Entidad de tabla NTTDATA_HEX_MATCH
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_MATCH")
public class Match extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long matchId;

	/** Localización */
	private String location;

	/** Lista de equipos relacionados */
	private List<Team> teamsList;

	/**
	 * @return the matchId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MATCH_ID")
	public Long getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId
	 *            the matchId to set
	 */
	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the location
	 */
	@Column(name = "LOCATION", nullable = false)
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the teamsList
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "NTTDATA_HEX_MAT_TEA", joinColumns = { @JoinColumn(name = "MATCH_ID") }, inverseJoinColumns = { @JoinColumn(name = "TEAM_ID") })
	public List<Team> getTeamsList() {
		return teamsList;
	}

	/**
	 * @param teamsList
	 *            the teamsList to set
	 */
	public void setTeamsList(List<Team> teamsList) {
		this.teamsList = teamsList;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", location=" + location + ", teamsList=" + teamsList + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Match.class;
	}

	@Override
	public Long getId() {
		return this.matchId;
	}
	
	@Override
	public void setId(Long id) {
		this.matchId = id;
	}

}
