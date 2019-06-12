package com.hundsun.auth.util;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体类工具类
 */
public class EntityUtil {

	private static Logger log = LoggerFactory.getLogger(EntityUtil.class);

	/**
	 * 初始化实体类默认值,若有值则不给默认值
	 * 
	 * @param obj
	 */
	public static void format(Object obj) {
		Class<?> classType = obj.getClass();
		try {
			// 使用內省中方法获得BeanInfo对象;
			BeanInfo beanInfo = Introspector.getBeanInfo(classType);
			// 获得BeanInfo中的属性描述器数组;
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if (null != propertyDescriptors && propertyDescriptors.length != 0) {
				for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
					// 获得set方法;
					Method method = propertyDescriptor.getWriteMethod();
					String name = propertyDescriptor.getName();
					Object value = BeanUtils.getProperty(obj, name);
					Class<?> propertyType = propertyDescriptor.getPropertyType();
					if (propertyType == byte.class || propertyType == Byte.class) {
						if (null == value) {
							method.invoke(obj, 0);
						}
					} else if (propertyType == boolean.class || propertyType == Boolean.class) {
						if (null == value) {
							method.invoke(obj, false);
						}
					} else if (propertyType == char.class || propertyType == Character.class) {
						if (null == value) {
							method.invoke(obj, ' ');
						}
					} else if (propertyType == short.class || propertyType == Short.class) {
						if (null == value) {
							method.invoke(obj, 0);
						}
					} else if (propertyType == int.class || propertyType == Integer.class) {
						if (null == value) {
							method.invoke(obj, 0);
						}
					} else if (propertyType == long.class || propertyType == Long.class) {
						if (null == value) {
							method.invoke(obj, 0L);
						}
					} else if (propertyType == float.class || propertyType == Float.class) {
						if (null == value) {
							method.invoke(obj, 0f);
						}
					} else if (propertyType == double.class || propertyType == Double.class) {
						if (null == value) {
							method.invoke(obj, 0.0);
						}
					} else if (propertyType == String.class) {
						if (null == value || StrUtil.isBlank(value.toString())) {
							method.invoke(obj, " ");
						}
					} else if (propertyType == BigDecimal.class) {
						if (null == value) {
							method.invoke(obj, BigDecimal.ZERO);
						}
					}
				}
			}
		} catch (IllegalAccessException e) {
			log.error("IllegalAccessException", e);
		} catch (IllegalArgumentException e) {
			log.error("IllegalArgumentException", e);
		} catch (InvocationTargetException e) {
			log.error("InvocationTargetException", e);
		} catch (IntrospectionException e) {
			log.error("IntrospectionException", e);
		} catch (NoSuchMethodException e) {
			log.error("NoSuchMethodException", e);
		}
	}

	public static <T> T arrayToBean(Object[] record, String[] fieldName, Class<T> type) {
		Map<String, Object> map = new HashMap<String, Object>(64);
		for (int i = 0; i < fieldName.length; i++) {
			String field = fieldName[i];
			map.put(field, record[i]);
		}
		try {
			T t = type.newInstance();
			BeanUtils.populate(t, map);
			EntityUtil.format(t);
			return t;
		} catch (IllegalAccessException e) {
			log.error("map转bean失败", e);
		} catch (InvocationTargetException e) {
			log.error("map转bean失败", e);
		} catch (InstantiationException e) {
			log.error("map转bean失败", e);
		}
		return null;
	}
	
	public static void trim(Object[] record) {
    	for (int i=0;i<record.length;i++) {
			if(record[i] instanceof String) {
				String str = String.valueOf(record[i]);
				record[i] = str.trim();
			}
		}
    }
	public static void main(String[] args) throws Exception {
		
	}
}
