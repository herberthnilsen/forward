 package br.com.forward.util;
 
 import java.math.BigDecimal;
 import java.text.DecimalFormat;
 import java.text.DecimalFormatSymbols;
 import java.util.Locale;
 import org.codehaus.plexus.util.StringUtils;
 
 public final class MaskUtils
 {
   private static final DecimalFormatSymbols MOEDA = new DecimalFormatSymbols(new Locale("pt", "BR"));
 
   private static final DecimalFormat MOEDA_DECIMAL_FORMAT = new DecimalFormat("� #,##0.00", MOEDA);
 
   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
 
   private static final DecimalFormat PORCENTAGEM_FORMAT = new DecimalFormat("0.00");
 
   private static final DecimalFormat COORDENADA_FORMAT = new DecimalFormat("0.000000");
 
   private MaskUtils()
   {
     throw new AssertionError();
   }
 
   public static String applyCnpj(String cnpj)
   {
     String mask = null;
 
     if (cnpj != null) {
       mask = StringUtils.leftPad(cnpj, 14, "0");
       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1\\.$2\\.$3/$4-$5");
     }
 
     return mask;
   }
 
   public static String applyCnpj(Long cnpj)
   {
     String mask = null;
 
     if (cnpj != null) {
       mask = StringUtils.leftPad(cnpj.toString(), 14, "0");
       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1\\.$2\\.$3/$4-$5");
     }
 
     return mask;
   }
 
   public static Long removeCnpj(String cnpjMask)
   {
     Long retorno = null;
 
     if (cnpjMask != null) {
       retorno = Long.valueOf(cnpjMask.replace(".", "")
         .replace("/", "")
         .replace("-", ""));
     }
 
     return retorno;
   }
 
   public static String applyCpf(String cpf)
   {
     String mask = null;
 
     if (cpf != null) {
       mask = StringUtils.leftPad(cpf, 11, "0");
       mask = mask.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
     }
 
     return mask;
   }
 
   public static String applyCpf(Long cpf)
   {
     String mask = null;
 
     if (cpf != null) {
       mask = StringUtils.leftPad(cpf.toString(), 11, "0");
       mask = mask.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
     }
 
     return mask;
   }
 
   public static Long removeCpf(String cpfMask)
   {
     Long retorno = null;
 
     if (cpfMask != null) {
       retorno = Long.valueOf(cpfMask.replace(".", "").replace("-", 
         ""));
     }
 
     return retorno;
   }
 
   public static String applyCep(String cep)
   {
     String mask = null;
 
     if (cep != null) {
       mask = StringUtils.leftPad(cep, 8, "0");
       mask = mask.replaceAll("([0-9]{5})([0-9]{3})", "$1-$2");
     }
 
     return mask;
   }
 
   public static Integer removeCep(String cepMask)
   {
     Integer retorno = null;
 
     if (cepMask != null) {
       retorno = Integer.valueOf(cepMask.replace("-", ""));
     }
 
     return retorno;
   }
 
   public static String removeCepToString(String cepMask)
   {
     String retorno = null;
     String cepMaskTemp = StringUtils.leftPad(cepMask, 8, "0");
 
     if (cepMaskTemp != null) {
       retorno = cepMaskTemp.replace("-", "");
     }
 
     return retorno;
   }
 
   public static String applyDdd(String ddd)
   {
     String mask = "";
 
     if (ddd != null) {
       mask = "(".concat(ddd.trim()).concat(")");
     }
 
     return mask;
   }
 
   public static String removeDdd(String dddMask)
   {
     String localDddMask = dddMask;
 
     if (localDddMask != null) {
       localDddMask = localDddMask.replace("(", "").replace(
         ")", "");
     }
 
     return localDddMask;
   }
 
   public static String applyTelefone(String telefone)
   {
     String mask = "";
 
     if (telefone != null) {
       if (telefone.length() == 9)
         mask = telefone.replaceAll("([0-9]{5})([0-9]{4})", "$1-$2");
       else if (telefone.length() == 8) {
         mask = telefone.replaceAll("([0-9]{4})([0-9]{4})", "$1-$2");
       }
     }
 
     return mask;
   }
 
   public static Long removeTelefone(String telefoneMask)
   {
     Long retorno = null;
 
     if (telefoneMask != null) {
       retorno = Long.valueOf(telefoneMask.replace("-", ""));
     }
 
     return retorno;
   }
 
   public static String applyPorcentagem(BigDecimal porcentagem)
   {
     String mask = null;
 
     if (porcentagem != null) {
       mask = PORCENTAGEM_FORMAT.format(porcentagem);
       mask = mask.concat("%");
     }
 
     return mask;
   }
 
   public static BigDecimal removePorcentagem(String porcentagemMask)
   {
     BigDecimal retorno = null;
 
     if (porcentagemMask != null) {
       retorno = new BigDecimal(porcentagemMask.replace("%", "").replace(
         ",", "."));
     }
 
     return retorno;
   }
 
   public static String applyDecimalFormat(BigDecimal bigDecimal, Boolean isCurrencyFormat)
   {
     String mask = null;
 
     if (bigDecimal != null) {
       if (isCurrencyFormat.booleanValue())
         mask = MOEDA_DECIMAL_FORMAT.format(bigDecimal);
       else {
         mask = DECIMAL_FORMAT.format(bigDecimal);
       }
     }
 
     return mask;
   }
 
   public static String applyCoordenadaFormat(BigDecimal bigDecimal)
   {
     String mask = null;
 
     if (bigDecimal != null) {
       mask = COORDENADA_FORMAT.format(bigDecimal);
     }
 
     return mask;
   }
 
   public static BigDecimal removeDecimalFormat(String bigDecimalMask)
   {
     BigDecimal retorno = null;
 
     if (StringUtils.isNotEmpty(bigDecimalMask)) {
       retorno = new BigDecimal(bigDecimalMask
         .replaceAll("\\.", "")
         .replaceAll(",", ".")
         .replace("R$ ", ""));
     }
 
     return retorno;
   }
 
   public static String removeRg(String stringValue)
   {
     String localStringValue = stringValue;
 
     if (localStringValue != null) {
       localStringValue = localStringValue.replaceAll("\\.", 
         "").replace("-", "");
     }
 
     return localStringValue;
   }
 
   public static String applyRg(String regGeral)
   {
     String mask = null;
 
     if (regGeral != null) {
       mask = StringUtils.leftPad(regGeral, 9, "0");
       mask = mask.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([a-zA-Z0-9]{1})", "$1\\.$2\\.$3-$4");
     }
 
     return mask;
   }
 
   public static String getValueMaskFormat(String pMask, String pValue, boolean pReturnValueEmpty)
   {
     String retorno = "";
 
     if ((!pReturnValueEmpty) || ((pValue != null) && (!pValue.trim().equals(""))))
     {
       String mask = pMask.replaceAll(String.valueOf(9), "#");
 
       for (int i = 0; i < pValue.length(); i++) {
         mask = mask.replaceFirst("#", pValue.substring(i, i + 1));
       }
 
       retorno = mask.replaceAll("#", "");
     }
 
     return retorno;
   }
 
   public static String applyNumero(BigDecimal numero, DecimalFormat formato)
   {
     String mask = null;
 
     if (numero != null) {
       mask = formato.format(numero);
     }
 
     return mask;
   }
 
   public static BigDecimal removeNumero(String numeroMask)
   {
     BigDecimal retorno = null;
 
     if (numeroMask != null) {
       retorno = new BigDecimal(numeroMask);
     }
 
     return retorno;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.util.MaskUtils
 * JD-Core Version:    0.6.0
 */