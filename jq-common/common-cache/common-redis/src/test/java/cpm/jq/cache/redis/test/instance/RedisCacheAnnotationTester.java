package cpm.jq.cache.redis.test.instance;


import com.jq.cache.constants.CacheConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-05 23:19
 **/
@Component
@Slf4j
public class RedisCacheAnnotationTester {
    /**
     * 缓存穿透有两种方式
     * 1.同一时间缓存没有大量时间查
     * 2.id=-1一直都查不到，大量查不到 布隆过滤器
     *
     * @param name
     * @return
     */
    @Cacheable(cacheNames = CacheConstants.R_PAN_CACHE_NAME, key = "#name", sync = true)
    public String testCacheable(String name) {
        log.error("testCacheable方法调用");
        return new StringBuffer().append(name).toString();
    }
}
