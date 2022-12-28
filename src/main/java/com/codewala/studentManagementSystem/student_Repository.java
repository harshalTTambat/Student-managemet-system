package com.codewala.studentManagementSystem;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.SimpleTimeZone;

@Repository  // Telling java ---> that this class contains repository(DataBase related API's)
public class student_Repository {

    // creating database by hashmap
    HashMap<Integer, Student> studentDB = new HashMap<>();

    String addStudentDB(Student student)
    {
        int key = student.id;
        studentDB.put(key, student);

        return "Student added successfully";
    }
    Student getStudentFromDB(Integer id)
    {
        // return HashMap value (Student) & status response
        return studentDB.get(id);
    }
    Student getStudentFromDB(String SearchName)
    {
        // Iterate over HashMap , check values
        for(Student s: studentDB.values())
        {
            if (s.name.equals(SearchName))
            {
                return s;
            }
        }
        // if not found
        return null;
    }
    String updateStudentFromDB(Student update)
    {
        int key = update.id;
        studentDB.put(key,update);
        return "Student info updated successfully";
    }
    String deleteStudentFromDB(Integer id)
    {
        studentDB.remove(id);
        return "Student removed done...";
    }
}
