package br.com.forward.exception;

import javax.ejb.ApplicationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@ApplicationException(rollback = true)
public class ProspeccaoException extends Exception {
	private static final Logger LOGGER = LogManager.getLogger(ProspeccaoException.class);
	private static final long serialVersionUID = 1L;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public ProspeccaoException() {
       super();
   }

	public ProspeccaoException(final String s, final Throwable throwable) {
       super(s, throwable);
   }

	public ProspeccaoException(final String s) {
       super(s);
   }

	public ProspeccaoException(final Throwable throwable) {
       super(throwable);
   }
}
