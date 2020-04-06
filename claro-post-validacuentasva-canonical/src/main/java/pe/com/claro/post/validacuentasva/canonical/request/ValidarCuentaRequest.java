package pe.com.claro.post.validacuentasva.canonical.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import pe.com.claro.common.property.ConstantesValidacion;

public class ValidarCuentaRequest {

	@NotNull(message = ConstantesValidacion.NOT_NULL)
	@Valid
//	private String idTransaccion;
	private String correo;
	private String plataforma;
	
  public String getPlataforma() {
    return plataforma;
  }
  public void setPlataforma(String plataforma) {
    this.plataforma = plataforma;
  }
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }

}