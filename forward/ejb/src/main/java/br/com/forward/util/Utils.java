package br.com.forward.util;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class Utils {
	private static final Logger LOGGER = LogManager.getLogger(Utils.class);

	private Utils() {
		throw new AssertionError();
	}

//	public static <T> void sort(List<T> list, String propertyName, boolean asc) {
//		if ((list != null) && (list.size() > 0))
//			Collections.sort(list, comparator(list, propertyName, asc));
//	}
//
//	public static <T> T max(List<T> list, String propertyName) {
//		Object type = null;
//
//		if ((list != null) && (list.size() > 0)) {
//			type = Collections.max(list, comparator(list, propertyName, Boolean.TRUE.booleanValue()));
//		}
//
//		return (T) type;
//	}
//
//	public static <T> T min(List<T> list, String propertyName) {
//		Object type = null;
//
//		if ((list != null) && (list.size() > 0)) {
//			type = Collections.min(list, comparator(list, propertyName, Boolean.TRUE.booleanValue()));
//		}
//
//		return (T) type;
//	}

	public static Object getValueMethodGetter(String attribute, Object object) {
		Object value = null;
		try {
			if (object != null) {
				int index = 0;
				String[] attributes = attribute.split("\\.");
				Method methodGet = object.getClass().getMethod(
						"get" + attributes[0].substring(0, 1).toUpperCase() + attributes[0].substring(1), new Class[0]);
				Object valueGet = methodGet.invoke(object, new Object[0]);
				if ((valueGet != null) && (attributes.length - 1 > 0)) {
					StringBuilder attributesSB = new StringBuilder();
					for (int i = 1; i < attributes.length; i++) {
						attributesSB.append(attributes[i] + ".");
					}
					value = getValueMethodGetter(attributesSB.toString().trim(), valueGet);
				} else {
					value = valueGet;
				}
			}
		} catch (Exception e) {
			LOGGER.warn("Erro m�todo getValueMethodGetter", e);
		}

		return value;
	}

	public static Date getDateTime(String dateAsString) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Constants.DEFAULT_LOCALE);
			date = dateFormat.parse(dateAsString);
		} catch (ParseException e) {
			LOGGER.error("Erro ao converter texto em data e hora.", e);
		}

		return date;
	}

	public static Date getDate(String dateAsString) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Constants.DEFAULT_LOCALE);
			date = dateFormat.parse(dateAsString);
		} catch (ParseException e) {
			LOGGER.error("Erro ao converter texto em data.", e);
		}

		return date;
	}

	public static Date getTime(String dateAsString) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Constants.DEFAULT_LOCALE);
			date = dateFormat.parse(dateAsString);
		} catch (ParseException e) {
			LOGGER.error("Erro ao converter texto em hora.", e);
		}

		return date;
	}

	public static String formatDateToString(Date date) {
		String retorno = "";

		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Constants.DEFAULT_LOCALE);
			retorno = dateFormat.format(date);
		}

		return retorno;
	}

	public static String formatDateTimeToString(Date date) {
		String retorno = "";

		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Constants.DEFAULT_LOCALE);
			retorno = dateFormat.format(date);
		}

		return retorno;
	}

	public static BigDecimal getBigDecimal(Double number) {
		BigDecimal bigDecimal = null;

		if (number != null) {
			bigDecimal = new BigDecimal(number.doubleValue());
		}

		return bigDecimal;
	}

	public static BigDecimal getBigDecimal(Float number) {
		BigDecimal bigDecimal = null;

		if (number != null) {
			bigDecimal = new BigDecimal(number.floatValue());
		}

		return bigDecimal;
	}

	public static Boolean isCollectionNullOrEmpty(Collection<?> collection) {
		if ((collection != null) && (!collection.isEmpty()))
			return Boolean.valueOf(false);
		return Boolean.valueOf(true);
	}

	public static Boolean isCollectionNotNullAndNotEmpty(Collection<?> collection) {
		return Boolean.valueOf(!isCollectionNullOrEmpty(collection).booleanValue());
	}

	public static String normalizaString(String strEntrada) {
		return removeAcentos(strEntrada).trim().toUpperCase();
	}

	public static String removeAcentos(String strEntrada) {
		String retorno = "";

		if (!isStringEmpty(strEntrada).booleanValue()) {
			retorno = Normalizer.normalize(strEntrada, Normalizer.Form.NFD);
			retorno = retorno.replaceAll("[^a-zA-Z-Z0-9' ]", "");
		}

		return retorno;
	}

	public static Boolean isStringEmpty(String entrada) {
		if ((entrada != null) && (!entrada.isEmpty()))
			return Boolean.valueOf(false);
		return Boolean.valueOf(true);
	}

	public static Boolean isObjectNull(Object obj) {
		if (obj == null)
			return Boolean.valueOf(true);
		return Boolean.valueOf(false);
	}

	public static Boolean isBigDecimalGreaterThanZero(BigDecimal value) {
		if ((value != null) && (value.compareTo(BigDecimal.ZERO) > 0))
			return Boolean.valueOf(true);
		return Boolean.valueOf(false);
	}

	public static Boolean isBigDecimalEqualsZero(BigDecimal value) {
		if ((value != null) && (value.compareTo(BigDecimal.ZERO) == 0))
			return Boolean.valueOf(true);
		return Boolean.valueOf(false);
	}

	public static Boolean isIntegerGreaterThanZero(Integer value) {
		if ((value != null) && (value.intValue() > 0))
			return Boolean.valueOf(true);
		return Boolean.valueOf(false);
	}

	public static Boolean isDoubleGreaterThanZero(Double value) {
		if ((value != null) && (isBigDecimalGreaterThanZero(new BigDecimal(value.doubleValue())).booleanValue()))
			return Boolean.valueOf(true);
		return Boolean.valueOf(false);
	}

	public static String getValueResourceBundle(String bundleName, Locale locale, String key) {
		return getValueResourceBundle(bundleName, locale, key, null);
	}

	public static String getValueResourceBundle(String bundleName, Locale locale, String key, Object[] params) {
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		String text = null;
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = key + "not found";
		}

		if (params != null) {
			MessageFormat msgFmt = new MessageFormat(text, locale);
			text = msgFmt.format(params, new StringBuffer(), null).toString();
		}

		return text;
	}

	public static boolean isValidCnpj(Long cnpj) {
		boolean isValid = false;

		if (isNotEmpty(cnpj)) {
			isValid = isValidCnpj(cnpj.toString());
		}

		return isValid;
	}

	public static boolean isValidCnpj(String cnpj) {
		String localCnpj = cnpj;
		boolean retorno = false;

		localCnpj = localCnpj.replace(".", "");
		localCnpj = localCnpj.replace("/", "");
		localCnpj = localCnpj.replace("-", "");

		if (localCnpj.length() < 14) {
			localCnpj = StringUtils.leftPad(localCnpj, 14, "0");
		}

		if ((localCnpj.length() == 14) && (!isCheatingCnpj(localCnpj))) {
			String cnpjPrefix = localCnpj.substring(0, 12);

			cnpjPrefix = calculaCnpjPrimeiraParte(cnpjPrefix);

			cnpjPrefix = calculaCnpjSegundaParte(cnpjPrefix);
			retorno = localCnpj.equals(cnpjPrefix);
		}

		return retorno;
	}

	private static String calculaCnpjSegundaParte(String cnpjPrefix) {
		int soma = 0;
		StringBuffer retorno = new StringBuffer(cnpjPrefix);
		char[] charCnpjArray = cnpjPrefix.toCharArray();

		for (int i = 0; i < 5; i++) {
			if ((charCnpjArray[i] - '0' < 0) || (charCnpjArray[i] - '0' > 9))
				continue;
			soma += (charCnpjArray[i] - '0') * (7 - (i + 1));
		}

		for (int i = 0; i < 8; i++) {
			if ((charCnpjArray[(i + 5)] - '0' < 0) || (charCnpjArray[(i + 5)] - '0' > 9))
				continue;
			soma = soma + (charCnpjArray[(i + 5)] - '0') * (10 - (i + 1));
		}

		int digito = 11 - soma % 11;

		if ((digito == 10) || (digito == 11))
			retorno.append("0");
		else {
			retorno.append(Integer.toString(digito));
		}

		return retorno.toString();
	}

	private static String calculaCnpjPrimeiraParte(String cnpjPrefix) {
		int soma = 0;
		char[] charCnpjArray = cnpjPrefix.toCharArray();
		StringBuffer retorno = new StringBuffer(cnpjPrefix);

		for (int i = 0; i < 4; i++) {
			if ((charCnpjArray[i] - '0' < 0) || (charCnpjArray[i] - '0' > 9))
				continue;
			soma += (charCnpjArray[i] - '0') * (6 - (i + 1));
		}

		for (int i = 0; i < 8; i++) {
			if ((charCnpjArray[(i + 4)] - '0' < 0) || (charCnpjArray[(i + 4)] - '0' > 9))
				continue;
			soma = soma + (charCnpjArray[(i + 4)] - '0') * (10 - (i + 1));
		}

		int digito = 11 - soma % 11;

		if ((digito == 10) || (digito == 11))
			retorno.append("0");
		else {
			retorno.append(Integer.toString(digito));
		}

		return retorno.toString();
	}

	private static boolean isCheatingCnpj(String string) {
		String[] deny = { "00000000000000", "11111111111111", "22222222222222", "33333333333333", "44444444444444",
				"55555555555555", "66666666666666", "77777777777777", "88888888888888", "99999999999999" };
		boolean retorno = false;

		for (String element : deny) {
			if (element.equals(string)) {
				retorno = true;
				break;
			}
		}

		return retorno;
	}

	public static boolean isValidCpf(Long cpf) {
		boolean isValid = false;

		if (isNotEmpty(cpf)) {
			isValid = isValidCpf(cpf.toString());
		}

		return isValid;
	}

	public static boolean isValidCpf(String cpf) {
		boolean isValidCpf = true;
		String localCpf = StringUtils.leftPad(cpf, 11, "0");

		if (localCpf.length() != 11) {
			return false;
		}

		if (checkAllEquals(isValidCpf, localCpf)) {
			return false;
		}

		if (isValidCpf) {
			localCpf = preencheCpfZerosAEsquerda(localCpf);
			try {
				char dig10 = calculaPrimeiroDigitoCPF(localCpf);

				isValidCpf = calculaSegundoDigitoCpf(localCpf, dig10);
			} catch (InputMismatchException erro) {
				isValidCpf = false;
			}
		}

		return isValidCpf;
	}

	private static boolean calculaSegundoDigitoCpf(String localCpf, char dig10) {
		int somaTmp = 0;
		int peso = 11;

		for (int index = 0; index < 10; index++) {
			int num = localCpf.charAt(index) - '0';
			somaTmp += num * peso;
			peso--;
		}

		int resto = 11 - somaTmp % 11;
		char dig11;
		if ((resto == 10) || (resto == 11))
			dig11 = "0".charAt(0);
		else
			dig11 = (char) (resto + 48);
		boolean isValidCpf;
		if ((dig10 == localCpf.charAt(9)) && (dig11 == localCpf.charAt(10)))
			isValidCpf = true;
		else {
			isValidCpf = false;
		}

		return isValidCpf;
	}

	private static char calculaPrimeiroDigitoCPF(String localCpf) {
		int somaTmp = 0;
		int peso = 10;

		for (int index = 0; index < 9; index++) {
			int num = localCpf.charAt(index) - '0';
			somaTmp += num * peso;
			peso--;
		}

		int resto = 11 - somaTmp % 11;
		char dig10;
		if ((resto == 10) || (resto == 11))
			dig10 = "0".charAt(0);
		else {
			dig10 = (char) (resto + 48);
		}

		return dig10;
	}

	private static String preencheCpfZerosAEsquerda(String valor) {
		String retorno = valor;

		if (valor.length() < 11) {
			retorno = StringUtils.leftPad(valor, 11, "0");
		}

		return retorno;
	}

	private static boolean checkAllEquals(boolean isValidCpf, String localCpf) {
		boolean retorno = false;

		if (isValidCpf) {
			char firstChar = localCpf.charAt(0);
			boolean allEquals = true;

			for (char charAt : localCpf.toCharArray()) {
				if (charAt != firstChar) {
					allEquals = false;
					break;
				}
			}

			retorno = allEquals;
		}

		return retorno;
	}

	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);

		return matcher.find();
	}

	public static Boolean isValidShort(String shortNumber) {
		boolean retorno = false;

		if (!"".equals(normalizaString(shortNumber))) {
			try {
				Short.valueOf(shortNumber);
				retorno = true;
			} catch (NumberFormatException e) {
				LOGGER.warn("Par�metro passado n�o � parse�vel");
			}
		}

		return Boolean.valueOf(retorno);
	}

	public static Boolean isValidBigDecimal(String bigDecimalNumber) {
		boolean retorno = false;

		if (!"".equals(normalizaString(bigDecimalNumber))) {
			try {
				new BigDecimal(bigDecimalNumber);
				retorno = true;
			} catch (NumberFormatException e) {
				LOGGER.warn("Par�metro passado n�o � parse�vel");
			}
		}

		return Boolean.valueOf(retorno);
	}

	public static BigDecimal getBigDecimal(String bigDecimalNumber) {
		BigDecimal retorno = null;

		if ("".equals(normalizaString(bigDecimalNumber)))
			retorno = BigDecimal.ZERO;
		else {
			try {
				retorno = new BigDecimal(bigDecimalNumber);
			} catch (NumberFormatException e) {
				retorno = BigDecimal.ZERO;
			}
		}

		return retorno;
	}

	public static Integer getInteger(String numberString) {
		Integer numberInteger = Integer.valueOf(0);
		try {
			numberInteger = Integer.valueOf(numberString);
		} catch (Exception e) {
			LOGGER.error("[Utils.getInteger] Erro ao converter String em Integer.", e);
		}

		return numberInteger;
	}

	public static <T extends Number> T getNumber(Number valor, Class<T> tipoRetorno) {
		Number numeroRetorno = null;

		if (valor != null) {
			String valorStr = valor.toString();

			if (tipoRetorno == Integer.class)
				numeroRetorno = Integer.valueOf(valorStr);
			else if (tipoRetorno == Long.class)
				numeroRetorno = Long.valueOf(valorStr);
			else if (tipoRetorno == Short.class)
				numeroRetorno = Short.valueOf(valorStr);
			else if (tipoRetorno == Float.class)
				numeroRetorno = new Float(valorStr);
			else if (tipoRetorno == Double.class)
				numeroRetorno = new Double(valorStr);
			else if (tipoRetorno == Byte.class)
				numeroRetorno = Byte.valueOf(valorStr);
			else if (tipoRetorno == BigInteger.class)
				numeroRetorno = new BigInteger(valorStr);
			else if (tipoRetorno == BigDecimal.class) {
				numeroRetorno = new BigDecimal(valorStr);
			}
		}

		return (T) numeroRetorno;
	}

	public static <T> boolean isGenerateHistorico(T type1, T type2) {
		boolean isGenerateHistorico = false;
		boolean teste1 = (type1 == null) && (type2 != null);

		if (type1 != null) {
			if ((type1 instanceof BigDecimal)) {
				boolean teste2 = (type2 != null) && (((BigDecimal) type1).compareTo((BigDecimal) type2) != 0);
				isGenerateHistorico = (teste1) || (teste2);
			} else if (((type1 instanceof String)) && ((type2 instanceof String))) {
				String str1 = StringUtils.trimToEmpty((String) type1);
				String str2 = StringUtils.trimToEmpty((String) type2);
				isGenerateHistorico = (!str1.equals(str2)) || (teste1);
			} else {
				isGenerateHistorico = (!type1.equals(type2)) || (teste1);
			}
		} else
			isGenerateHistorico = teste1;

		return isGenerateHistorico;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static boolean isEmpty(Object obj) {
		boolean retorno = true;

		if (obj != null) {
			if ((obj instanceof String)) {
				String newValor = (String) obj;
				if (!"".equals(newValor.trim()))
					retorno = false;
			} else if ((obj instanceof Date)) {
				Date newValor = (Date) obj;
				if (newValor.getTime() > 0L)
					retorno = false;
			} else if ((obj instanceof Long)) {
				Long newValor = (Long) obj;
				if (newValor.longValue() > 0L)
					retorno = false;
			} else if ((obj instanceof Integer)) {
				Integer newValor = (Integer) obj;
				if (newValor.intValue() > 0)
					retorno = false;
			} else if ((obj instanceof BigDecimal)) {
				BigDecimal newValor = (BigDecimal) obj;
				if (newValor.compareTo(BigDecimal.ZERO) != 0)
					retorno = false;
			} else if ((obj instanceof Short)) {
				Short newValor = (Short) obj;
				if (newValor.shortValue() > 0)
					retorno = false;
			} else if ((obj instanceof Collection)) {
				Collection collection = (Collection) obj;
				if (!collection.isEmpty())
					retorno = false;
			} else if ((obj instanceof Boolean)) {
				Boolean newValor = (Boolean) obj;
				if (newValor != null)
					retorno = false;
			} else if ((obj instanceof Serializable)) {
				Serializable newValor = (Serializable) obj;
				if (newValor != null) {
					retorno = false;
				}
			}
		}

		return retorno;
	}

	public static boolean isAnyEmpty(Object[] listaParametros) {
		boolean retorno = false;

		Object[] arrayOfObject = listaParametros;
		int j = listaParametros.length;
		for (int i = 0; i < j; i++) {
			Object o = arrayOfObject[i];
			if (isEmpty(o)) {
				retorno = true;
				break;
			}
		}

		return retorno;
	}

	public static boolean isValueInList(Object value, Object[] list) {
		boolean isInList = false;

		if ((value != null) && (isNotEmpty(list))) {
			for (Object o : list) {
				if ((o != null) && (o.equals(value))) {
					isInList = true;
					break;
				}
			}
		}

		return isInList;
	}

	public static boolean isAllEmpty(Object[] listaParametros) {
		boolean retorno = true;

		Object[] arrayOfObject = listaParametros;
		int j = listaParametros.length;
		for (int i = 0; i < j; i++) {
			Object o = arrayOfObject[i];
			if (isNotEmpty(o)) {
				retorno = false;
				break;
			}
		}

		return retorno;
	}

	public static void resetTimeInDate(Date date, boolean after) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(11, hourBeforeAfter(after));
			cal.set(12, minuteBeforeAfter(after));
			cal.set(13, minuteBeforeAfter(after));
			cal.set(14, minuteBeforeAfter(after));
			date.setTime(cal.getTimeInMillis());
		}
	}

	private static int minuteBeforeAfter(boolean after) {
		int ret = 0;

		if (after) {
			ret = 59;
		}

		return ret;
	}

	private static int hourBeforeAfter(boolean after) {
		int ret = 0;

		if (after) {
			ret = 23;
		}

		return ret;
	}

	public static BigDecimal formatarBigDecimal(BigDecimal valor) {
		BigDecimal newValor = BigDecimal.ZERO;

		if (valor != null) {
			newValor = newValor.add(valor);
			newValor = newValor.round(new MathContext(2, RoundingMode.HALF_UP));
		}

		return newValor;
	}


//	public static <T> Comparator<T> comparator(List<T> list, String propertyName, boolean asc) {
//		Comparator comparator = null;
//
//		if ((list != null) && (list.size() > 0)) {
//			comparator = new Comparator() {
//				public int compare(Object type1, Object type2) {
//					try {
//						Object value1 = Utils.getValueMethodGetter(Utils.this, type1);
//						Object value2 = Utils.getValueMethodGetter(Utils.this, type2);
//
//						if ((value1 != null) && (value2 != null)) {
//							if ((value1 instanceof String))
//								return this.val$asc ? ((String) value1).compareTo((String) value2)
//										: ((String) value2).compareTo((String) value1);
//							if ((value1 instanceof Long))
//								return this.val$asc ? ((Long) value1).compareTo((Long) value2)
//										: ((Long) value2).compareTo((Long) value1);
//							if ((value1 instanceof Short))
//								return this.val$asc ? ((Short) value1).compareTo((Short) value2)
//										: ((Short) value2).compareTo((Short) value1);
//							if ((value1 instanceof Integer))
//								return this.val$asc ? ((Integer) value1).compareTo((Integer) value2)
//										: ((Integer) value2).compareTo((Integer) value1);
//							if ((value1 instanceof Date))
//								return this.val$asc ? ((Date) value1).compareTo((Date) value2)
//										: ((Date) value2).compareTo((Date) value1);
//							if ((value1 instanceof Character))
//								return this.val$asc ? ((Character) value1).compareTo((Character) value2)
//										: ((Character) value2).compareTo((Character) value1);
//							if ((value1 instanceof Boolean))
//								return this.val$asc ? ((Boolean) value1).compareTo((Boolean) value2)
//										: ((Boolean) value2).compareTo((Boolean) value1);
//							if ((value1 instanceof BigDecimal)) {
//								return this.val$asc ? ((BigDecimal) value1).compareTo((BigDecimal) value2)
//										: ((BigDecimal) value2).compareTo((BigDecimal) value1);
//							}
//						}
//						return 0;
//					} catch (Exception e) {
//						Utils.LOGGER.warn("Erro m�todo sort", e);
//					}
//					return 0;
//				}
//			};
//		}
//
//		return comparator;
//	}

	public static String preencheZerosEsquerda(String str, int tamanho) {
		return StringUtils.leftPad(str, tamanho, "0");
	}

	public static String preencheZerosDireita(String str, int tamanho) {
		return StringUtils.rightPad(str, tamanho, "0");
	}

	public static <T> List<T> convertArrayToList(T[] array) {
		return Arrays.asList(array);
	}

	public static long getDiasDatas(Date dataInicio, Date dataFim) {
		long retorno = 0L;

		if (!dataFim.before(dataInicio)) {
			retorno = (dataFim.getTime() - dataInicio.getTime()) / 1000L / 60L / 60L / 24L;
		}

		return retorno;
	}

	public static long getMinutosDatas(Date dataInicio, Date dataFim) {
		long retorno = 0L;

		if (!dataFim.before(dataInicio)) {
			retorno = (dataFim.getTime() - dataInicio.getTime()) / 1000L / 60L;
		}

		return retorno;
	}

	public static long getMinutosPorHorasDiaria(String horaInicial, String horaFinal) {
		Integer horasInicio = Integer.valueOf(Integer.parseInt(horaInicial.split(":")[0]));
		Integer minutosInicio = Integer.valueOf(Integer.parseInt(horaInicial.split(":")[1]));

		Integer horasFim = Integer.valueOf(Integer.parseInt(horaFinal.split(":")[0]));
		Integer minutosFim = Integer.valueOf(Integer.parseInt(horaFinal.split(":")[1]));

		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.set(11, horasInicio.intValue());
		calendarInicio.set(12, minutosInicio.intValue());
		calendarInicio.set(13, 0);
		calendarInicio.set(14, 0);
		Date dataInicio = calendarInicio.getTime();

		Calendar calendarFim = Calendar.getInstance();
		calendarFim.set(11, horasFim.intValue());
		calendarFim.set(12, minutosFim.intValue());
		calendarFim.set(13, 0);
		calendarFim.set(14, 0);
		Date dataFim = calendarFim.getTime();

		long minutos = getMinutosDatas(dataInicio, dataFim);

		return minutos;
	}

	public static boolean isHoraAtualBetween(String horaInicial, String horaFinal, Calendar calendarInicioDias) {
		Integer horasInicio = Integer.valueOf(Integer.parseInt(horaInicial.split(":")[0]));
		Integer minutosInicio = Integer.valueOf(Integer.parseInt(horaInicial.split(":")[1]));

		Integer horasFim = Integer.valueOf(Integer.parseInt(horaFinal.split(":")[0]));
		Integer minutosFim = Integer.valueOf(Integer.parseInt(horaFinal.split(":")[1]));

		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.set(11, horasInicio.intValue());
		calendarInicio.set(12, minutosInicio.intValue());

		Calendar calendarFim = Calendar.getInstance();
		calendarFim.set(11, horasFim.intValue());
		calendarFim.set(12, minutosFim.intValue());

		Calendar calendarDias = Calendar.getInstance();
		calendarDias.set(11, calendarInicioDias.get(11));
		calendarDias.set(12, calendarInicioDias.get(12));

		return (calendarDias.getTime().after(calendarInicio.getTime()))
				&& (calendarDias.getTime().before(calendarFim.getTime()));
	}

	public static int compareDate(Calendar calendarInicioDias, Calendar calendarFimDias) {
		return formatDate(calendarInicioDias.getTime()).compareTo(formatDate(calendarFimDias.getTime()));
	}

	public static long getMinutosConverterHoras(long valor) {
		return valor * 60L;
	}

	public static long getMinutosConverterDias(long valor) {
		return valor * 24L * getMinutosConverterHoras(valor);
	}

	public static Date getDataNow() {
		return Calendar.getInstance().getTime();
	}

	public static Date formatDate(Date date) {
		Date dataFormatada = null;
		try {
			if (date != null) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Constants.DEFAULT_LOCALE);
				dataFormatada = dateFormat.parse(dateFormat.format(date));
			}
		} catch (Exception e) {
			LOGGER.error("ERROR formatDate", e);
		}

		return dataFormatada;
	}

	public static Date getDataDefinidaPorDias(Date date, int qtdeDias) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(5, qtdeDias);
		return calendar.getTime();
	}

	public static boolean isValidHoras(String horas) {
		Boolean isValid = Boolean.TRUE;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Constants.DEFAULT_LOCALE);
			sdf.setLenient(false);
			sdf.parse(horas);
		} catch (Exception e) {
			isValid = Boolean.FALSE;
		}

		return isValid.booleanValue();
	}

	public static void clearList(List<?> lista) {
		if (isNotEmpty(lista))
			lista.clear();
	}

	public static Boolean isValidDate(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		Integer dia = Integer.valueOf(calendar.get(5));
		Integer mes = Integer.valueOf(calendar.get(2) + 1);
		Integer ano = Integer.valueOf(calendar.get(1));

		StringBuffer dataString = new StringBuffer(preencheZerosEsquerda(dia.toString(), 2)).append("/")
				.append(preencheZerosEsquerda(mes.toString(), 2)).append("/").append(ano);

		SimpleDateFormat dataValida = new SimpleDateFormat("dd/MM/yyyy");
		dataValida.setLenient(false);
		try {
			dataValida.parse(dataString.toString());
			return Boolean.valueOf(true);
		} catch (Exception e) {
		}
		return Boolean.valueOf(false);
	}

	public static boolean containsSpecialCharacters(String stringToVerify) {
		String regularExpression = "[^0-9a-zA-Z���������������������������������� \\-]";
		Pattern validadorCaracteres = Pattern.compile("[^0-9a-zA-Z���������������������������������� \\-]");

		return validadorCaracteres.matcher(stringToVerify).find();
	}

	public static Date converterParaDate(XMLGregorianCalendar dataAtualizacao) {
		if (isObjectNull(dataAtualizacao).booleanValue()) {
			return null;
		}

		return dataAtualizacao.toGregorianCalendar().getTime();
	}

	public static Short getDigitoCpf(Long cpf) {
		Short digitoCpf = null;
		try {
			if (isNotEmpty(cpf)) {
				String cpfString = MaskUtils.applyCpf(cpf);
				if ((isNotEmpty(cpfString)) && (cpfString.length() == 14)) {
					cpfString = String.valueOf(cpf);
					cpfString = cpfString.substring(cpfString.length() - 2, cpfString.length());
					digitoCpf = Short.valueOf(cpfString);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter digito do CPF: " + cpf);
		}
		return digitoCpf;
	}

	public static Short getDigitoCnpj(Long cnpj) {
		Short digitoCnpj = null;
		try {
			if (isNotEmpty(cnpj)) {
				String cnpjString = MaskUtils.applyCnpj(cnpj);
				if ((isNotEmpty(cnpjString)) && (cnpjString.length() == 18)) {
					cnpjString = String.valueOf(cnpj);
					cnpjString = cnpjString.substring(cnpjString.length() - 2, cnpjString.length());
					digitoCnpj = Short.valueOf(cnpjString);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter digito do CNPJ: " + cnpj);
		}
		return digitoCnpj;
	}

	public static Short getOrdemCnpj(Long cnpj) {
		Short ordemCnpj = null;
		try {
			if (isNotEmpty(cnpj)) {
				String cnpjString = MaskUtils.applyCnpj(cnpj);
				if ((isNotEmpty(cnpjString)) && (cnpjString.length() == 18)) {
					cnpjString = String.valueOf(cnpj);
					cnpjString = cnpjString.substring(cnpjString.length() - 6, cnpjString.length() - 2);
					ordemCnpj = Short.valueOf(cnpjString);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter ordem do CNPJ: " + cnpj);
		}
		return ordemCnpj;
	}

	public static Long getNumeroCpf(Long cpf) {
		Long numeroCpf = null;
		try {
			if (isNotEmpty(cpf)) {
				String cpfString = MaskUtils.applyCpf(cpf);
				if ((isNotEmpty(cpfString)) && (cpfString.length() == 14)) {
					cpfString = String.valueOf(cpf);
					cpfString = cpfString.substring(0, cpfString.length() - 2);
					numeroCpf = Long.valueOf(cpfString);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter numero do CPF: " + cpf);
		}
		return numeroCpf;
	}

	public static Long getNumeroCnpj(Long cnpj) {
		Long numeroCpf = null;
		try {
			if (isNotEmpty(cnpj)) {
				String cnpjString = MaskUtils.applyCnpj(cnpj);
				if ((isNotEmpty(cnpjString)) && (cnpjString.length() == 18)) {
					cnpjString = String.valueOf(cnpj);
					cnpjString = cnpjString.substring(0, cnpjString.length() - 6);
					numeroCpf = Long.valueOf(cnpjString);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter numero do CNPJ: " + cnpj);
		}
		return numeroCpf;
	}

	public static Long getCpf(Long numeroCpf, Short digitoCpf) {
		Long cpf = null;
		try {
			if ((isNotEmpty(numeroCpf)) && (isNotEmpty(digitoCpf))) {
				String numeroCpfString = preencheZerosEsquerda(numeroCpf.toString(), 9);
				String digitoCpfString = preencheZerosEsquerda(digitoCpf.toString(), 2);
				String cpfString = MaskUtils.applyCpf(numeroCpfString + digitoCpfString);
				if ((isNotEmpty(cpfString)) && (cpfString.length() == 14))
					cpf = MaskUtils.removeCpf(cpfString);
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter CPF: [N�mero=" + numeroCpf + ", D�gito=" + digitoCpf + "]");
		}
		return cpf;
	}

	public static Long getCnpj(Long numeroCnpj, Short ordemCnpj, Short digitoCnpj) {
		Long cnpj = null;
		try {
			if ((isNotEmpty(numeroCnpj)) && (isNotEmpty(ordemCnpj)) && (isNotEmpty(digitoCnpj))) {
				String numeroCnpjString = preencheZerosEsquerda(numeroCnpj.toString(), 8);
				String ordemCnpjString = preencheZerosEsquerda(ordemCnpj.toString(), 4);
				String digitoCnpjString = preencheZerosEsquerda(digitoCnpj.toString(), 2);
				String cnpjString = MaskUtils.applyCnpj(numeroCnpjString + ordemCnpjString + digitoCnpjString);
				if ((isNotEmpty(cnpjString)) && (cnpjString.length() == 18))
					cnpj = MaskUtils.removeCnpj(cnpjString);
			}
		} catch (Exception e) {
			LOGGER.error("Erro ao obter CNPJ: [N�mero=" + numeroCnpj + ", Ordem=" + ordemCnpj + ", D�gito=" + digitoCnpj
					+ "]");
		}
		return cnpj;
	}

	public static void fillQueryFilters(Query query, Map<String, Object> queryParameter) {
		for (String key : queryParameter.keySet())
			query.setParameter(key, queryParameter.get(key));
	}

	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
		XMLGregorianCalendar xmlCalendar = null;
		try {
			if (isNotEmpty(date)) {
				GregorianCalendar gCalendar = new GregorianCalendar();
				gCalendar.setTime(date);
				xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
			}
		} catch (Exception e) {
			LOGGER.warn("ERROR para converter Date para XMLGregorianCalendar. ", e);
		}
		return xmlCalendar;
	}

	public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar) {
		Date date = null;
		try {
			if (isNotEmpty(xmlGregorianCalendar))
				date = xmlGregorianCalendar.toGregorianCalendar().getTime();
		} catch (Exception e) {
			LOGGER.warn("ERROR para converter XMLGregorianCalendar para Date. ", e);
		}
		return date;
	}

	public static <T> String retornaVazioSeObjetoNulo(T valor) {
		String retorno = "";
		if (valor != null) {
			retorno = valor.toString();
		}
		return retorno;
	}
}
