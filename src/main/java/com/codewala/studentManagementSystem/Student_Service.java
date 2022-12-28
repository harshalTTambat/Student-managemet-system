package com.codewala.studentManagementSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Telling java ---> this class contains Service layer API's
public class Student_Service {
    @Autowired
    student_Repository studentRepo;

    String addStudent(Student student)
    {
        String str = studentRepo.addStudentDB(student);
                        // adding student to database
        return str;
    }
    Student getStudentByID(Integer id)
    {
        Student st = studentRepo.getStudentFromDB(id);
        return st;
    }
    Student getStudentByName(String name)
    {
        Student st = studentRepo.getStudentFromDB(name);
        return st;
    }
    String updateStudent(Student updateStudent)
    {
        String str = studentRepo.updateStudentFromDB(updateStudent);
        return str;
    }

    String deleteStudent(Integer id)
    {
        String str = studentRepo.deleteStudentFromDB(id);
        return str;
    }
}
