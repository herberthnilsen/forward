package br.com.forward.dao;

import br.com.forward.entity.EntityInterface;
import br.com.forward.exception.BusinessRuntimeException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract interface DaoLocal
{
  public abstract void save(EntityInterface paramEntityInterface)
    throws BusinessRuntimeException;

  public abstract void save(Collection<? extends EntityInterface> paramCollection)
    throws BusinessRuntimeException;

  public abstract void update(EntityInterface paramEntityInterface)
    throws BusinessRuntimeException;

  public abstract EntityInterface merge(EntityInterface paramEntityInterface)
    throws BusinessRuntimeException;

  public abstract void delete(Class paramClass, Serializable paramSerializable)
    throws BusinessRuntimeException;

  public abstract void delete(Class paramClass, Collection<? extends Serializable> paramCollection)
    throws BusinessRuntimeException;

  public abstract void refresh(EntityInterface paramEntityInterface);

  public abstract void flush();

  public abstract void clear();

  public abstract EntityInterface findByPk(Class paramClass, Serializable paramSerializable);

  public abstract List<? extends EntityInterface> findAll(Class paramClass);
}

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.dao.DaoLocal
 * JD-Core Version:    0.6.0
 */