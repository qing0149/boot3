package SpringCglib;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//描述：CGLib代理工厂类
public class CGLibProxyFactory implements MethodInterceptor {
    //目标对象
    private Object target;

    // 传入目标对象
    public CGLibProxyFactory(Object target) {
        this.target = target;
    }

    //CGLib采用底层的字节码技术，在子类中采用方法拦截的技术
    // 拦截父类指定方法的调用，并顺势植入代理功能的代码
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //代理对象的功能
        System.out.println("预定场地...");
        //调用目标对象的方法
        Object returnValue = method.invoke(target, objects);
        NotNullOrThrow annotation = method.getAnnotation(NotNullOrThrow.class);
        if (ObjectUtil.isNotNull(annotation)) {
            if (ObjectUtil.isNull(returnValue)) {
                // 获取注解上的异常类和异常信息
                Class<? extends RuntimeException> exceptionClass = annotation.exception();
                String message = annotation.message();
                // 抛出异常
                throw exceptionClass.getDeclaredConstructor(String.class)
                        .newInstance(message);
            }
        }else {
            NotNullOrThrow declaredAnnotation = method.getDeclaredAnnotation(NotNullOrThrow.class);
            if (ObjectUtil.isNotNull(declaredAnnotation)) {
                if (ObjectUtil.isNull(returnValue)) {
                    // 获取注解上的异常类和异常信息
                    Class<? extends RuntimeException> exceptionClass = annotation.exception();
                    String message = annotation.message();
                    // 抛出异常
                    throw exceptionClass.getDeclaredConstructor(String.class)
                            .newInstance(message);
                }
            }
        }
        //代理对象的功能
        System.out.println("结帐走人...");
        return returnValue;
    }

    //生成代理对象
    public Object getProxyInstance() {
        //1.使用工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类（代理）对象
        return en.create();
    }
}