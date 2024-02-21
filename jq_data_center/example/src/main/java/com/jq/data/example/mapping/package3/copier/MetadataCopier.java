package com.jq.data.example.mapping.package3.copier;


import com.jq.data.collect.enums.SourceTypeEnum;
import com.jq.data.example.mapping.package3.Metadata;
import com.jq.data.example.mapping.package3.TDataCenterMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @Author Tim
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface MetadataCopier {
    MetadataCopier INSTANCE = Mappers.getMapper(MetadataCopier.class);


    //            {@Mapping(source = "sourceType", target = "sourceType", qualifiedByName = "toSourceType")}
//    @Mapping(source = "sourceType", target = "sourceType", qualifiedByName = "toSourceType")
    Metadata metadataCopier(TDataCenterMetadata metadata);

    @Named("toSourceType")
    default SourceTypeEnum toSourceType(Integer st) {
        return SourceTypeEnum.parse(st);
    }
}
