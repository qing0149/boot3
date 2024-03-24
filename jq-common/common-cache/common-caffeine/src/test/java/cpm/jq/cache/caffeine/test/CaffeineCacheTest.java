package cpm.jq.cache.caffeine.test;

import cn.hutool.core.lang.Assert;
import com.jq.cache.caffeine.core.CacheConstants;
import cpm.jq.cache.caffeine.test.config.CaffeineCacheConfig;
import cpm.jq.cache.caffeine.test.instance.CacheAnnotationTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-05 23:24
 **/
@SpringBootTest
@ContextConfiguration(classes = CaffeineCacheConfig.class)
public class CaffeineCacheTest {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CacheAnnotationTester cacheAnnotationTester;

    /**
     * 简单测试CaheManager的功能额以及Cache的对象功能
     * 简单通过
     */
    @Test
    public void test1() {
        Cache cache = cacheManager.getCache(CacheConstants.R_PAN_CACHE_NAME);
        assert cache != null;
        cache.put("name", "value");
        String value = cache.get("name", String.class);
        Assert.isTrue("value".equals(value));
    }

    @Test
    public void caffeineCacheAnnotationTest() {
        for (int i = 0; i < 2; i++) {
            System.out.println("方法调用");
            cacheAnnotationTester.testCacheable("imooc");
        }
    }


}
