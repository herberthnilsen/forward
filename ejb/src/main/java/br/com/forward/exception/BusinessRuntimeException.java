/*     */ package br.com.forward.exception;
/*     */ 
/*     */ import br.com.forward.enumcode.ExceptionEnum;
/*     */ import javax.ejb.ApplicationException;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.LogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.codehaus.plexus.util.StringUtils;
/*     */ 
/*     */ @ApplicationException(rollback=true)
/*     */ public class BusinessRuntimeException extends Exception
/*     */ {
/*  20 */   private static final Logger LOGGER = LogManager.getLogger(BusinessRuntimeException.class);
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final String LINE_SEPARATOR = System.getProperty("line.separator");
/*     */ 
/*     */   public BusinessRuntimeException(String message, Throwable cause, ExceptionEnum logLevel)
/*     */   {
/*  34 */     super(message, cause);
/*  35 */     generateLog(message, cause, logLevel);
/*     */   }
/*     */ 
/*     */   public BusinessRuntimeException(String message, Throwable cause, ExceptionEnum logLevel, String[] parameters)
/*     */   {
/*  48 */     super(convertMessages(message, parameters), cause);
/*  49 */     generateLog(convertMessages(message, parameters), cause, logLevel);
/*     */   }
/*     */ 
/*     */   public BusinessRuntimeException(String message, ExceptionEnum logLevel)
/*     */   {
/*  59 */     super(message);
/*  60 */     generateLog(message, null, logLevel);
/*     */   }
/*     */ 
/*     */   public BusinessRuntimeException(ExceptionEnum logLevel, String[] messages)
/*     */   {
/*  70 */     super(convertMessages(messages));
/*  71 */     generateLog(convertMessages(messages), null, logLevel);
/*     */   }
/*     */ 
/*     */   public BusinessRuntimeException(ExceptionEnum logLevel, Throwable cause)
/*     */   {
/*  81 */     super(cause);
/*  82 */     generateLog(null, cause, logLevel);
/*     */   }
/*     */ 
/*     */   private void generateLog(String message, Throwable cause, ExceptionEnum logLevel)
/*     */   {
/*  93 */     String messageAux = StringUtils.isEmpty(message) ? message : "";
/*  94 */     Level level = null;
/*  95 */     switch (logLevel) {
/*     */     case WARN:
/*  97 */       level = Level.DEBUG;
/*  98 */       break;
/*     */     case INFO:
/* 100 */       level = Level.INFO;
/* 101 */       break;
/*     */     case FATAL:
/* 103 */       level = Level.WARN;
/* 104 */       break;
/*     */     case DEBUG:
/* 106 */       level = Level.ERROR;
/* 107 */       break;
/*     */     case ERROR:
/* 109 */       level = Level.FATAL;
/* 110 */       break;
/*     */     }
/*     */ 
/* 115 */     if (cause == null)
/* 116 */       LOGGER.log(level, messageAux);
/*     */     else
/* 118 */       LOGGER.log(level, messageAux, cause);
/*     */   }
/*     */ 
/*     */   public static String convertMessages(String[] messages)
/*     */   {
/* 129 */     StringBuilder stringBuilder = new StringBuilder();
/* 130 */     String[] arrayOfString = messages; int j = messages.length; for (int i = 0; i < j; i++) { String message = arrayOfString[i];
/* 131 */       stringBuilder.append(message).append(LINE_SEPARATOR);
/*     */     }
/* 133 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   public static String convertMessages(String message, String[] parameters)
/*     */   {
/* 144 */     StringBuilder stringBuilder = new StringBuilder(message).append(LINE_SEPARATOR);
/* 145 */     int contadorAux = 1;
/* 146 */     for (String parameter : parameters) {
/* 147 */       stringBuilder.append(contadorAux++).append("=").append(parameter).append(LINE_SEPARATOR);
/*     */     }
/* 149 */     return stringBuilder.toString();
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.exception.BusinessRuntimeException
 * JD-Core Version:    0.6.0
 */