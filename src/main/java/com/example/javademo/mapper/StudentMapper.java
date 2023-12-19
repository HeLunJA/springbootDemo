package com.example.javademo.mapper;

import com.example.javademo.bean.StudentBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE name=#{name}")
    StudentBean getInfoByName(@Param("name") String name);
    @Select("SELECT * FROM student")
    List<StudentBean> getStudents();
    @Insert("INSERT INTO student (name,age,nickname) VALUES (#{params.name},#{params.age},#{params.nickname})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    Integer addStudent(@Param("params") StudentBean params);

    @Delete("Delete FROM student WHERE id=#{id}")
    Integer delStudent(@Param("id") Integer id);
}
