package com.agroJaguar.br.fazendaJaguar.util;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Projeto: PBG - Projeto Baixa da Garantia
 *
 * @author Alexandre Martins Vaz <alexandre.m.vaz@br.unisys.com>
 *
 */
public class ValueUtils {
	public static final String SEPARADOR = "\u00AC";

	public static final String EMPTY = "";

	public static final String WHITE_SPACE = " ";

	public static final String NULL = null;

	/**
	 * Verifica se um id é válido (númerico e maior que zero)
	 *
	 * @param value
	 * @return boolean
	 */
	public static final boolean isValidId(Object value) {
		return getValidId(value) != null;
	}

	/**
	 * Verifica se um id é válido (númerico de ponto flutuante e maior que zero)
	 *
	 * @param value
	 * @return
	 */
	public static final boolean isValidDecimal(Object value) {
		return getValidDecimal(value) != null;
	}

	/**
	 * Retorna um valor numerico caso value seja um numero maior do que zero.
	 * Caso não seja retorna nulo
	 *
	 * @param value
	 * @return Long
	 */
	public static final Long getValidId(Object value) {
		try {
			long lvalue = value != null ? Long.parseLong(value.toString()) : 0;
			return lvalue > 0 ? lvalue : null;
		} catch (NumberFormatException e) { // NOPMD
			return null;
		}
	}

	/**
	 * Retorna um valor numerico de ponto flutuante caso value seja um numero
	 * maior do que zero. Caso não seja retorna nulo
	 *
	 * @param value
	 * @return Long
	 */
	public static final Double getValidDecimal(Object value) {
		try {
			Double lvalue = value != null ? Double.parseDouble(value.toString()) : 0D;
			return lvalue > 0D ? lvalue : null;
		} catch (NumberFormatException e) { // NOPMD
			return null;
		}
	}

	/**
	 * Verifica se um valor não é nulo ou vazio
	 */
	public static final boolean isNotBlank(Object value) {
		return value != null && value.toString().trim().length() > 0;
	}

	/**
	 * Verifica se um valor é nulo ou vazio
	 */
	public static final boolean isBlank(Object value) {
		return !isNotBlank(value);
	}

	/**
	 * Retorna o formato string de um valor ou "" caso esteja nulo
	 *
	 * @param value
	 * @return
	 */
	public static final String toSafeString(Object value) {
		return value != null ? value.toString() : EMPTY;
	}

	/**
	 * Concatena valores numa string com um separador ¬
	 *
	 * @param values
	 * @return
	 */
	public static final String concat(Object[] values) {
		if (values != null && values.length > 0) {
			StringBuilder str = new StringBuilder();
			str.append(toSafeString(values[0]));
			for (int i = 1; i < values.length; i++) {
				str.append(SEPARADOR).append(toSafeString(values[i]));
			}
			return str.toString();
		} else {
			return null;
		}
	}

	/**
	 * Quebra um valor string em array baseado no separador ¬
	 *
	 * @param value
	 * @return
	 */
	public static final String[] split(String value) {
		if (isNotBlank(value)) {
			return value.split(SEPARADOR);
		} else {
			return null;
		}
	}

	/**
	 * Obtem o valor em ums string com separador ¬ em uma posicao informada
	 *
	 * @param valueSplit
	 * @param pos
	 * @return
	 */
	public static final String getValueIn(String valueSplit, int pos) {
		String[] value = split(valueSplit);
		return value != null && value.length > 0 && pos < value.length ? value[pos] : null;
	}

	/**
	 * Troca o valor de uma string por outra
	 *
	 * @param value
	 * @param replace
	 * @return
	 */
	public static final String replace(String value, String replace, String newValue) {
		if (replace == null) {
			replace = "";
		}
		while (value != null && value.indexOf(replace) > -1) {
			int pos = value.indexOf(replace);
			value = value.substring(0, pos) + newValue + value.substring(pos + replace.length(), value.length());
		}
		return value;
	}

	/**
	 * Converte um valor para um integer caso possível
	 *
	 * @param value
	 * @return
	 */
	public static final Integer convertToInteger(Object value) {
		try {
			return value != null ? Integer.parseInt(value.toString()) : null;
		} catch (NumberFormatException e) { // NOPMD
			return null;
		}
	}

	/**
	 * Converte um valor para um long caso possível
	 *
	 * @param value
	 * @return
	 */
	public static final Long convertToLong(Object value) {
		try {
			return value != null ? Long.parseLong(value.toString()) : null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Verifica se uma valor é string "", se for retorna nulo, senão o proprio
	 * valor
	 *
	 * @param value
	 * @return
	 */
	public static String valueOrNullEmpty(String value) {
		return value != null && value.trim().length() > 0 ? value : null;
	}

	/**
	 * Junta todos os elementos da lista numa única string, separando-os
	 * conforme caracter informado
	 *
	 * @param data
	 *            Lista de strings
	 * @param separator
	 *            caracter separador
	 * @return String formatada
	 */
	public static String join(List<String> data, String separator) {
		if (data != null && data.size() > 0) {
			return join(data.toArray(new String[data.size()]), separator);
		}
		return null;
	}

	/**
	 * Junta todos os elementos do array numa única string, separando-os
	 * conforme caracter informado
	 *
	 * @param data
	 *            Array de strings
	 * @param separator
	 *            caracter separador
	 * @return String formatada
	 */
	public static String join(String[] data, String separator) {
		StringBuilder result = new StringBuilder();
		if (data != null && data.length > 0) {
			if (separator == null) {
				separator = ValueUtils.EMPTY;
			}
			for (String text : data) {
				if (result.length() > 0) {
					result.append(separator);
				}
				result.append(text);
			}
		}
		return (result.length() > 0 ? result.toString() : null);
	}

	/**
	 * Remove caracteres não numéricos de uma string
	 *
	 * @param valor
	 * @return
	 */
	public static String removeCaracteresNaoNumericos(String valor) {
		return (valor == null ? ValueUtils.EMPTY : valor.replaceAll("[^0-9]", ValueUtils.EMPTY));
	}

	/**
	 * Retorna o valor string de um objeto (caso não esteja nulo ou vazio) ou
	 * nulo do mesmo
	 *
	 * @param value
	 * @return
	 */
	public static final String strNotBlankOrNull(Object value) {
		return isNotBlank(value) ? value.toString() : null;
	}

	/**
	 * Retorna uma string sem espaços no início e fim ou nulo caso a mesma não
	 * tenha conteúdo após o trim
	 *
	 * @param str
	 * @return
	 */
	public static String trimToNull(String str) {
		return ((str != null && str.length() > 0 && str.trim().length() > 0) ? str.trim() : null);
	}

	/**
	 * Retorna uma string sem espaços no início e fim ou string vazia caso a
	 * mesma não tenha conteúdo após o trim
	 *
	 * @param str
	 * @return
	 */
	public static String trimToEmpty(String str) {
		return ((str != null && str.length() > 0 && str.trim().length() > 0) ? str.trim() : EMPTY);
	}
	
	public static Double formatDoubleSemCasasDecimais(Double str,String tipoAgregado) {
		if (isNotBlank(tipoAgregado) && tipoAgregado.equals("ADITIVO")){
			return formatDouble(str);
		}else{
			Integer valor = str.intValue();
			return str != null && str != 0.0 ?  new Double(valor) : null;
		}
	}
	
	public static Double formatDouble(Double str) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return str != null && str != 0.0 ?  new Double(fmt.format(str).replaceAll(",", ".")) : null;
	}
	
	public static Integer formatInteger(Integer str) {
		return str != null && str != 0 ?  str : null;
	}
	
	public static String convertStringValueToFormat(String numero, Integer qtdeCasasDecimais) {

		String casasDecimais = "";
        String num = numero;
        DecimalFormat df = null;
        if (qtdeCasasDecimais > 0) {
            for (int i = 0; i < qtdeCasasDecimais; i++) {
                casasDecimais = casasDecimais.concat("0");
            }
            if (num.equals("")) {
                num = "0.".concat(casasDecimais);
            }
            df = new DecimalFormat("0.".concat(casasDecimais));
            df.setMinimumFractionDigits(qtdeCasasDecimais);
            return df.format(new Double(num)).replaceAll(",", ".");
        }
        return null;
    }
}
