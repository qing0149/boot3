package test17;

public class NotNullCheckInterceptorImpl implements NotNullCheckInterceptor {
    @Override
    public void beforeGet(NotNullOrThrow annotation, Object target) throws Throwable {
        Object value = target.getClass().getField("id").get(target);
        if (value == null) {
            Class<? extends RuntimeException> exceptionClass = annotation.exception();
            RuntimeException exception = exceptionClass.getDeclaredConstructor(String.class).newInstance(annotation.message());
            throw exception;
        }
    }
}