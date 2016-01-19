 package br.com.forward.exception;
 
 import br.com.forward.enumcode.ExceptionEnum;
 import javax.ejb.ApplicationException;
 import org.apache.log4j.Level;
 import org.apache.log4j.LogManager;
 import org.apache.log4j.Logger;
 import org.codehaus.plexus.util.StringUtils;
 
 @ApplicationException(rollback=true)
 public class BusinessRuntimeException extends Exception
 {
   private static final Logger LOGGER = LogManager.getLogger(BusinessRuntimeException.class);
   private static final long serialVersionUID = 1L;
   private static final String LINE_SEPARATOR = System.getProperty("line.separator");
 
   public BusinessRuntimeException(String message, Throwable cause, ExceptionEnum logLevel)
   {
     super(message, cause);
     generateLog(message, cause, logLevel);
   }
 
   public BusinessRuntimeException(String message, Throwable cause, ExceptionEnum logLevel, String[] parameters)
   {
     super(convertMessages(message, parameters), cause);
     generateLog(convertMessages(message, parameters), cause, logLevel);
   }
 
   public BusinessRuntimeException(String message, ExceptionEnum logLevel)
   {
     super(message);
     generateLog(message, null, logLevel);
   }
 
   public BusinessRuntimeException(ExceptionEnum logLevel, String[] messages)
   {
     super(convertMessages(messages));
     generateLog(convertMessages(messages), null, logLevel);
   }
 
   public BusinessRuntimeException(ExceptionEnum logLevel, Throwable cause)
   {
     super(cause);
     generateLog(null, cause, logLevel);
   }
 
   private void generateLog(String message, Throwable cause, ExceptionEnum logLevel)
   {
     String messageAux = StringUtils.isEmpty(message) ? message : "";
     Level level = null;
     switch (logLevel) {
     case WARN:
       level = Level.DEBUG;
       break;
     case INFO:
       level = Level.INFO;
       break;
     case FATAL:
       level = Level.WARN;
       break;
     case DEBUG:
       level = Level.ERROR;
       break;
     case ERROR:
       level = Level.FATAL;
       break;
     }
 
     if (cause == null)
       LOGGER.log(level, messageAux);
     else
       LOGGER.log(level, messageAux, cause);
   }
 
   public static String convertMessages(String[] messages)
   {
     StringBuilder stringBuilder = new StringBuilder();
     String[] arrayOfString = messages; int j = messages.length; for (int i = 0; i < j; i++) { String message = arrayOfString[i];
       stringBuilder.append(message).append(LINE_SEPARATOR);
     }
     return stringBuilder.toString();
   }
 
   public static String convertMessages(String message, String[] parameters)
   {
     StringBuilder stringBuilder = new StringBuilder(message).append(LINE_SEPARATOR);
     int contadorAux = 1;
     for (String parameter : parameters) {
       stringBuilder.append(contadorAux++).append("=").append(parameter).append(LINE_SEPARATOR);
     }
     return stringBuilder.toString();
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.exception.BusinessRuntimeException
 * JD-Core Version:    0.6.0
 */