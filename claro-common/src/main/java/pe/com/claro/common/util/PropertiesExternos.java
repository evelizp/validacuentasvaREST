package pe.com.claro.common.util;

import javax.ws.rs.core.Configuration;

public class PropertiesExternos {

	public final String idt1Codigo;
	public final String idt1Mensaje;
	public final String idt2Codigo;
	public final String idt2Mensaje;
	public final String idt3Codigo;
	public final String idt3Mensaje;

	public final String codigoIdf0;
	public final String mensajeIdf0;
	public final String codigoIdf1;
	public final String mensajeIdf1;
	public final String codigoIdf2;
	public final String mensajeIdf2;
	public final String codigoIdf3;
	public final String mensajeIdf3;
	public final String codigoIdf4;
	public final String mensajeIdf4;

	public final String dbCcldbNombre;
	public final String dbCcldbOwner;
	public final String dbCcldbTimeout;
	public final String bdCcldbJndi;
	public final String bdCcldbPkgSvaCuenta;
	public final String bdCcldbSpValidarCuenta;
	public final String bdCcldbSpValidarCorreo;
	public final String plataforma;
	public final String restringido;
	public final String informativo;
    public final String codigoParametro;
    public final String codigoEstado;
	
	public PropertiesExternos(Configuration config) {
		super();

		this.idt1Codigo = ClaroUtil.convertProp(config.getProperty("idt1.codigo"));
		this.idt1Mensaje = ClaroUtil.convertProp(config.getProperty("idt1.mensaje"));
		this.idt2Codigo = ClaroUtil.convertProp(config.getProperty("idt2.codigo"));
		this.idt2Mensaje = ClaroUtil.convertProp(config.getProperty("idt2.mensaje"));
		this.idt3Codigo = ClaroUtil.convertProp(config.getProperty("idt3.codigo"));
		this.idt3Mensaje = ClaroUtil.convertProp(config.getProperty("idt3.mensaje"));

		this.codigoIdf0 = ClaroUtil.convertProp(config.getProperty("codigo.idf0"));
		this.mensajeIdf0 = ClaroUtil.convertProp(config.getProperty("mensaje.idf0"));
		this.codigoIdf1 = ClaroUtil.convertProp(config.getProperty("codigo.idf1"));
		this.mensajeIdf1 = ClaroUtil.convertProp(config.getProperty("mensaje.idf1"));
		this.codigoIdf2 = ClaroUtil.convertProp(config.getProperty("codigo.idf2"));
		this.mensajeIdf2 = ClaroUtil.convertProp(config.getProperty("mensaje.idf2"));
		this.codigoIdf3 = ClaroUtil.convertProp(config.getProperty("codigo.idf3"));
		this.mensajeIdf3 = ClaroUtil.convertProp(config.getProperty("mensaje.idf3"));
		this.codigoIdf4 = ClaroUtil.convertProp(config.getProperty("codigo.idf4"));
		this.mensajeIdf4 = ClaroUtil.convertProp(config.getProperty("mensaje.idf4"));
		

		this.dbCcldbNombre = ClaroUtil.convertProp(config.getProperty("db.ccldb.nombre"));
		this.dbCcldbOwner = ClaroUtil.convertProp(config.getProperty("db.ccldb.owner"));
		this.dbCcldbTimeout = ClaroUtil.convertProp(config.getProperty("db.ccldb.timeout"));
		this.bdCcldbJndi = ClaroUtil.convertProp(config.getProperty("bd.ccldb.noxa.jndi"));
		this.bdCcldbPkgSvaCuenta = ClaroUtil.convertProp(config.getProperty("bd.ccldb.pkg.cuenta.sva"));
		this.bdCcldbSpValidarCuenta = ClaroUtil.convertProp(config.getProperty("bd.ccldb.sp.cbiosi.validar.cuenta"));
		this.bdCcldbSpValidarCorreo = ClaroUtil.convertProp(config.getProperty("bd.ccldb.sp.cbiosi.validar.correo"));
		
		this.plataforma = ClaroUtil.convertProp(config.getProperty("valor.plataforma"));
		this.restringido = ClaroUtil.convertProp(config.getProperty("valor.restringido"));
		this.informativo = ClaroUtil.convertProp(config.getProperty("valor.informativo"));
	    this.codigoParametro = ClaroUtil.convertProp(config.getProperty("valor.parametro"));
	    this.codigoEstado = ClaroUtil.convertProp(config.getProperty("valor.estado"));
	}
}