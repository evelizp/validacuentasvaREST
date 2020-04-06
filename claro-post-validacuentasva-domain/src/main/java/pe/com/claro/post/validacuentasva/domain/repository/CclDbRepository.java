package pe.com.claro.post.validacuentasva.domain.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Locale;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import oracle.jdbc.OracleCallableStatement;
import pe.com.claro.common.exception.DBException;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.property.JAXBUtilitarios;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.post.validacuentasva.canonical.bean.SpValidarCuentaBean;
import pe.com.claro.post.validacuentasva.canonical.bean.SpValidarEmailBean;

@Stateless
public class CclDbRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	private static final Logger logger = Logger.getLogger(CclDbRepository.class);
	XMLGregorianCalendar xmlGregorianCalendar;
	private String contexto = Constantes.CONTEXTO + Constantes.GUION + Constantes.ESPACIO;

	@PersistenceContext(unitName = Constantes.PERSISTENCE_CONTEXT_COBSDB)
	public void setPersistenceUnitPvu(final EntityManager em) {
		this.entityManager = em;
		logger.info(contexto + "CCLDB");
	}

	public SpValidarCuentaBean validarCuenta(SpValidarCuentaBean beanDatos, PropertiesExternos prop,
			String trazabilidad) throws DBException {

		logger.info(trazabilidad + " ====== [Inicio] En validarCuentaCorreo ====== ");

		long iniciotiempo = System.currentTimeMillis();
		final String owner = prop.dbCcldbOwner;
		String paquete = prop.bdCcldbPkgSvaCuenta;
		String procedure = prop.bdCcldbSpValidarCuenta;
		String bd = prop.dbCcldbNombre;
		logger.info(trazabilidad + Constantes.TEXTOBD + prop.dbCcldbNombre + Constantes.TEXTO_COMA
				+ Constantes.TEXTOJNDI + prop.bdCcldbJndi);
		logger.info(trazabilidad + Constantes.TEXTOOWNER + owner + Constantes.TEXTO_COMA + Constantes.TEXTOPAQUETE
				+ paquete + Constantes.TEXTO_COMA + Constantes.TEXTOPROCEDURE + procedure);

		StringBuffer storedProcedureSB = new StringBuffer();
		storedProcedureSB.append(owner);
		storedProcedureSB.append(Constantes.SEPARADORPUNTO);
		storedProcedureSB.append(paquete);
		storedProcedureSB.append(Constantes.SEPARADORPUNTO);
		storedProcedureSB.append(procedure);

		try {
			Session session = (Session) this.entityManager.unwrap(Session.class);
			String timeoutIOT = prop.dbCcldbTimeout;

			session.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {
					OracleCallableStatement cst = (OracleCallableStatement) connection.prepareCall(
							Constantes.CALL + storedProcedureSB.toString() + Constantes.COBS_DATOS_HIS_PARAMS);

					cst.setQueryTimeout(Integer.parseInt(timeoutIOT));
					logger.info(trazabilidad + Constantes.CALL + storedProcedureSB.toString()
							+ Constantes.COBS_DATOS_HIS_PARAMS);

					//cst.setString(1, String.valueOf(beanDatos.getCorreo()));
					cst.setString(1, beanDatos.getCorreo());
					logger.info(trazabilidad + Constantes.PARAMINPUT
							+ (Constantes.CORREO + Constantes.CHAR_CORCHETE_PUNTOS
									+ beanDatos.getCorreo() + Constantes.CHAR_CORCHETE_DERECHO));

					cst.registerOutParameter(2, Types.VARCHAR);
					cst.registerOutParameter(3, Types.VARCHAR);
					cst.execute();
					beanDatos.setCodigoRespuesta(cst.getObject(2).toString());
					beanDatos.setMensajeRespuesta(cst.getObject(3).toString());
					logger.info(trazabilidad + Constantes.PARAMOUTPUT + Constantes.PO_COD_RESPUESTA
							+ Constantes.CHAR_CORCHETE_IZQUIERDO
							+ (cst.getObject(2) != null ? cst.getObject(2).toString() : Constantes.TEXTOVACIO)
							+ Constantes.CHAR_CORCHETE_DERECHO);

					logger.info(trazabilidad + Constantes.PARAMOUTPUT + Constantes.PO_MENSAJE_RESPUESTA
							+ Constantes.CHAR_CORCHETE_IZQUIERDO
							+ (cst.getObject(3) != null ? cst.getObject(3).toString() : Constantes.TEXTOVACIO)
							+ Constantes.CHAR_CORCHETE_DERECHO);
				}
			});

		} catch (Exception e) {
			logger.error(Constantes.EXCEPTIONTEXT + bd, e);
			if (JAXBUtilitarios.getErrorTrace(e).toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEPTION)) {

				logger.info(trazabilidad + Constantes.TEXTOERRORTIMEOUT
						+ String.format(prop.idt1Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
				throw new DBException(prop.idt1Codigo,
						String.format(prop.idt1Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));

			} else {
				logger.info(trazabilidad + Constantes.TEXTOERRORDISPONIBILIDAD
						+ String.format(prop.idt2Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
				throw new DBException(prop.idt2Codigo,
						String.format(prop.idt2Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
			}

		} finally {
			logger.info(
					trazabilidad + Constantes.TEXTOESPACIO + Constantes.TIEMPO_TOTAL + Constantes.CHAR_CORCHETE_PUNTOS
							+ (System.currentTimeMillis() - iniciotiempo) + Constantes.MILISEGUNDOS);
			logger.info(trazabilidad + " ====== [Fin] En validarCuentaCorreo ====== ");
		}
		return beanDatos;
	}

	public SpValidarEmailBean validarCorreo(SpValidarEmailBean beanDatos, PropertiesExternos prop,
			String trazabilidad) throws DBException {

		logger.info(trazabilidad + " ====== [Inicio] En validarCorreo ====== ");

		long iniciotiempo = System.currentTimeMillis();
		final String owner = prop.dbCcldbOwner;
		String paquete = prop.bdCcldbPkgSvaCuenta;
		String procedure = prop.bdCcldbSpValidarCorreo;
		String bd = prop.dbCcldbNombre;
		logger.info(trazabilidad + Constantes.TEXTOBD + prop.dbCcldbNombre + Constantes.TEXTO_COMA
				+ Constantes.TEXTOJNDI + prop.bdCcldbJndi);
		logger.info(trazabilidad + Constantes.TEXTOOWNER + owner + Constantes.TEXTO_COMA + Constantes.TEXTOPAQUETE
				+ paquete + Constantes.TEXTO_COMA + Constantes.TEXTOPROCEDURE + procedure);

		StringBuffer storedProcedureSB = new StringBuffer();
		storedProcedureSB.append(owner);
		storedProcedureSB.append(Constantes.SEPARADORPUNTO);
		storedProcedureSB.append(paquete);
		storedProcedureSB.append(Constantes.SEPARADORPUNTO);
		storedProcedureSB.append(procedure);

		try {
			Session session = (Session) this.entityManager.unwrap(Session.class);
			String timeoutIOT = prop.dbCcldbTimeout;

			session.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {
					OracleCallableStatement cst = (OracleCallableStatement) connection.prepareCall(
							Constantes.CALL + storedProcedureSB.toString() + Constantes.CCLDB_DATOS_HIS_PARAMS);

					cst.setQueryTimeout(Integer.parseInt(timeoutIOT));
					logger.info(trazabilidad + Constantes.CALL + storedProcedureSB.toString()
							+ Constantes.CCLDB_DATOS_HIS_PARAMS);

					cst.setString(1, beanDatos.getParametro());
					logger.info(trazabilidad + Constantes.PARAMINPUT
							+ (Constantes.PI_COD_PARAMETRO + Constantes.CHAR_CORCHETE_PUNTOS
									+ beanDatos.getParametro() + Constantes.CHAR_CORCHETE_DERECHO));
					
	                   cst.setString(2, beanDatos.getEstado());
	                    logger.info(trazabilidad + Constantes.PARAMINPUT
	                            + (Constantes.PI_ESTADO + Constantes.CHAR_CORCHETE_PUNTOS
	                                    + beanDatos.getEstado() + Constantes.CHAR_CORCHETE_DERECHO));
					
					cst.registerOutParameter(3, Types.VARCHAR);
					cst.registerOutParameter(4, Types.VARCHAR);
					cst.registerOutParameter(5, Types.VARCHAR);
					cst.execute();
					
					beanDatos.setTipoConfiguracion(cst.getObject(3).toString());
					beanDatos.setCodigoRespuesta(cst.getObject(4).toString());
					beanDatos.setMensajeRespuesta(cst.getObject(5).toString());
	                logger.info(trazabilidad + Constantes.PARAMOUTPUT + Constantes.PO_VAL_PARAMETRO_DET
                           + Constantes.CHAR_CORCHETE_IZQUIERDO
                           + (cst.getObject(3) != null ? cst.getObject(3).toString() : Constantes.TEXTOVACIO)
                           + Constantes.CHAR_CORCHETE_DERECHO);
					logger.info(trazabilidad + Constantes.PARAMOUTPUT + Constantes.PO_COD_RESPUESTA
							+ Constantes.CHAR_CORCHETE_IZQUIERDO
							+ (cst.getObject(4) != null ? cst.getObject(4).toString() : Constantes.TEXTOVACIO)
							+ Constantes.CHAR_CORCHETE_DERECHO);

					logger.info(trazabilidad + Constantes.PARAMOUTPUT + Constantes.PO_MENSAJE_RESPUESTA
							+ Constantes.CHAR_CORCHETE_IZQUIERDO
							+ (cst.getObject(5) != null ? cst.getObject(5).toString() : Constantes.TEXTOVACIO)
							+ Constantes.CHAR_CORCHETE_DERECHO);
				}
			});

		} catch (Exception e) {
			logger.error(Constantes.EXCEPTIONTEXT + bd, e);
			if (JAXBUtilitarios.getErrorTrace(e).toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEPTION)) {

				logger.info(trazabilidad + Constantes.TEXTOERRORTIMEOUT
						+ String.format(prop.idt1Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
				throw new DBException(prop.idt1Codigo,
						String.format(prop.idt1Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));

			} else {
				logger.info(trazabilidad + Constantes.TEXTOERRORDISPONIBILIDAD
						+ String.format(prop.idt2Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
				throw new DBException(prop.idt2Codigo,
						String.format(prop.idt2Mensaje, storedProcedureSB.toString(), prop.bdCcldbJndi));
			}

		} finally {
			logger.info(
					trazabilidad + Constantes.TEXTOESPACIO + Constantes.TIEMPO_TOTAL + Constantes.CHAR_CORCHETE_PUNTOS
							+ (System.currentTimeMillis() - iniciotiempo) + Constantes.MILISEGUNDOS);
			logger.info(trazabilidad + " ====== [Fin] En validarCorreo ====== ");
		}
		return beanDatos;
	}	
	
	
}
