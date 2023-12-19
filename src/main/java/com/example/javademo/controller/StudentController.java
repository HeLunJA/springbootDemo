package com.example.javademo.controller;


import com.example.javademo.bean.StudentBean;
import com.example.javademo.common.ResponseResult;
import com.example.javademo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/getStudents")
    public ResponseResult getStudents(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<StudentBean> students = studentService.getStudents(pageNum, pageSize);
        return ResponseResult.success(students);
    }
    @GetMapping("/getStudentInfoByName")
    public ResponseResult getStudentInfoByName(@RequestParam String name){
        StudentBean studentBean = studentService.getStudentInfoByName(name);
        return ResponseResult.success(studentBean);
    }
    @PostMapping("/addStudent")
    public ResponseResult addStudent(@RequestBody StudentBean params) {
        studentService.addStudent(params);
        Map<String, Integer> map = new HashMap<>() {
            {
                put("studentId", params.getId());
            }
        };
        return ResponseResult.success(map);
    }
    @GetMapping("/delStudent")
    public ResponseResult delStudent(@RequestParam Integer id) {
        Integer status = studentService.delStudent(id);
        System.out.println("-------------------------------------");
        System.out.println(status);
        if(status == 1) {
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.fail("删除失败");
        }

    }
}
