package  org.csspec.IdentityService.api.controller;

import  org.csspec.IdentityService.api.repo.CourseRepository;
import  org.csspec.IdentityService.db.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/academic")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    //returns the information about a course of given courseId
    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourseByCourseId(@PathVariable String courseId) {
        return new ResponseEntity<Object>(courseRepository.findCourseByCourseId(courseId),HttpStatus.OK);
    }

    //stores into database a new course
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ResponseEntity<?> storeOneCourse(@RequestBody Course course) {
        if(course.getCourseId() == null || course.getCourseName()==null || course.getDepartmentId() ==null) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
        courseRepository.save(course);
        java.util.Date date= new java.util.Date();
        System.out.println("[ "+ new Timestamp(date.getTime())+" ] Inserted a new course into Database "+course);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    //returns the list of all courses of college.
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


}
