package br.com.forward.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import br.com.forward.exception.EntityManagerException;

public class GenericEntityManager {
	private EntityManager entityManager;

	public GenericEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() throws EntityManagerException {
		if (this.entityManager == null) {
			throw new EntityManagerException("EntityManager esta nulo");
		}
		return this.entityManager;
	}

	public void persist(Object entity) throws EntityManagerException {
		try {
			getEntityManager().persist(entity);
		} catch (EntityExistsException eee) {
			throw new EntityManagerException("Entidade ja existe", eee);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Entidade invalida", iae);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		}
	}

	public Object merge(Object entity) throws EntityManagerException {
		try {
			return getEntityManager().merge(entity);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Entidade invalida ou inexistente", iae);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		}
	}

	public void remove(Object entity) throws EntityManagerException {
		try {
			getEntityManager().remove(entity);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Entidade invalida ou nao esta mais gerenciada", iae);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		}
	}

	public Object find(Class persistenceClass, Object pk) throws EntityManagerException {
		try {
			return getEntityManager().find(persistenceClass, pk);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		} catch (IllegalArgumentException iae) {
		throw new EntityManagerException("Primeiro argumento nao e uma entidade ou segundo nao e uma chave primaria",
				iae);
		}
	}

	protected Object getReference(Class persistenceClass, Object pk) throws EntityManagerException {
		try {
			return getEntityManager().getReference(persistenceClass, pk);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException(
					"Primeiro argumento nao e uma entidade ou segundo nao e uma chave primaria", iae);
		} catch (EntityNotFoundException enfe) {
			throw new EntityManagerException("Nao foi possivel acessar a entidade", enfe);
		}
	}

	protected void flush() throws EntityManagerException {
		try {
			getEntityManager().flush();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		} catch (PersistenceException pe) {
			throw new EntityManagerException("Falha ao sincronizar os dados no banco de dados", pe);
		}
	}

	protected void setFlushMode(FlushModeType flushMode) throws EntityManagerException {
		try {
			getEntityManager().setFlushMode(flushMode);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		}
	}

	protected FlushModeType getFlushMode() throws EntityManagerException {
		try {
			return getEntityManager().getFlushMode();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		}
	}

	protected void lock(Object entity, LockModeType lockMode) throws EntityManagerException {
		try {
			getEntityManager().lock(entity, lockMode);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Entidade invalida ou inexistente", iae);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		} catch (PersistenceException pe) {
			throw new EntityManagerException("Operacao nao suportadada", pe);
		}
	}

	protected void refresh(Object persistenceClass) throws EntityManagerException {
		try {
			getEntityManager().refresh(persistenceClass);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Nao e uma entidade ou nao esta gerenciada", iae);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		} catch (EntityNotFoundException enfe) {
			throw new EntityManagerException("Entidade inexistente na base de dados", enfe);
		}
	}

	protected void clear() throws EntityManagerException {
		try {
			getEntityManager().clear();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		}
	}

	protected boolean contains(Object entity) throws EntityManagerException {
		try {
			return getEntityManager().contains(entity);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("Nao e uma entidade", iae);
		}
	}

	protected Query createQuery(String queryString) throws EntityManagerException {
		try {
			return getEntityManager().createQuery(queryString);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("QueryString invalida", iae);
		}
	}

	protected Query createNamedQuery(String namedQuery) throws EntityManagerException {
		try {
			return getEntityManager().createNamedQuery(namedQuery);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (IllegalArgumentException iae) {
			throw new EntityManagerException("NamedQuery nao foi encontrada", iae);
		}
	}

	protected Query createNativeQuery(String nativeQuery) throws EntityManagerException {
		try {
			return getEntityManager().createNativeQuery(nativeQuery);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		}
	}

	protected Query createNativeQuery(String nativeQuery, Class resultClass) throws EntityManagerException {
		try {
			return getEntityManager().createNativeQuery(nativeQuery, resultClass);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		}
	}

	protected Query createNativeQuery(String nativeQuery, String resultSetMapping) throws EntityManagerException {
		try {
			return getEntityManager().createNativeQuery(nativeQuery, resultSetMapping);
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		}
	}

	protected void joinTransaction() throws EntityManagerException {
		try {
			getEntityManager().joinTransaction();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		} catch (TransactionRequiredException tre) {
			throw new EntityManagerException("Nao existe uma transacao valida para executar esta operacao", tre);
		}
	}

	protected Object getDelegate() throws EntityManagerException {
		try {
			return getEntityManager().getDelegate();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada", ise);
		}
	}

	protected void close() throws EntityManagerException {
		try {
			getEntityManager().close();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager ja esta fechada ou a transacao e gerenciada pelo container",
					ise);
		}
	}

	protected boolean isOpen() throws EntityManagerException {
		return getEntityManager().isOpen();
	}

	protected EntityTransaction getTransaction() throws EntityManagerException {
		try {
			return getEntityManager().getTransaction();
		} catch (IllegalStateException ise) {
			throw new EntityManagerException("EntityManager esta sendo executada no contexto JTA", ise);
		}
	}
}
