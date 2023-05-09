package org.example.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Config {

    @Value("#{${cs.courses.c1}}")
    private Map<String,String> csCourses;

    @Value("#{${cs.courses.c2}}")
    private Map<String,String> csCoreCourses;

    @Value("#{${cs.courses.pre}}")
    private Map<String,String> csPreReqCourses;

    @Value("#{${ds.courses.c1}}")
    private Map<String,String> dsCourses;

    @Value("#{${ds.courses.c2}}")
    private Map<String,String> dsCoreCourses;

    @Value("#{${ds.courses.pre}}")
    private Map<String,String> dsPreReqCourses;


    @Value("#{${is.courses.c1}}")
    private Map<String,String> isCourses;

    @Value("#{${is.courses.c2}}")
    private Map<String,String> isCoreCourses;

    @Value("#{${is.courses.pre}}")
    private Map<String,String> isPreReqCourses;

    @Value("#{${ic.courses.c1}}")
    private Map<String,String> icCourses;

    @Value("#{${ic.courses.c2}}")
    private Map<String,String> icCoreCourses;

    @Value("#{${ic.courses.pre}}")
    private Map<String,String> icPreReqCourses;


    @Value("#{${nandt.courses.c1}}")
    private Map<String,String> nandtCourses;


    @Value("#{${nandt.courses.pre}}")
    private Map<String,String> nandtPreReqCourses;


    @Value("#{${tcs.courses.c1}}")
    private Map<String,String> tcsCourses;

    @Value("#{${tcs.courses.c2}}")
    private Map<String,String> tcsCoreCourses;

    @Value("#{${tcs.courses.pre}}")
    private Map<String,String> tcsPreReqCourses;

    @Value("#{${se.courses.c1}}")
    private Map<String,String> seCourses;

    @Value("#{${se.courses.c2}}")
    private Map<String,String> seCoreCourses;

    @Value("#{${se.courses.pre}}")
    private Map<String,String> sePreReqCourses;




    public Map<String, String> getCsCourses() {
        return csCourses;
    }

    public Map<String, String> getCsCoreCourses() {
        return csCoreCourses;
    }

    public Map<String, String> getCsPreReqCourses() {
        return csPreReqCourses;
    }

    public Map<String, String> getDsCourses() {
        return dsCourses;
    }

    public Map<String, String> getDsCoreCourses() {
        return dsCoreCourses;
    }

    public Map<String, String> getDsPreReqCourses() {
        return dsPreReqCourses;
    }

    public Map<String, String> getIsCourses() {
        return isCourses;
    }

    public Map<String, String> getIsCoreCourses() {
        return isCoreCourses;
    }

    public Map<String, String> getIsPreReqCourses() {
        return isPreReqCourses;
    }

    public Map<String, String> getIcCourses() {
        return icCourses;
    }

    public Map<String, String> getIcCoreCourses() {
        return icCoreCourses;
    }

    public Map<String, String> getIcPreReqCourses() {
        return icPreReqCourses;
    }

    public Map<String, String> getNandtCourses() {
        return nandtCourses;
    }


    public Map<String, String> getNandtPreReqCourses() {
        return nandtPreReqCourses;
    }

    public Map<String, String> getTcsCourses() {
        return tcsCourses;
    }

    public Map<String, String> getTcsCoreCourses() {
        return tcsCoreCourses;
    }

    public Map<String, String> getTcsPreReqCourses() {
        return tcsPreReqCourses;
    }

    public Map<String, String> getSECourses() {
        return seCourses;
    }

    public Map<String, String> getSECoreCourses() {
        return seCoreCourses;
    }

    public Map<String, String> getSEPreReqCourses() {
        return sePreReqCourses;
    }
}
