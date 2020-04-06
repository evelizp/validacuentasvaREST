package pe.com.claro.post.validacuentasva.canonical.bean;

public class SpValidarCuentaBean {

	private String correo;
	private String plataforma;
	private String codigoRespuesta;
	private String mensajeRespuesta;
    private String existenciaCuenta;
    private String tipoConfiguracion;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
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
	public String getExistenciaCuenta() {
		return existenciaCuenta;
	}
	public void setExistenciaCuenta(String existenciaCuenta) {
		this.existenciaCuenta = existenciaCuenta;
	}
	public String getTipoConfiguracion() {
		return tipoConfiguracion;
	}
	public void setTipoConfiguracion(String tipoConfiguracion) {
		this.tipoConfiguracion = tipoConfiguracion;
	}

}