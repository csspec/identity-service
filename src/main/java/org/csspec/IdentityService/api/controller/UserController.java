package org.csspec.IdentityService.api.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.csspec.IdentityService.api.repo.UserRepository;
import org.csspec.IdentityService.db.Faculty;
import org.csspec.IdentityService.db.Student;
import org.csspec.IdentityService.db.User;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/identity")
public class UserController {
    @Autowired
    UserRepository repository;

    //returns public information about all the users.
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+ new Timestamp(date.getTime())+ " ] Request to list all users.");
        return new ResponseEntity<Object>(repository.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        java.util.Date date= new java.util.Date();
        User temp = repository.findUserByUserId(userId);
        if(temp == null) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Deleted a user - " + getSpecificUser(userId));
        repository.delete(repository.findOne(userId));
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    // registers a new user.
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> storeOneUser(@RequestBody User user) {
        java.util.Date date= new java.util.Date();
        System.out.println("[ "+ new Timestamp(date.getTime()) + " ] Registered a new User : "+ user);
        repository.save(user);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    //returns information about a particular user
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getSpecificUser(@PathVariable String userId){
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Get information about userId " + userId);
        return repository.findUserByUserId(userId);
    }

    //returns list of all students.
    @RequestMapping(value = "/users/students", method = RequestMethod.GET)
    public List<User> getAllStudents() {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Request to list all students.");
        return repository.findAllStudents();
    }

    //returns list of all faculty members.
    @RequestMapping(value = "/users/faculty", method = RequestMethod.GET)
    public List<User> getAllFaculty() {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Request to list all faculty.");
        return repository.findAllFaculty();
    }

    //returns a pair key: has public information and value: has personal information about a particular faculty
    @RequestMapping(value = "/users/faculty/{userId}", method = RequestMethod.GET)
    public Pair<User, Faculty> getSpecificFaculty(@PathVariable String userId) {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Get information about a particular faculty "+userId);
        return repository.findSpecificFaculty(userId);
    }

    //returns a pair key: has public information and value: has personal information about a particular student.
    @RequestMapping(value = "/users/student/{userId}", method = RequestMethod.GET)
    public Pair<User,Student> getSpecificStudent(@PathVariable String userId) {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Get information about a particular student "+userId);
        return repository.findSpecificStudent(userId);
    }

    //returns array of userIds of all students who have registered for a course.
    @RequestMapping(value = "/users/student/courses/{courseId}", method = RequestMethod.GET)
    public String[] getStudentsOfCourse(@PathVariable String courseId) {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Request to find all students opted for "+ courseId);
        return repository.findStudentsOfCourse(courseId);
    }

    //returns the information about the teacher who teaches course of courseId to student with given userId
    @RequestMapping(value = "/users/student/{userId}/courses/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpecificTeacher(@PathVariable String userId , @PathVariable String courseId) {
        java.util.Date date= new java.util.Date();
        System.out.println(" [ "+new Timestamp(date.getTime())+" ] Request to find teacher with course "+ courseId+" and user "+userId);
        return repository.findSpecificTeacherSpecial(userId,courseId);
    }
}
