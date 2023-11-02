package com.cycbersoft.demospringboot03.controller;


import com.cycbersoft.demospringboot03.entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<StudentEntity> studentList = new ArrayList<StudentEntity>();
    @PostMapping("")
    public ResponseEntity<?> insertParam (StudentEntity student){
        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

/*    @PostMapping("/insert-path/{student}")
    public ResponseEntity<?> insertPath (@PathVariable){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setAge(age);
        studentList.add(studentEntity);
        return new ResponseEntity<>("Insert success", HttpStatus.OK);
    }*/

    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> insertPath (@PathVariable String name, @PathVariable int age){

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(age);
        studentEntity.setName(name);
        studentList.add(studentEntity);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/body")
    public ResponseEntity<?> insertBody(@RequestBody StudentEntity student){

        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }


}
