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
    public Student getStudentById(@RequestParam("id")Integer id)
    {
        return studentDB.get(id);  // return value in HashMap(Student)
    }

// get student by name
    @GetMapping("/get_student_by_name")
    public Student getStudentById(@RequestParam("name")String searchName)
    {
      // Itterate over HashMap , check values
        for(Student s: studentDB.values())
        {
            if (s.name.equals(searchName))
            {
                return s;
            }
        }
        // if not found
           return null;
    }

    // update student opration
    @PutMapping("/update_student")
    public String updateStudent(@RequestBody() Student upStudent)
    {
        int key = upStudent.id;
        studentDB.put(key,upStudent);

        return "update succesful";
    }


    // delete student opration
    @DeleteMapping("/delet_student")
    public String deletStudent(@RequestParam("id")Integer deletId)
    {
        studentDB.remove(deletId);
        return "student removed";
    }


}
