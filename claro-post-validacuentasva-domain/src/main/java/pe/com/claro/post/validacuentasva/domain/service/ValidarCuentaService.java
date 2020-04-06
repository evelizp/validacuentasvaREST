package pe.com.claro.post.validacuentasva.domain.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.exception.DBException;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.post.validacuentasva.canonical.bean.SpValidarCuentaBean;
import pe.com.claro.post.validacuentasva.canonical.bean.SpValidarEmailBean;
import pe.com.claro.post.validacuentasva.canonical.request.ValidarCuentaRequest;
import pe.com.claro.post.validacuentasva.canonical.response.ValidarCuentaResponseType;
import pe.com.claro.post.validacuentasva.canonical.types.ResponseAuditType;
import pe.com.claro.post.validacuentasva.domain.repository.CclDbRepository;

@Stateless
public class ValidarCuentaService implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@EJB
	CclDbRepository cobsdbRepository;

	public ValidarCuentaResponseType registraCambioDatosCliente(HeaderRequest headerRequest,
			ValidarCuentaRequest request, PropertiesExternos propertiesExterno, String trazabilidad)
			throws DBException {

		logger.info(trazabilidad + Constantes.TEXTOESPACIO
				+ "====== [Inicio] En Service validarCuentaService ====== ");
		ValidarCuentaResponseType response = new ValidarCuentaResponseType();
		ResponseAuditType auditResponseType = new ResponseAuditType();

		SpValidarCuentaBean responseSp = new SpValidarCuentaBean();
		SpValidarEmailBean responseSp2 = new SpValidarEmailBean();
		try {
			logger.info(trazabilidad + Constantes.SEPARADOR);
			logger.info(trazabilidad + Constantes.TEXTOESPACIO + Constantes.INICIO_ACTIVIDAD
					+ Constantes.ACTIVIDAD_VALIDAR_CUENTA);
			logger.info(trazabilidad + Constantes.SEPARADOR);
			logger.info(trazabilidad +"[request]"+ request.getPlataforma());
			logger.info(trazabilidad +"[properties]"+ propertiesExterno.plataforma);
			if (request.getPlataforma().equalsIgnoreCase(propertiesExterno.plataforma)) {		  
			
			  responseSp = validarCuentaCv(request, propertiesExterno, trazabilidad);
								
				logger.info(trazabilidad + Constantes.SEPARADOR);
				logger.info(trazabilidad + Constantes.TEXTOESPACIO + Constantes.FIN_ACTIVIDAD
						+ Constantes.ACTIVIDAD_VALIDAR_CUENTA);
				logger.info(trazabilidad + Constantes.SEPARADOR);
				String codParametro = propertiesExterno.codigoParametro;
				String codEstado = propertiesExterno.codigoEstado;
				if (responseSp.getCodigoRespuesta().equalsIgnoreCase(Constantes.UNO)) {
					logger.info(trazabilidad + "[MensajeRespuesta] :" +responseSp.getMensajeRespuesta());
					
					responseSp2 = obtenerValidacionCorreo(codParametro,codEstado, propertiesExterno, trazabilidad);
					
				}else {
				    logger.info(trazabilidad + "[MensajeRespuesta] :" +responseSp.getMensajeRespuesta());
					responseSp2 = obtenerValidacionCorreo(codParametro,codEstado, propertiesExterno, trazabilidad);
				}
				
				if (responseSp2.getTipoConfiguracion().equalsIgnoreCase(propertiesExterno.restringido)) {
					auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
					auditResponseType.setCodigoRespuesta(propertiesExterno.codigoIdf0);
					auditResponseType.setMensajeRespuesta(propertiesExterno.mensajeIdf0);
					response.setExistenciaCuenta(responseSp.getCodigoRespuesta());
					response.setTipoConfiguracion(responseSp2.getTipoConfiguracion());
					response.setResponseAudit(auditResponseType);
				}else if (responseSp2.getTipoConfiguracion().equalsIgnoreCase(propertiesExterno.informativo)) {
					auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
					auditResponseType.setCodigoRespuesta(propertiesExterno.codigoIdf0);
					auditResponseType.setMensajeRespuesta(propertiesExterno.mensajeIdf0);
					response.setExistenciaCuenta(responseSp.getCodigoRespuesta());
					response.setTipoConfiguracion(responseSp2.getTipoConfiguracion());
					response.setResponseAudit(auditResponseType);
				}
			}else {
			  logger.info(trazabilidad +"[propertiesc]"+ propertiesExterno.codigoIdf2);
			  logger.info(trazabilidad +"[propertiesm]"+ propertiesExterno.mensajeIdf2);
				auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
				auditResponseType.setCodigoRespuesta(propertiesExterno.codigoIdf2);
				auditResponseType.setMensajeRespuesta(propertiesExterno.mensajeIdf2);
				response.setResponseAudit(auditResponseType);
			}
	
		} catch (DBException e) {

			logger.error(e, e);
			auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
			auditResponseType.setMensajeRespuesta(e.getMessage());
			auditResponseType.setCodigoRespuesta(e.getCode());
			response.setResponseAudit(auditResponseType);

		} catch (Exception e) {

			logger.error(e, e);
			String error = e.getMessage() == null ? "Error" : e.getMessage();

			auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
			auditResponseType.setMensajeRespuesta(String.format(propertiesExterno.idt3Mensaje, error));
			auditResponseType.setCodigoRespuesta(propertiesExterno.idt3Codigo);

			response.setResponseAudit(auditResponseType);

		} finally {
			logger.info(trazabilidad + Constantes.TEXTOESPACIO + "====== [Fin] En Service validarCuentaService ====== ");
		}
		return response;
	}

	private SpValidarEmailBean obtenerValidacionCorreo(String codParametro,String codEstado,
			PropertiesExternos prop, String trazabilidad) throws DBException {
		
		SpValidarEmailBean responseSp = new SpValidarEmailBean();
		SpValidarEmailBean requestSp = new SpValidarEmailBean();

		requestSp.setParametro(codParametro);
		requestSp.setEstado(codEstado);
		responseSp = cobsdbRepository.validarCorreo(requestSp, prop, trazabilidad);

		return responseSp;
	}

	private SpValidarCuentaBean validarCuentaCv(ValidarCuentaRequest request,
			PropertiesExternos prop, String trazabilidad) throws DBException {
		SpValidarCuentaBean responseSp = new SpValidarCuentaBean();
		SpValidarCuentaBean requestSp = new SpValidarCuentaBean();

		requestSp.setCorreo(request.getCorreo());

		responseSp = cobsdbRepository.validarCuenta(requestSp, prop, trazabilidad);

		return responseSp;
	}
}