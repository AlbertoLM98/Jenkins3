package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Entidad de tabla NTTDATA_HEX_CONTRACT
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Salario del jugador */
	private String salary;

	/** Equipo asociado (FK) */
	private Player player;

	/**
	 * @return the playerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId
	 *            the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "SALARY", nullable = false)
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * @return the player
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYER_ID")
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public Long getId() {
		return this.contractId;
	}

	@Override
	public void setId(Long id) {
		this.contractId = id;
	}

}
