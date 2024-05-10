package test17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NotNullCheckProxy {
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        NotNullOrThrow annotation = method.getAnnotation(NotNullOrThrow.class);
                        if (annotation != null && method.getName().startsWith("get")) {
                            NotNullCheckInterceptor interceptor = new NotNullCheckInterceptorImpl();
                            interceptor.beforeGet(annotation, target);
                        }
                        return method.invoke(target, args);
                    }
                });
    }
}