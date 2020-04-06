package pe.com.claro.post.validacuentasva.resource.util;

import javax.ws.rs.core.HttpHeaders;

import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.property.JAXBUtilitarios;

public class RestUtilitarios {

	public static String getTransaccion(String nomMetodo, HttpHeaders httpHeaders) {
		StringBuffer stringBuffer = new StringBuffer();
		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: Constantes.EMPTY;
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0)
				: Constantes.EMPTY;

		stringBuffer.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		stringBuffer.append(nomMetodo);
		stringBuffer.append(Constantes.ID_TXT);
		stringBuffer.append(idTransaccion);
		stringBuffer.append(Constantes.ESPACIO);
		stringBuffer.append(Constantes.MSGID);
		stringBuffer.append(Constantes.IGUAL);
		stringBuffer.append(msgid);
		stringBuffer.append(Constantes.CHAR_CORCHETE_DERECHO);

		return stringBuffer.toString();
	}

	public static String loggerInicio(String mensajeTransaccion, String descripcion) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(Constantes.INICIO_METODO);
		stringBuffer.append(descripcion);
		stringBuffer.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		return stringBuffer.toString();
	}

	public static String loggerParametros(String mensajeTransaccion, String msgDatos, Object obj) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(msgDatos);
		stringBuffer.append(JAXBUtilitarios.anyObjectToXmlText(obj));
		return stringBuffer.toString();
	}

	public static String loggerMetodo(String mensajeTransaccion, String descripcion) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(Constantes.INI_CORCHETE1);
		stringBuffer.append(descripcion);
		stringBuffer.append(Constantes.CHAR_CORCHETE_DERECHO);
		return stringBuffer.toString();
	}

	public static String loggerActividad(int actividad, String mensajeTransaccion, String descripcion) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(" " + actividad + ". ");
		stringBuffer.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		stringBuffer.append(descripcion);
		stringBuffer.append(Constantes.CHAR_CORCHETE_DERECHO);
		return stringBuffer.toString();
	}

	public static String loggerFin(String mensajeTransaccion, String descripcion, Double tiempoInicio) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(Constantes.FIN_METODO);
		stringBuffer.append(descripcion);
		stringBuffer.append(Constantes.TIEMPO_TOTAL);
		stringBuffer.append((System.currentTimeMillis() - tiempoInicio));
		stringBuffer.append(Constantes.MILISEG);
		return stringBuffer.toString();
	}

	public static Object loggerException(String nomMetodo, HttpHeaders httpHeaders, Exception e) {
		StringBuffer stringBuffer = new StringBuffer();
		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: Constantes.EMPTY;

		stringBuffer.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		stringBuffer.append(nomMetodo);
		stringBuffer.append(Constantes.ID_TXT);
		stringBuffer.append(idTransaccion);
		stringBuffer.append(Constantes.CHAR_CORCHETE_DERECHO);
		stringBuffer.append("-");
		stringBuffer.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		stringBuffer.append(e.toString());
		stringBuffer.append(Constantes.CHAR_CORCHETE_DERECHO);
		return stringBuffer.toString();
	}

	public static String loggerFin(String mensajeTransaccion, long tiempoTotal, String nomMetodo) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(mensajeTransaccion);
		stringBuffer.append(Constantes.FIN_METODO);
		stringBuffer.append(nomMetodo);
		stringBuffer.append(Constantes.TIEMPO_TOTAL);
		stringBuffer.append(tiempoTotal);
		stringBuffer.append(Constantes.MILISEG);
		return stringBuffer.toString();
	}

}
