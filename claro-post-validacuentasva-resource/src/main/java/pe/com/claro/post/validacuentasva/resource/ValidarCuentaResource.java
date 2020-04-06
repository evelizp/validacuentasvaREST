package pe.com.claro.post.validacuentasva.resource;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import pe.com.claro.common.bean.BodyResponse;
import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.post.validacuentasva.canonical.request.ValidarCuentaRequest;
import pe.com.claro.post.validacuentasva.canonical.response.ValidarCuentaResponseType;
import pe.com.claro.post.validacuentasva.canonical.types.AuditResponseType;
import pe.com.claro.post.validacuentasva.canonical.types.ResponseAuditType;
import pe.com.claro.post.validacuentasva.domain.service.ValidarCuentaService;
import pe.com.claro.post.validacuentasva.resource.mapper.CastingMapper;

@Stateless
@Path(Constantes.PATH)
@Consumes({ MediaType.APPLICATION_JSON })
@Api(value = Constantes.BASEPATH, description = Constantes.PATH_RESOURCE_DESCRIPCION)
@Produces({ MediaType.APPLICATION_JSON + Constantes.CHARSET })
public class ValidarCuentaResource {
	private static final Logger logger = Logger.getLogger(ValidarCuentaResource.class);

	@Context
	private Configuration configuration;
	private PropertiesExternos propertiesExternos;

	@EJB
	private ValidarCuentaService validarCuentaService;

	public void initProperties() {
		try {
			propertiesExternos = new PropertiesExternos(configuration);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@POST
	@Path(Constantes.REG_CAMBIO_DATOS_CLI)
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = Constantes.REG_CAMBIO_DATOS_CLI_DESC)
	public Response validarCuenta(@Context HttpHeaders httpHeaders,
			ValidarCuentaRequest request) throws JsonProcessingException {

		this.initProperties();

		Response resJSON = Response.ok().entity(Constantes.TEXTOVACIO).build();
		HeaderRequest headerRequest = new HeaderRequest(httpHeaders);
		long tiempoInicio = System.currentTimeMillis();
		Status httpCode = Status.OK;
		String result = null;
		ValidarCuentaResponseType response = new ValidarCuentaResponseType();
		ResponseAuditType auditResponseType = new ResponseAuditType();
		String idtx = headerRequest.getIdTransaccion();
		String msgid = headerRequest.getMsgid();
		String trazabilidad = Constantes.CHAR_CORCHETE_IZQUIERDO + Constantes.METODO_DATOS_CLIENTE + Constantes.ID_TXT
				+ idtx + Constantes.MSG_ID + msgid + Constantes.CORCHETE;

		logger.info(trazabilidad + Constantes.SEPARADOR);
		logger.info(trazabilidad + Constantes.INICIO_MET_REGISTRAR_DATOS_CLI);
		logger.info(trazabilidad + Constantes.SEPARADOR);

		try {
			logger.info(trazabilidad + Constantes.PARAMETROSHEADER + ClaroUtil.printPrettyJSONString(headerRequest));
			logger.info(trazabilidad + Constantes.PARAMETROSBODY + ClaroUtil.printPrettyJSONString(request));
			logger.info(trazabilidad + Constantes.PARAMETROSOBLIGATORIOS);

			BodyResponse bodyResponseValidacion = (BodyResponse) CastingMapper
					.validarParametrosEntrada(Constantes.TEXTOVACIO, httpHeaders, request);
			logger.info(trazabilidad +"[bodyResponseValidacion] :" +bodyResponseValidacion.getCodigoRespuesta());
			if (bodyResponseValidacion.getCodigoRespuesta().equals(Constantes.ZERO)) {
				response = validarCuentaService.registraCambioDatosCliente(headerRequest, request,
						propertiesExternos, trazabilidad);
				auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
				auditResponseType.setMensajeRespuesta(response.getResponseAudit().getMensajeRespuesta());
				auditResponseType.setCodigoRespuesta(response.getResponseAudit().getCodigoRespuesta());
				response.setResponseAudit(auditResponseType);
			} else {
				logger.info(trazabilidad + Constantes.VALIDACIONPARAMETROSINCORRECTOS
						+ bodyResponseValidacion.getMensajeError());
				auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
				auditResponseType.setMensajeRespuesta(propertiesExternos.mensajeIdf1);
				auditResponseType.setCodigoRespuesta(propertiesExternos.codigoIdf1);
				response.setResponseAudit(auditResponseType);
			}

		} catch (Exception e) {
			logger.error(e,e);
			httpCode = Status.BAD_REQUEST;
			String error = e.getMessage() == null ? "Error" : e.getMessage();
			auditResponseType.setIdTransaccion(headerRequest.getIdTransaccion());
			auditResponseType.setMensajeRespuesta(String.format(propertiesExternos.idt3Mensaje, error));
			auditResponseType.setCodigoRespuesta(propertiesExternos.idt3Codigo);
			response.setResponseAudit(auditResponseType);

		} finally {
			result = ClaroUtil.printPrettyJSONString(response);
			resJSON = Response.status(httpCode).entity(result).build();
			logger.info(trazabilidad + "Datos de salida: " + ClaroUtil.printPrettyJSONString(response));
			logger.info(trazabilidad + String.format("Tiempo TOTAL Proceso: [ %s milisegundos ]",
					(System.currentTimeMillis() - tiempoInicio)));
			logger.info(trazabilidad + Constantes.SEPARADOR);
			logger.info(trazabilidad + Constantes.FIN_MET_REGISTRAR_DATOS_CLI);
			logger.info(trazabilidad + Constantes.SEPARADOR);
		}
		return resJSON;
	}
}