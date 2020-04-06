package pe.com.claro.post.validacuentasva.canonical.bean;

public class SpValidarEmailBean {

	private String parametro;
	private String estado;
	private String codigoRespuesta;
	private String mensajeRespuesta;
    private String existenciaCuenta;
    private String tipoConfiguracion;
	
	public String getParametro() {
      return parametro;
    }
    public void setParametro(String parametro) {
      this.parametro = parametro;
    }
    public String getEstado() {
      return estado;
    }
    public void setEstado(String estado) {
      this.estado = estado;
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