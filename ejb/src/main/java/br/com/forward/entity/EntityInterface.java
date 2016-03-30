package br.com.forward.entity;

import java.io.Serializable;

public abstract interface EntityInterface extends Serializable {

	@Override
	public abstract String toString();

	@Override
	public abstract boolean equals(Object paramObject);

	@Override
	public abstract int hashCode();
}
