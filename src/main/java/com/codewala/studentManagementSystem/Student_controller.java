package com.codewala.studentManagementSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  // telling java that this class contains API's

public class Student_controller {
    @Autowired // provided by spring
        // @Autowired will take care of object creation Automatically at Runtime
        // call different classes via Object
    Student_Service studentService;
        // object of Student_Service class don't need to create manually
        // already created using @Autowired

    // Add student operation
    @PostMapping("/add_student")
    //..../add_student --> this is the end point address where we send request on web or postman
    public ResponseEntity<String> addStudent(@RequestBody() Student student)
    {
        String result = studentService.addStudent(student);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // get student operation by id
    @GetMapping("/get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id)
    {
        Student result = studentService.getStudentByID(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

// get student by name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name")String searchName)
    {
           Student result = studentService.getStudentByName(searchName);
            if (result == null)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(result,HttpStatus.OK);
    }
// get student by path variable
    @GetMapping("/get_student_by_path/{id}")
    public ResponseEntity<Student> getByPath(@PathVariable("id")Integer id)
    {
        Student result = studentService.getStudentByID(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    // update student operation
    @PutMapping("/update_student")
    public ResponseEntity<String> updateStudent(@RequestBody() Student upStudent)
    {
        String result = studentService.updateStudent(upStudent);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    // delete student operation
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id")Integer deleteId)
    {
        String result = studentService.deleteStudent(deleteId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
