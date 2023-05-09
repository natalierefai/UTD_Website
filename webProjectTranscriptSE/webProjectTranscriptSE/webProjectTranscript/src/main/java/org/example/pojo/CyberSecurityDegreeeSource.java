package org.example.pojo;

import java.util.ArrayList;
import java.util.List;

public class CyberSecurityDegreeeSource {



    String sdname = "";

    String sdnumber = "";

    String sdprogram = "";

    String sdgrad = "";

    List<Course> corecourses = new ArrayList<>();

    List<Course> courses = new ArrayList<>();

    List<Course> twocourses = new ArrayList<>();

    List<Course> appcourses = new ArrayList<>();

    List<Course> othercourses = new ArrayList<>();

    List<Course> precourses = new ArrayList<>();

    String plan;

    boolean auditflag = false;


    public CyberSecurityDegreeeSource(String sdname, String sdnumber, String sdprogram, String sdgrad, List<Course> corecourses, List<Course> courses, List<Course> twocourses, List<Course> appcourses, List<Course> othercourses, List<Course> precourses, String plan) {
        this.sdname = sdname;
        this.sdnumber = sdnumber;
        this.sdprogram = sdprogram;
        this.sdgrad = sdgrad;
        this.corecourses = corecourses;
        this.courses = courses;
        this.twocourses = twocourses;
        this.appcourses = appcourses;
        this.othercourses = othercourses;
        this.precourses = precourses;
        this.plan = plan;
    }

    public CyberSecurityDegreeeSource() {

    }

    public String getSdname() {
        return sdname;
    }

    public void setSdname(String sdname) {
        this.sdname = sdname;
    }

    public String getSdnumber() {
        return sdnumber;
    }

    public void setSdnumber(String sdnumber) {
        this.sdnumber = sdnumber;
    }

    public String getSdprogram() {
        return sdprogram;
    }

    public void setSdprogram(String sdprogram) {
        this.sdprogram = sdprogram;
    }

    public String getSdgrad() {
        return sdgrad;
    }

    public void setSdgrad(String sdgrad) {
        this.sdgrad = sdgrad;
    }

    public List<Course> getCorecourses() {
        return corecourses;
    }

    public void setCorecourses(List<Course> corecourses) {
        this.corecourses = corecourses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getTwocourses() {
        return twocourses;
    }

    public void setTwocourses(List<Course> twocourses) {
        this.twocourses = twocourses;
    }

    public List<Course> getAppcourses() {
        return appcourses;
    }

    public void setAppcourses(List<Course> appcourses) {
        this.appcourses = appcourses;
    }

    public List<Course> getOthercourses() {
        return othercourses;
    }

    public void setOthercourses(List<Course> othercourses) {
        this.othercourses = othercourses;
    }

    public List<Course> getPrecourses() {
        return precourses;
    }

    public void setPrecourses(List<Course> precourses) {
        this.precourses = precourses;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public boolean isAuditflag() {
        return auditflag;
    }

    public void setAuditflag(boolean auditflag) {
        this.auditflag = auditflag;
    }
}
