package br.com.forward.exception;

import javax.ejb.ApplicationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@ApplicationException(rollback = true)
public class InsumoException extends Exception {
	private static final Logger LOGGER = LogManager.getLogger(InsumoException.class);
	private static final long serialVersionUID = 1L;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public InsumoException() {
       super();
   }

	public InsumoException(final String s, final Throwable throwable) {
       super(s, throwable);
   }

	public InsumoException(final String s) {
       super(s);
   }

	public InsumoException(final Throwable throwable) {
       super(throwable);
   }
}
