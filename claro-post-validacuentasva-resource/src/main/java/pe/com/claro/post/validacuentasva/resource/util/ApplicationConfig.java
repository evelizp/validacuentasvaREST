package pe.com.claro.post.validacuentasva.resource.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.ProviderExceptionMapper;
import pe.com.claro.post.validacuentasva.resource.ValidarCuentaResource;

@Singleton
@ApplicationPath(Constantes.API)
public class ApplicationConfig extends Application {

  private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

  @Override
  public Set<Class<?>> getClasses() {

    Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
    resources.add(ValidarCuentaResource.class);
    resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
    resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
    resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
    resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
    resources.add(ProviderExceptionMapper.class);

    return resources;
  }

  public Map<String, Object> getProperties() {
    String nombrePropertieExterno = Constantes.PROPERTIESEXTERNOS;
    Map<String, Object> dataProperties = new HashMap<String, Object>();
    dataProperties.putAll(readProperties(nombrePropertieExterno, false));
    return dataProperties;
  }

  private Map<String, Object> readProperties(String fileInClasspath, Boolean interno) {
    InputStream is = null;
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      if (interno) {
        is = this.getClass().getClassLoader().getResourceAsStream(fileInClasspath);
      } else {
        is = new FileInputStream(
            System.getProperty(Constantes.PROPERTIESKEY) + Constantes.NOMBRERECURSO + File.separator + fileInClasspath);
      }
      Properties properties = new Properties();
      properties.load(is);
      map.putAll(
          properties.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue())));
    } catch (Exception e) {
      log.error("No se puede leer el archivo " + fileInClasspath + e.getMessage(), e);
    }
    return map;
  }
}
