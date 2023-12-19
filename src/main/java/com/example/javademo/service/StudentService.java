package com.example.javademo.service;

import com.example.javademo.bean.StudentBean;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentBean getStudentInfoByName(String name);
    PageInfo<StudentBean> getStudents(Integer pageNum, Integer pageSize);
    Integer addStudent(StudentBean params);
    Integer delStudent(Integer id);
}
