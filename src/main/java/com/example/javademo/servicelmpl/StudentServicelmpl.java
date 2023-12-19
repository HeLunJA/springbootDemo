package com.example.javademo.servicelmpl;

import com.example.javademo.bean.StudentBean;
import com.example.javademo.mapper.StudentMapper;
import com.example.javademo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServicelmpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public StudentBean getStudentInfoByName(String name) {
        return studentMapper.getInfoByName(name);
    }
    @Override
    public PageInfo<StudentBean> getStudents(Integer pageNum, Integer pageSize) {
        try {
            System.out.println(pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List<StudentBean> list = studentMapper.getStudents();
            PageInfo<StudentBean> pageInfo = new PageInfo<>(list);
            return pageInfo;
        } finally {

        }
    }

    @Override
    public Integer addStudent(StudentBean params) { return studentMapper.addStudent(params); }
    @Override
    public Integer delStudent(Integer id) { return studentMapper.delStudent(id); }
}
