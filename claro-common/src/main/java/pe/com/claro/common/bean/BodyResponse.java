package pe.com.claro.common.bean;

public class BodyResponse {

	private String mensajeError;
	private String codigoRespuesta;
	private String mensajeRespuesta;

	public BodyResponse() {
		super();
	}

	public BodyResponse(BodyResponse obj) {
		this.codigoRespuesta = obj.getCodigoRespuesta();
		this.mensajeRespuesta = obj.getMensajeRespuesta();
		this.mensajeError = obj.getMensajeError();
	}

	public BodyResponse(String mensajeError, String codigoRespuesta, String mensajeRespuesta) {
		super();
		this.mensajeError = mensajeError;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
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
