package com.codewala.studentManagementSystem;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  // telling java that this class contains API's

public class Student_controller {

    // creating database by hashmap
    HashMap <Integer, Student> studentDB = new HashMap<>();

    // Add student opration
    @PostMapping("/add_student")  //..../add_student --> this is the end point address where we want to send request
    public String addStudent(@RequestBody() Student student)
    {
        // add to StudentDB
        int key = student.id;

        studentDB.put(key, student);
        return "Done..Student added ";
    }

    // get student opration by id

    @GetMapping("/get_student_by_id")
    public Student getStudent(@RequestParam("id")Integer id)
    {
        return studentDB.get(id);  // return value in HashMap(Student)
    }


    // update student opration

    // delete student opration


}
