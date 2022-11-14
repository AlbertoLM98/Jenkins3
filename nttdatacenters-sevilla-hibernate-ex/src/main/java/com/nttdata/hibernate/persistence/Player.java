package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Entidad de tabla NTTDATA_HEX_PLAYER
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_PLAYER")
public class Player extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long playerId;

	/** Nombre del jugador */
	private String name;

	/** Fecha de nacimiento */
	private Date birthDate;

	/** Equipo asociado (FK) */
	private Team team;

	/** Contrato asociado */
	private Contract contract;

	/**
	 * @return the playerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLAYER_ID")
	public Long getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the birthDate
	 */
	@Column(name = "BIRTH_DATE", nullable = false)
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false)
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
	 * @return the team
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * @return the contract
	 */
	@OneToOne(mappedBy = "player")
	public Contract getContract() {
		return contract;
	}

	/**
	 * @param contract
	 *            the contract to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", birthDate=" + birthDate + ", team=" + team + ", contract=" + contract + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Player.class;
	}

	@Override
	public Long getId() {
		return this.playerId;
	}

	@Override
	public void setId(Long id) {
		this.playerId = id;
	}

}
