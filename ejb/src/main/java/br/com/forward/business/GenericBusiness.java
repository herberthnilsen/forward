package br.com.forward.business;

import java.util.logging.LogManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.forward.interfaces.business.GenericBusinessLocal;

public abstract class GenericBusiness implements GenericBusinessLocal {
	public static final LogManager LOGGER = LogManager.getLogManager();

	@PersistenceContext(unitName = "pu_forward")
	protected EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
