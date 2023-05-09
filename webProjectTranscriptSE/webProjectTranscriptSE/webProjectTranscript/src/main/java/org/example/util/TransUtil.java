package org.example.util;

import org.example.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransUtil {

    @Autowired
    private Config config;


    /**
     * This method reads the properties for Cyber Security Courses
     *
     * @return list of Cyber Security Courses
     */
    public List<Course> getCSCoreCourses(Map<String,String> coreCourse){

        List<Course> csCoreCourseList = new ArrayList<>();
        for (Map.Entry<String,String> entry : coreCourse.entrySet()){
            Course course = new Course();
            course.setNumber(entry.getKey().trim());
            course.setTitle(entry.getValue().trim());
            csCoreCourseList.add(course);
        }
        return csCoreCourseList;
    }

    public Map<String,List<Course>> processDefault(){

        Map<String,List<Course>> map = new HashMap<>();

        map.put("cs_c1",getCSCoreCourses(config.getCsCourses()));
        map.put("cs_c2",getCSCoreCourses(config.getCsCoreCourses()));
        map.put("cs_pre",getCSCoreCourses(config.getCsPreReqCourses()));

        map.put("ds_c1",getCSCoreCourses(config.getDsCourses()));
        map.put("ds_c2",getCSCoreCourses(config.getDsCoreCourses()));
        map.put("ds_pre",getCSCoreCourses(config.getDsPreReqCourses()));

        map.put("is_c1",getCSCoreCourses(config.getIsCourses()));
        map.put("is_c2",getCSCoreCourses(config.getIsCoreCourses()));
        map.put("is_pre",getCSCoreCourses(config.getIsPreReqCourses()));


        map.put("ic_c1",getCSCoreCourses(config.getIcCourses()));
        map.put("ic_c2",getCSCoreCourses(config.getIcCoreCourses()));
        map.put("ic_pre",getCSCoreCourses(config.getIcPreReqCourses()));


        map.put("nandt_c1",getCSCoreCourses(config.getNandtCourses()));
        map.put("nandt_pre",getCSCoreCourses(config.getNandtPreReqCourses()));


        map.put("tcs_c1",getCSCoreCourses(config.getTcsCourses()));
        map.put("tcs_c2",getCSCoreCourses(config.getTcsCoreCourses()));
        map.put("tcs_pre",getCSCoreCourses(config.getTcsPreReqCourses()));

        map.put("se_c1",getCSCoreCourses(config.getSECourses()));
        map.put("se_c2",getCSCoreCourses(config.getSECoreCourses()));
        map.put("se_pre",getCSCoreCourses(config.getSEPreReqCourses()));
        return map;


    }



}
