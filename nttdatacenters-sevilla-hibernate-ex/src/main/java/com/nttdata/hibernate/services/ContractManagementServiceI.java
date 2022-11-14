package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Interface del servicio de contratos.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newPlayer
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedPlayer
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedPlayer
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param playerId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

}
