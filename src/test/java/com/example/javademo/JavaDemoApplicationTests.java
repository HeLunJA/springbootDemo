package com.example.javademo;

import com.example.javademo.bean.StudentBean;
import com.example.javademo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaDemoApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    public void contextLoads() {
        StudentBean studentBean = studentService.getStudentInfoByName("何伦");
        System.out.println("该用户ID为：");
        System.out.println(studentBean.getId());
    }
}
