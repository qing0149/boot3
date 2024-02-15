package com.jq.data.collect;

import com.jq.data.collect.infra.repository.entity.DataCenterCalculate;
import com.jq.data.collect.infra.repository.mapper.DataCenterCalculateMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = CollectMapperMain.class)
public class AppTest {
//    @Autowired
@Resource
    DataCenterCalculateMapper dataCenterCalculateMapper;
    @Test
    public void sss(){
        List<DataCenterCalculate> dataCenterCalculates = dataCenterCalculateMapper.selectList(null);
        System.out.println(dataCenterCalculates);
    }

}
