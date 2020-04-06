package pe.com.claro.post.validacuentasva.canonical.types;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pe.com.claro.common.property.ConstantesValidacion;

public class ResponseAuditType implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = ConstantesValidacion.NOT_NULL)
	@Size(min = 1, max = 32, message = ConstantesValidacion.SIZE)
	private String idTransaccion;

	@NotNull(message = ConstantesValidacion.NOT_NULL)
	@Size(min = 1, max = 10, message = ConstantesValidacion.SIZE)
	private String codigoRespuesta;

	@NotNull(message = ConstantesValidacion.NOT_NULL)
	@Size(min = 1, max = 128, message = ConstantesValidacion.SIZE)
	private String mensajeRespuesta;

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
}