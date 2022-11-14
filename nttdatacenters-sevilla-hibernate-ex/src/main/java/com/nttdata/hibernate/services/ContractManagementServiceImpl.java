package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Implementación del servicio de contratos.
 * 
 * @author NTT Data Sevilla
 *
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI {

	/** DAO: NTTDATA_HEX_CONTRACT */
	private ContractDaoI contractDao;

	/**
	 * Método constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(final Contract newContract) {

		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getContractId() == null) {

			// Insercción del nuevo contrato.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(final Contract updatedContract) {

		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del contrato.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(final Contract deletedContract) {

		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Eliminación del contrato.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(final Long contractId) {

		// Resultado.
		Contract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {

		// Resultado.
		List<Contract> contractsList = new ArrayList<Contract>();

		// Obtención de contratos.
		contractsList = contractDao.searchAll();

		return contractsList;
	}

}
