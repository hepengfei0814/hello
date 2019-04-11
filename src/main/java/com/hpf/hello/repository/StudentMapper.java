package com.hpf.hello.repository;

import com.hpf.hello.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentMapper {
    @Select("Select * from Student")
    @Results({
            @Result(property = "id", column = "id",jdbcType = JdbcType.INTEGER),
            @Result(property = "name",column = "name",jdbcType = JdbcType.VARCHAR),
            @Result(property = "age",column = "age",jdbcType = JdbcType.INTEGER)
    })
    List<Student> getAll();

    void insert(Student student);
}
