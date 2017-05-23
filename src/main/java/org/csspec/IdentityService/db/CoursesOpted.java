package org.csspec.IdentityService.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoursesOpted {

    @JsonProperty("studentId")
    private String studentId;

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("teacherId")
    private String teacherId;

    public String getStudentId() {
        return this.studentId;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String toString() {
        return " [ teacherId : " + teacherId + ",courseId : " + courseId + ", studentId : " + studentId + " ] ";
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
