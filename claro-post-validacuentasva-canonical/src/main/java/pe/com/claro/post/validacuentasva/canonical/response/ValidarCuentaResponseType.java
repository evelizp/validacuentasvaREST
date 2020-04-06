package pe.com.claro.post.validacuentasva.canonical.response;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import pe.com.claro.common.property.ConstantesValidacion;
import pe.com.claro.post.validacuentasva.canonical.types.ResponseAuditType;

public class ValidarCuentaResponseType implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = ConstantesValidacion.NOT_NULL)
	private ResponseAuditType responseAudit;
    private String existenciaCuenta;
    private String tipoConfiguracion;
    
	public ResponseAuditType getResponseAudit() {
		return responseAudit;
	}
	public void setResponseAudit(ResponseAuditType responseAudit) {
		this.responseAudit = responseAudit;
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