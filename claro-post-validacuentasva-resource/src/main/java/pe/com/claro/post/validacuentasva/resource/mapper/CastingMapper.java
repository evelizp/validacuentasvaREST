package pe.com.claro.post.validacuentasva.resource.mapper;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.com.claro.common.bean.BodyResponse;
import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.post.validacuentasva.canonical.request.ValidarCuentaRequest;

public class CastingMapper {
	
	private static final Logger logger = LoggerFactory.getLogger(CastingMapper.class);
	
	public static Object validarParametrosEntrada(String msjTxIn, HttpHeaders httpHeaders, Object beanRequest) {

		BodyResponse response = null;

		HeaderRequest header = new HeaderRequest(httpHeaders);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<HeaderRequest>> constraintViolations = validator.validate(header);

		logger.info(msjTxIn + "Evaluando header y body");
		if (!constraintViolations.isEmpty()) {
			response = new BodyResponse();
			response.setCodigoRespuesta(Constantes.UNO);
			response.setMensajeError("Datos de Cabecera incompletos, VERIFICAR:  " + header.toString());
			logger.info(msjTxIn + "Header no cumple validacion");
			return response;
		}

		String sBody = requestConfirmValues(beanRequest);

		if (!sBody.isEmpty()) {
			response = new BodyResponse();
			response.setCodigoRespuesta(Constantes.UNO);
			response.setMensajeError("Datos de Body incompletos, VERIFICAR:  " + sBody);
			logger.info(msjTxIn + "Body no cumple con parametros obligatorios");
			return response;
		}

		logger.info(msjTxIn + "Validacion correcta de header y body");
		response = new BodyResponse();
		response.setCodigoRespuesta(Constantes.ZERO);

		return response;
	}

	public static String requestConfirmValues(Object beanRequest) {
		String msgError = Constantes.TEXTOVACIO;
		logger.info("[Object] :" +beanRequest);
		if (beanRequest instanceof ValidarCuentaRequest) {
			return beanHaveViolations(beanRequest);
		} 
		return msgError;
	}

	public static String beanHaveViolations(Object request) {
		String msgError = Constantes.TEXTOVACIO;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
		if (constraintViolations.size() >= 1) {
			for (ConstraintViolation<Object> cv : constraintViolations) {
				msgError = cv.getPropertyPath() + " - " + cv.getMessage();
				break;
			}
		}
		return msgError;
	}
}