package com.jq.data.example.mapping.package2.copier;

import com.jq.data.example.mapping.package2.People;
import com.jq.data.example.mapping.package2.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-18 10:49
 **/
@Mapper
public interface StudentPeopleCopier {
    StudentPeopleCopier instance = Mappers.getMapper(StudentPeopleCopier.class);
    Student getStudent(People people);
}
