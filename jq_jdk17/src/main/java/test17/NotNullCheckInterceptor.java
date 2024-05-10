package test17;

public interface NotNullCheckInterceptor {
    void beforeGet(NotNullOrThrow annotation, Object target) throws Throwable;
}