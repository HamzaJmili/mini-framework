package master.sdia.container;

import master.sdia.annotations.Inject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanContainer {

    private Map<String, Object> beans = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beans.put(name, bean);
    }

    public Object getBean(String name) {
        Object bean = beans.get(name);

        // Inject dependencies using annotations
        if (bean != null) {
            injectDependencies(bean);
        }

        return bean;
    }

    private void injectDependencies(Object bean) {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    field.setAccessible(true);
                    field.set(bean, getBean(field.getType().getSimpleName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
