package pe.com.claro.common.resource.util;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("idPedidoSAP") String idPedido;
	private @QueryParam("numTelefono") String numTelefono;
	private @QueryParam("idVenta") String idVenta;

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	@Override
	public String toString() {
		return "MessageFilterBean [idPedido=" + idPedido + ", numTelefono=" + numTelefono + ", idVenta=" + idVenta
				+ "]";
	}

}
