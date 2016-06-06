package psn.lotus.thirdapi.util;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/4/14 14:49
 */
public class ApiUtils {

    public static Map<String, String> getMethodList(String clazzName) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Class clz = Class.forName(clazzName);
            RequestMapping clzMapping = (RequestMapping) clz.getAnnotation(RequestMapping.class);
            Method[] methods = clz.getDeclaredMethods();
            Method method;
            for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                    map.put(method.getName(), getApiUrl(clzMapping.value()[0], mapping.value()[0]));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> getMethodParams(String clazzName, String methodName) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class clz = Class.forName(clazzName);
            RequestMapping clzMapping = (RequestMapping) clz.getAnnotation(RequestMapping.class);
            Method[] methods = clz.getDeclaredMethods();
            Method method = null;
            for (Method mthod : methods) {
                if (mthod.getName().equals(methodName)) {
                    method = mthod;
                    break;
                }
            }
            RequestMapping mapping = method.getAnnotation(RequestMapping.class);
            String url = getApiUrl(clzMapping.value()[0], mapping.value()[0]);
            String typeName = mapping.method()[0].name();
            map.put("url", url);
            map.put("type", typeName);
            map.put("fields", getFieldList(method));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static String getApiUrl(String url, String url2) {
        url = url.startsWith("/") ? url : "/" + url;
        url = url.endsWith("/") ? url : url + "/";
        url2 = url2.startsWith("/") ? url2.substring(1) : url2;
        return url + url2;
    }

    private static Map<String, String> getFieldList(final Method method) throws ClassNotFoundException {
        Map<String, String> map = new LinkedHashMap<String, String>();
        String[] parameterNames = getParameterNames(method);
        Class[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            String name = parameterTypes[i].getName();
            if (name.startsWith("com.xkeshi")) {
                Class clz = Class.forName(parameterTypes[i].getName());
                map = getFields(clz, map);
            } else {
                map.put(parameterNames[i], parameterTypes[i].getName());
            }
        }
        if (map.containsKey("serialVersionUID")) {
            map.remove("serialVersionUID");
        }
        return map;
    }

    public static String[] getParameterNames(final Method method) {
        return new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
    }

    private static Map<String, String> getFields(Class clz, Map<String, String> map) {
        Field f[] = clz.getDeclaredFields();
        for (int j = 0; j < f.length; j++) {
            map.put(f[j].getName(), f[j].getType().getName());
        }
        if (clz.getSuperclass() != Object.class) {
            getFields(clz.getSuperclass(), map);
        }
        return map;
    }

}
