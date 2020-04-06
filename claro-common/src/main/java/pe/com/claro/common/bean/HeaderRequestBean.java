package pe.com.claro.common.bean;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;
import com.fasterxml.jackson.annotation.JsonInclude;
import pe.com.claro.common.property.Constantes;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderRequestBean {

	@NotNull
	private String idTransaccion;

	@NotNull
	private String msgid;

	@NotNull
	private String timestamp;

	@NotNull
	private String userId;

	@NotNull
	private String accept;

	private String ipAplicacion;

	private String nombreAplicacion;

	public HeaderRequestBean() {
		super();
	}

	public HeaderRequestBean(HttpHeaders httpHeaders) {
		super();
		this.idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(Constantes.NUM_ZERO) : null;
		this.msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(Constantes.NUM_ZERO) : null;
		this.timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(Constantes.NUM_ZERO) : null;
		this.userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(Constantes.NUM_ZERO) : null;
		this.accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(Constantes.NUM_ZERO) : null;
		this.ipAplicacion = httpHeaders.getRequestHeader(Constantes.IPAPLICACION) != null
				? httpHeaders.getRequestHeader(Constantes.IPAPLICACION).get(Constantes.NUM_ZERO) : null;
		this.nombreAplicacion = httpHeaders.getRequestHeader(Constantes.NOMBAPLICACION) != null
				? httpHeaders.getRequestHeader(Constantes.NOMBAPLICACION).get(Constantes.NUM_ZERO) : null;
	}

	public HeaderRequestBean(String idTransaccion, String msgid, String timestamp, String userId, String accept,
			String nombreAplicacion, String ipAplicacion) {
		super();
		this.idTransaccion = idTransaccion;
		this.msgid = msgid;
		this.timestamp = timestamp;
		this.userId = userId;
		this.accept = accept;
		this.ipAplicacion = ipAplicacion;
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getIpAplicacion() {
		return ipAplicacion;
	}

	public void setIpAplicacion(String ipAplicacion) {
		this.ipAplicacion = ipAplicacion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "HeaderRequestBean [idTransaccion=" + idTransaccion + ", msgid=" + msgid + ", timestamp=" + timestamp
		// + ", userId=" + userId + ", accept=" + accept + ", nombreAplicacion="
		// + nombreAplicacion
		// + ", ipAplicacion=" + ipAplicacion +
				+ "]";
	}
}
