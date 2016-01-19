package br.com.forward.entity;

import java.io.Serializable;

public abstract interface EntityInterface extends Serializable
{
  public abstract String toString();

  public abstract boolean equals(Object paramObject);

  public abstract int hashCode();
}

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.EntityInterface
 * JD-Core Version:    0.6.0
 */