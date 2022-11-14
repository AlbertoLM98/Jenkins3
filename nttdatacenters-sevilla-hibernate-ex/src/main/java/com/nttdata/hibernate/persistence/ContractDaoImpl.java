package com.nttdata.hibernate.persistence;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * DAO de tabla NTTDATA_HEX_CONTRACT
 * 
 * @author NTT Data Sevilla
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

}
