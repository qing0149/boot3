package com.jq.data.example.mapping.package3;



import com.jq.data.collect.enums.DataTypeEnum;
import com.jq.data.collect.enums.SourceTypeEnum;
import com.jq.data.example.mapping.package3.copier.MetadataCopier;

import java.time.LocalDateTime;

/**
 * @Author Tim
 * @Description:
 * @Version 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        TDataCenterMetadata metadata = new TDataCenterMetadata();
        metadata.setDataSecurity(1);
        metadata.setCnName("cnName");
        metadata.setDescription("description");
        metadata.setDimension(Boolean.TRUE);
        metadata.setDefaultShow(Boolean.FALSE);
//        metadata.setSourceType(SourceTypeEnum.CALCULATE.getSourceValue());
        metadata.setGmtCreate(LocalDateTime.now());
        metadata.setDataType(DataTypeEnum.FLOAT.getJavaStrType());
        metadata.setBaseValue(100);

        Metadata mdmodel = MetadataCopier.INSTANCE.metadataCopier(metadata);
        System.out.println(mdmodel);
    }
}
