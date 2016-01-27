package br.com.forward.exception;

import javax.ejb.ApplicationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@ApplicationException(rollback = true)
public class UnidadeException extends Exception {
	private static final Logger LOGGER = LogManager.getLogger(UnidadeException.class);
	private static final long serialVersionUID = 1L;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public UnidadeException() {
       super();
   }

	public UnidadeException(final String s, final Throwable throwable) {
       super(s, throwable);
   }

	public UnidadeException(final String s) {
       super(s);
   }

	public UnidadeException(final Throwable throwable) {
       super(throwable);
   }
}
