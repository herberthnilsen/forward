/*     */ package br.com.forward.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.util.Locale;
/*     */ import org.codehaus.plexus.util.StringUtils;
/*     */ 
/*     */ public final class MaskUtils
/*     */ {
/*  17 */   private static final DecimalFormatSymbols MOEDA = new DecimalFormatSymbols(new Locale("pt", "BR"));
/*     */ 
/*  19 */   private static final DecimalFormat MOEDA_DECIMAL_FORMAT = new DecimalFormat("� #,##0.00", MOEDA);
/*     */ 
/*  21 */   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
/*     */ 
/*  23 */   private static final DecimalFormat PORCENTAGEM_FORMAT = new DecimalFormat("0.00");
/*     */ 
/*  25 */   private static final DecimalFormat COORDENADA_FORMAT = new DecimalFormat("0.000000");
/*     */ 
/*     */   private MaskUtils()
/*     */   {
/*  32 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */   public static String applyCnpj(String cnpj)
/*     */   {
/*  42 */     String mask = null;
/*     */ 
/*  44 */     if (cnpj != null) {
/*  45 */       mask = StringUtils.leftPad(cnpj, 14, "0");
/*  46 */       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1\\.$2\\.$3/$4-$5");
/*     */     }
/*     */ 
/*  49 */     return mask;
/*     */   }
/*     */ 
/*     */   public static String applyCnpj(Long cnpj)
/*     */   {
/*  59 */     String mask = null;
/*     */ 
/*  61 */     if (cnpj != null) {
/*  62 */       mask = StringUtils.leftPad(cnpj.toString(), 14, "0");
/*  63 */       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1\\.$2\\.$3/$4-$5");
/*     */     }
/*     */ 
/*  66 */     return mask;
/*     */   }
/*     */ 
/*     */   public static Long removeCnpj(String cnpjMask)
/*     */   {
/*  76 */     Long retorno = null;
/*     */ 
/*  78 */     if (cnpjMask != null) {
/*  79 */       retorno = Long.valueOf(cnpjMask.replace(".", "")
/*  80 */         .replace("/", "")
/*  81 */         .replace("-", ""));
/*     */     }
/*     */ 
/*  84 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyCpf(String cpf)
/*     */   {
/*  94 */     String mask = null;
/*     */ 
/*  96 */     if (cpf != null) {
/*  97 */       mask = StringUtils.leftPad(cpf, 11, "0");
/*  98 */       mask = mask.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
/*     */     }
/*     */ 
/* 101 */     return mask;
/*     */   }
/*     */ 
/*     */   public static String applyCpf(Long cpf)
/*     */   {
/* 111 */     String mask = null;
/*     */ 
/* 113 */     if (cpf != null) {
/* 114 */       mask = StringUtils.leftPad(cpf.toString(), 11, "0");
/* 115 */       mask = mask.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
/*     */     }
/*     */ 
/* 118 */     return mask;
/*     */   }
/*     */ 
/*     */   public static Long removeCpf(String cpfMask)
/*     */   {
/* 128 */     Long retorno = null;
/*     */ 
/* 130 */     if (cpfMask != null) {
/* 131 */       retorno = Long.valueOf(cpfMask.replace(".", "").replace("-", 
/* 132 */         ""));
/*     */     }
/*     */ 
/* 135 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyCep(String cep)
/*     */   {
/* 145 */     String mask = null;
/*     */ 
/* 147 */     if (cep != null) {
/* 148 */       mask = StringUtils.leftPad(cep, 8, "0");
/* 149 */       mask = mask.replaceAll("([0-9]{5})([0-9]{3})", "$1-$2");
/*     */     }
/*     */ 
/* 152 */     return mask;
/*     */   }
/*     */ 
/*     */   public static Integer removeCep(String cepMask)
/*     */   {
/* 162 */     Integer retorno = null;
/*     */ 
/* 164 */     if (cepMask != null) {
/* 165 */       retorno = Integer.valueOf(cepMask.replace("-", ""));
/*     */     }
/*     */ 
/* 168 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String removeCepToString(String cepMask)
/*     */   {
/* 178 */     String retorno = null;
/* 179 */     String cepMaskTemp = StringUtils.leftPad(cepMask, 8, "0");
/*     */ 
/* 181 */     if (cepMaskTemp != null) {
/* 182 */       retorno = cepMaskTemp.replace("-", "");
/*     */     }
/*     */ 
/* 185 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyDdd(String ddd)
/*     */   {
/* 195 */     String mask = "";
/*     */ 
/* 197 */     if (ddd != null) {
/* 198 */       mask = "(".concat(ddd.trim()).concat(")");
/*     */     }
/*     */ 
/* 201 */     return mask;
/*     */   }
/*     */ 
/*     */   public static String removeDdd(String dddMask)
/*     */   {
/* 211 */     String localDddMask = dddMask;
/*     */ 
/* 213 */     if (localDddMask != null) {
/* 214 */       localDddMask = localDddMask.replace("(", "").replace(
/* 215 */         ")", "");
/*     */     }
/*     */ 
/* 218 */     return localDddMask;
/*     */   }
/*     */ 
/*     */   public static String applyTelefone(String telefone)
/*     */   {
/* 228 */     String mask = "";
/*     */ 
/* 230 */     if (telefone != null) {
/* 231 */       if (telefone.length() == 9)
/* 232 */         mask = telefone.replaceAll("([0-9]{5})([0-9]{4})", "$1-$2");
/* 233 */       else if (telefone.length() == 8) {
/* 234 */         mask = telefone.replaceAll("([0-9]{4})([0-9]{4})", "$1-$2");
/*     */       }
/*     */     }
/*     */ 
/* 238 */     return mask;
/*     */   }
/*     */ 
/*     */   public static Long removeTelefone(String telefoneMask)
/*     */   {
/* 248 */     Long retorno = null;
/*     */ 
/* 250 */     if (telefoneMask != null) {
/* 251 */       retorno = Long.valueOf(telefoneMask.replace("-", ""));
/*     */     }
/*     */ 
/* 254 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyPorcentagem(BigDecimal porcentagem)
/*     */   {
/* 264 */     String mask = null;
/*     */ 
/* 266 */     if (porcentagem != null) {
/* 267 */       mask = PORCENTAGEM_FORMAT.format(porcentagem);
/* 268 */       mask = mask.concat("%");
/*     */     }
/*     */ 
/* 271 */     return mask;
/*     */   }
/*     */ 
/*     */   public static BigDecimal removePorcentagem(String porcentagemMask)
/*     */   {
/* 281 */     BigDecimal retorno = null;
/*     */ 
/* 283 */     if (porcentagemMask != null) {
/* 284 */       retorno = new BigDecimal(porcentagemMask.replace("%", "").replace(
/* 285 */         ",", "."));
/*     */     }
/*     */ 
/* 288 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyDecimalFormat(BigDecimal bigDecimal, Boolean isCurrencyFormat)
/*     */   {
/* 299 */     String mask = null;
/*     */ 
/* 301 */     if (bigDecimal != null) {
/* 302 */       if (isCurrencyFormat.booleanValue())
/* 303 */         mask = MOEDA_DECIMAL_FORMAT.format(bigDecimal);
/*     */       else {
/* 305 */         mask = DECIMAL_FORMAT.format(bigDecimal);
/*     */       }
/*     */     }
/*     */ 
/* 309 */     return mask;
/*     */   }
/*     */ 
/*     */   public static String applyCoordenadaFormat(BigDecimal bigDecimal)
/*     */   {
/* 320 */     String mask = null;
/*     */ 
/* 322 */     if (bigDecimal != null) {
/* 323 */       mask = COORDENADA_FORMAT.format(bigDecimal);
/*     */     }
/*     */ 
/* 326 */     return mask;
/*     */   }
/*     */ 
/*     */   public static BigDecimal removeDecimalFormat(String bigDecimalMask)
/*     */   {
/* 336 */     BigDecimal retorno = null;
/*     */ 
/* 338 */     if (StringUtils.isNotEmpty(bigDecimalMask)) {
/* 339 */       retorno = new BigDecimal(bigDecimalMask
/* 340 */         .replaceAll("\\.", "")
/* 341 */         .replaceAll(",", ".")
/* 342 */         .replace("R$ ", ""));
/*     */     }
/*     */ 
/* 345 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String removeRg(String stringValue)
/*     */   {
/* 355 */     String localStringValue = stringValue;
/*     */ 
/* 357 */     if (localStringValue != null) {
/* 358 */       localStringValue = localStringValue.replaceAll("\\.", 
/* 359 */         "").replace("-", "");
/*     */     }
/*     */ 
/* 362 */     return localStringValue;
/*     */   }
/*     */ 
/*     */   public static String applyRg(String regGeral)
/*     */   {
/* 372 */     String mask = null;
/*     */ 
/* 374 */     if (regGeral != null) {
/* 375 */       mask = StringUtils.leftPad(regGeral, 9, "0");
/* 376 */       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([a-zA-Z0-9]{1})", "$1\\.$2\\.$3-$4");
/*     */     }
/*     */ 
/* 379 */     return mask;
/*     */   }
/*     */ 
/*     */   public static String getValueMaskFormat(String pMask, String pValue, boolean pReturnValueEmpty)
/*     */   {
/* 389 */     String retorno = "";
/*     */ 
/* 395 */     if ((!pReturnValueEmpty) || ((pValue != null) && (!pValue.trim().equals(""))))
/*     */     {
/* 400 */       String mask = pMask.replaceAll(String.valueOf(9), "#");
/*     */ 
/* 405 */       for (int i = 0; i < pValue.length(); i++) {
/* 406 */         mask = mask.replaceFirst("#", pValue.substring(i, i + 1));
/*     */       }
/*     */ 
/* 412 */       retorno = mask.replaceAll("#", "");
/*     */     }
/*     */ 
/* 415 */     return retorno;
/*     */   }
/*     */ 
/*     */   public static String applyNumero(BigDecimal numero, DecimalFormat formato)
/*     */   {
/* 427 */     String mask = null;
/*     */ 
/* 429 */     if (numero != null) {
/* 430 */       mask = formato.format(numero);
/*     */     }
/*     */ 
/* 433 */     return mask;
/*     */   }
/*     */ 
/*     */   public static BigDecimal removeNumero(String numeroMask)
/*     */   {
/* 443 */     BigDecimal retorno = null;
/*     */ 
/* 445 */     if (numeroMask != null) {
/* 446 */       retorno = new BigDecimal(numeroMask);
/*     */     }
/*     */ 
/* 449 */     return retorno;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.util.MaskUtils
 * JD-Core Version:    0.6.0
 */