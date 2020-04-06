package pe.com.claro.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class UtilList {

	public static <T, E> List<E> copyList(List<T> listFrom, Class<E> classTo)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<E> listTo = new ArrayList<E>();
		if (listFrom != null && !listFrom.isEmpty()) {
			for (T objectFrom : listFrom) {
				E objectTo = classTo.newInstance();
				BeanUtils.copyProperties(objectTo, objectFrom);
				listTo.add(objectTo);
			}
		}
		return listTo;
	}

}
