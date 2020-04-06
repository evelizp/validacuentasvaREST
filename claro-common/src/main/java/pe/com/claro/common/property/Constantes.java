package pe.com.claro.common.property;

public class Constantes {

	public static final String CHARSET = ";charset=UTF-8";
	public static final String APPLICATION_JSON = "application/json";
	public static final String RESOURCE = "/validacuentasva";
	public static final String PATHBASE = "/validacuentasva";
	public static final String VERSION = "1.0.0";
	public static final String NOMBRERECURSO = "claro-post-validacuentasva";
	public static final String PATH_RESOURCE_DESCRIPCION = "Operaciones sobre consulta pospago";
	public static final String PATH_METODO_DATOS_CLIENTE = "/validarCuenta";
	public static final String METODO_DATOS_CLIENTE = "validarCuenta";
	public static final String PATH_METODO_DATOS_CONTRATO = "/validarCuenta";
	public static final String METODO_DATOS_CONTRATO = "validarCuenta";

	public static final String DATAAUDIT = "dataAudit";
	public final static String ID_TXT = " idTx=";
	public final static String MSG_ID = " msgid=";
	public static final String SEPARADOR = "-----------------------------------------------------------------------------";
	public final static String SALTO_LINEA = "\n";
	public static final String PARAMETROSENTRADA = " Parametros de entrada: ";
	public static final String PARAMETROSSALIDA = " Parametros de salida: ";
	public static final String PARAMETROSHEADER = " Header Request:";
	public static final String PARAMETROSBODY = "Body Request: ";
	public static final String PARAMETROSOBLIGATORIOS = "----0. Validar parametros obligatorios ------";
	public static final String VALIDACIONPARAMETROSCORRECTOS = " Validacion correcta de parametros de entrada";
	public static final String VALIDACIONPARAMETROSINCORRECTOS = " Parametros de entrada no cumple validacion";
	public static final String DEVOLVERRESPONSE = " Response a devolver: ";
	public static final String ERROR_EXCEPTION = "Error Exception: ";
	public final static String TIEMPO_TOTAL = " ] Tiempo total de proceso (ms): ";
	public final static String MILISEGUNDOS = " milisegundos.";
	public final static String REPLACEMETODO = "";
	public final static String REPLACEWS = "";

	// -------- WS
	public static final String CLASSTIMEOUTCONNECTION = "com.sun.xml.ws.connect.timeout";
	public static final String CLASSTIMEOUTREQUEST = "com.sun.xml.ws.request.timeout";

	// --------
	public static final String SEPARADORPUNTO = ".";
	public static final String FORMATOFECHACABECERA = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String CODIGOFLAGACTIVO = "1";

	public static final String ID = "id";
	public static final String TEXTONULL = "null";
	public static final String TEXTOVACIO = "";

	public static final String FORMATOFECHADEFAULT = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATOFECHAISO = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMATOFECHA_ESTADO = "dd/MM/yyyy";
	// ----------------
	public static final String CODIGO200 = "200";
	public static final String CODIGO400 = "400";
	public static final String CODIGO404 = "404";
	public static final String MENSAJEOK = "OK";

	// --------Request---------
	public static final String IDTRANSACCION = "idTransaccion";
	public static final String MSGID = "msgid";
	public static final String USRID = "userId";
	public static final String TIMESTAMP = "timestamp";
	public static final String ACCEPT = "accept";
	public static final String IPAPLICACION = "ipAplicacion";
	public static final String NOMBAPLICACION = "nombreAplicacion";

	public static final String API = "api";
	public static final String CHAR_CORCHETE_IZQUIERDO = " [";
	public static final String CORCHETE = "]";
	// -----------------
	public static final String CONFIGPROPERTIES = "config.properties";
	public static final String SWAGGERJAXRSCONFIG = "SwaggerJaxrsConfig";
	public static final String URLSWAGGERJAXRSCONFIG = "/SwaggerJaxrsConfig";
	public static final String HTML5CORSFILTER = "HTML5CorsFilter";
	public static final String URLPATTERNS = "/api/*";
	public static final String ACCESSCONTROLALLOWORIGIN = "Access-Control-Allow-Origin";
	public static final String ACCESSCONTROLALLOWMETHODS = "Access-Control-Allow-Methods";
	public static final String ACCESSCONTROLALLOWHEADERS = "Access-Control-Allow-Headers";
	public static final String ASTERISCO = "*";
	public static final String METODOSPERMITIDOS = "GET, POST, DELETE, PUT";
	public static final String CONTENTTYPE = "Content-Type";
	// -----------------
	public static final String PROPERTIESINTERNOS = "config.properties";
	public static final String PROPERTIESEXTERNOS = ".properties";
	public static final String PROPERTIESKEY = "claro.properties";
	public static final String CONSTANTENOJNDI = "javax.persistence.PersistenceException";
	public static final String CONSTANTENOJNDIWS = "MessageBodyProviderNotFoundException";
	public static final String CONSTANTETIMEOUTWS = "java.net.SocketTimeoutException";
	public static final int NUM_ZERO = 0;
	public static final String ZERO = "0";
	public static final String UNO = "1";
	public static final String DOS = "2";
	public static final String TRES = "3";
	public static final String CUATRO = "4";
	public static final String CINCO = "5";
	public static final String SEIS = "6";
	public static final int XXI = 21;
	public static final String DEFAULTENCONDIGPROPERTIES = null;
	public static final String DEFAULTENCONDINGAPI = null;
	public static final String FORMATO_FECHA_SP = null;
	public static final Object NULO = null;
	// -----------------

	public final static int STATUS_TIME_OUT = 504;

	// Param DB
	public final static String TIEMPOTOTALPROCESO = "Tiempo TOTAL del proceso";
	public final static String CODIGOIDT1 = "consulta.clientes.valor.idt1.codigo";
	public final static String MENSAJEIDT1 = "consulta.clientes.valor.idt1.mensaje";
	public final static String CODIGOIDT2 = "consulta.clientes.valor.idt2.codigo";
	public final static String MENSAJEIDT2 = "consulta.clientes.valor.idt2.mensaje";

	public static final String PATH = "post/validacuentasva/v1.0.0";
	public static final String BASEPATH = "/claro-post-validacuentasva-resource/api";

	public static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
	public static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";
	public static final String TIMEOUT = "Timeout";
	public static final String EXCEPTION_WS_TIMEOUT_01 = "timed out";
	public static final String EXCEPTION_WS_TIMEOUT_02 = "SocketTimeoutException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_01 = "RemoteAccessException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_02 = "404";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_03 = "WebServiceException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_04 = "ConnectException";
	public static final String WSEXCEPTION_OCURRIDA = "WSException ocurrida ";
	public static final String EXCEPTION_OCURRIDA = "Excepcion ocurrida: ";
	public static final String TEXTO_ERROR = " Ocurrio un error: ";
	public static final String ERROR = "[ERROR]: ";

	public final static String INICIO_METODO = " INICIO METODO: ";
	public final static String FIN_METODO = " FIN METODO: ";
	public final static String INICIO_ACTIVIDAD = " [Inicio Actividad: ";
	public final static String FIN_ACTIVIDAD = " [Fin Actividad: ";


	public static final String METODO = "$metodo";
	public static final String WS = "$ws";
	public static final String EX_CON_CORCHETE = "[$ex]";
	public static final String ESPACIO = " ";
	public static final String IGUAL = "=";
	public static final String DOSPUNTOS = ": ";
	public static final String TIMEOUTEXCEPTION = "Timeout";
	public static final String PERSISTENCEEXCEPTION = "javax.persistence.PersistenceException";
	public static final String HIBERNATEJDBCEXCEPTION = "The application must supply JDBC connections";
	public static final String GENERICJDBCEXCEPTION = "org.hibernate.exception";
	public static final String TRACE = " [TRACE] ";
	public static final String CODE = " [CODE]= ";
	public static final String MSG = " [MSG]= ";
	public static final String VARIABLE_DB = "$bd";
	public static final String VARIABLE_SP = "$sp";
	public static final String PERSISTENCE_CONTEXT_BSCS = "consultapostpago.bscs";
	public static final String PERSISTENCE_CONTEXT_PVU = "consultapostpago.pvu";
	public static final String PERSISTENCE_CONTEXT_COBSDB = "consultapostpago.cobsdb";
	public static final String BUSCARPIPELINE = "\\|";
	public static final String EJECUTAR_SP = " Ejecutando SP: ";
	public static final String ERROR_EJECUCION_SP = " Error en la ejecucion del SP : ";


	public static final String TIEMPO_TOTAL_SP = " Tiempo total de proceso del llamado del SP (ms): ";
	public static final String INVOCO_SP = " Se invoco con exito el SP";
	public static final String PARAMETROS_SALIDA = " Parametros de salida: ";

	public static final String PLTFORMA_ASIS = "ASIS";
	public static final String PLTFORMA_TOBE = "TOBE";
	public static final String FORMATO_INTERNACIONAL = "51";
	public final static String EMPTY = "";
	public static final String CHAR_CORCHETE_DERECHO = " ] ";
	public final static String MILISEG = " milisegundos.";
	public final static String INI_CORCHETE1 = " 1. [";
	public static final String CONTEXTO = "Cargando el contexto Repository ";
	public static final String GUION = "-";
	public static final String PLATAFORMA = " Se valida plataforma: ";
	public static final String DATOS_ENTRADA = " Datos de Entrada: ";
	public static final String DATOS_SALIDA = " Datos de Salida: ";
	public static final String URL_WS_INVOCAR = " URL del Servicio a invocar: ";
	public static final String EXCEPCION_REST = " Excepcion ocurrida en la WS - REST ";
	public static final String P_PATH = "PATH: ";
	public static final String REQUEST_HEADER = " RequestHeader: ";
	public static final String REQUEST_BODY = " RequestBody: ";
	public static final String RESPONSE_HEADER = " ResponseHeader: ";
	public static final String RESPONSE_BODY = " ResponseBody: ";
	public static final String PALOTE = "|";
	public static final String PUNTO_COMA = ";";

	public static final String BARRA = "\\|";

	public static final String REG_CAMBIO_DATOS_CLI = "/validarCuenta";
	public static final String REG_CAMBIO_DATOS_CLI_DESC = "validar Cuenta";
	public static final String INICIO_MET_REGISTRAR_DATOS_CLI = "--------------  Inicio del metodo validarCuenta  -------------------";
	public static final String FIN_MET_REGISTRAR_DATOS_CLI = "--------------  Fin del metodo validarCuenta  -------------------";
	public static final String TEXTOBD = " BD : ";
	public static final String TEXTOJNDI = " JNDI : ";
	public static final String TEXTOOWNER = " OWNER : ";
	public static final String TEXTO_COMA = ",";
	public static final String TEXTOPAQUETE = " PAQUETE : ";
	public static final String TEXTOPROCEDURE = " PROCEDURE : ";
	public static final String CALL = "call ";
	public static final String COBS_DATOS_HIS_PARAMS = "(?,?,?)";
	public static final String CCLDB_DATOS_HIS_PARAMS = "(?,?,?,?,?)";
	public static final String PARAMINPUT = " PARAMETROS [INPUT]: ";
	public static final String PARAMOUTPUT = " PARAMETROS [OUTPUT]: ";
	public static final String CHAR_CORCHETE_PUNTOS = ": [";
	public static final String EXCEPTIONTEXT = " Excepcion ocurrida en la BD {";
	public static final String SQLTIMEOUTEXCEPTION = "SQLTIMEOUTEXCEPTION";
	public static final String TEXTOERRORTIMEOUT = "[Error De TimeOut en: ";
	public static final String TEXTOERRORDISPONIBILIDAD = "[Error De Disponibilidad en ] ";
	public static final String TEXTOESPACIO = " ";
	public static final String ACTIVIDAD_VALIDAR_CUENTA = "1. Validar Cuenta en Claro Video.";

	public static final String CORREO = "PI_CORREO";
	public static final String PI_COD_PARAMETRO = "PI_COD_PARAMETRO";
	public static final String PI_ESTADO = "PI_ESTADO";
	public static final String existenciaCuenta = "existenciaCuenta";
	public static final String tipoConfiguracion = "tipoConfiguracion";
	public static final String PO_VAL_PARAMETRO_DET = "PO_VAL_PARAMETRO_DET";
	
	public static final String PO_COD_RESPUESTA = "PO_COD_RESPUESTA";
	public static final String PO_MENSAJE_RESPUESTA = "PO_MENSAJE_RESPUESTA";

	// --------------------------------------------------------------

	public static final String ERROR_CONVERSION = "Error en la conversi�n ... ";
	public static final String VALUE_COR = "] value = [";
	public static final String COR_DERECHA = "] ";
	public static final String ERROR_PARSE_XML = "Error parseando object to xml:";
	public static final String COR_GUION = "] - [";
	public static final String ERROR_COR = "ERROR: [";

}