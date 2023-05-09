package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.example.Service;
import org.example.pojo.Constants;
import org.example.pojo.Course;
import org.example.pojo.CyberSecurityDegreeeSource;
import org.example.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.example.util.TransUtil;

import java.io.*;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    TransUtil transUtil;
    String filedata = null;

    CyberSecurityDegreeeSource cyberdegree = null;

    MultipartFile downloadfile = null;

    String plan = null;


    private final Service myService;

    @Autowired
    public WebController(Service myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public ModelAndView getBoardPage() throws JsonProcessingException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/ProgramsPage")
    public ModelAndView getProgramsPage(Model model) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProgramsPage.html");
        return modelAndView;
    }

    @GetMapping("/audit")
    public ModelAndView getCyberSecurity(Model model) throws JsonProcessingException {
        Random random = new Random();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("audit.html");
        CyberSecurityDegreeeSource degree = this.cyberdegree;
        modelAndView.addObject("sdname", degree.getSdname());
        modelAndView.addObject("sdnumber", degree.getSdnumber());
        modelAndView.addObject("master", "Master");
        modelAndView.addObject("major", this.plan);
        List<Course> list= new ArrayList<>();
        list.addAll(degree.getCorecourses());
        list.addAll(degree.getCourses());
        System.out.println("-----------COre----------------------");
        List<Double> ret1 = avggpa(list);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Double d1 = ret1.get(0)/(3 * ret1.get(1));
//        if(d1 > 4)
//            d1 =  3 + random.nextDouble();
        modelAndView.addObject("cgpa",df.format(d1) );
        String clist = getCouresforSem(list);
        String ooscc = outstandinglist(list);
        modelAndView.addObject("ooscc", ooscc);

        modelAndView.addObject("ccscc", clist);


        System.out.println("-----ELECATIVE---------");
        list= new ArrayList<>();
        list.addAll(degree.getTwocourses());
        list.addAll(degree.getAppcourses());
        List<Double> ret2 = avggpa(list);
        Double d2 = ret2.get(0)/(3 * ret2.get(1));
//        if(d2 > 4)
//            d2 =  3 + random.nextDouble();
        modelAndView.addObject("egpa", df.format(d2));
        clist = getCouresforSem(list);
        String oesec = outstandinglist(list);
        modelAndView.addObject("oesec", oesec);
        modelAndView.addObject("cesec", clist);
        getCouresforSem(list);
        System.out.println("----------------");

        Double d3 = (d1 +d2 ) /2;
//        if(d3 > 4)
//            d3 =  3 + random.nextDouble();
        modelAndView.addObject("ggpa", df.format(d3));

        List<String> list1= new ArrayList<>();
        list1.addAll(getc(degree.getCourses()));
        list1.addAll(getc(degree.getCorecourses()));


        modelAndView.addObject("scc", String.join(",",list1));
        list1= new ArrayList<>();
        list1.addAll(getc(degree.getTwocourses()));
        list1.addAll(getc(degree.getAppcourses()));
        modelAndView.addObject("sec", String.join(",",list1));

        modelAndView.addObject("sec", String.join(",",list1));

        modelAndView.addObject("sec", String.join(",",list1));
        System.out.println("------------CORE---------------------");
        double d4 = 0;
//        if(d1 > 0 && ret1.size() == 3) {
//           double cga =3.19 * ( 3*ret1.get(2) + 3 * ret1.get(1));
//            System.out.println("cga core "+cga+" ret2.get(2) "+ret1.get(2)+" ret2.get(1)"+ret1.get(1));
//           double diffcga = d1 * (3*ret1.get(2));
//            System.out.println("ocgpa core diff "+diffcga);
//           d4 = (cga-diffcga)/(3 * ret1.get(1));
//            System.out.println("ocgpa core d5 "+d4);
//
//        }
//        if(d4 > 4)
//            d4 =  3 + random.nextDouble();

        d4 = getOutGPA(ret1.get(0),d1,ret1.get(1),3.19);

        System.out.println("------------ELECTIVE---------------------");
        modelAndView.addObject("ocgpa", df.format(d4));
        double d5 = 0;
//        if(d2 > 0 && ret2.size() == 3) {
//            double cga =3.0 * ( 3*ret2.get(2) + 3 * ret2.get(1));
//            System.out.println("ocgpa "+cga+" ret2.get(2) "+ret2.get(2)+" ret2.get(1)"+ret2.get(1));
//            double diffcga = d2 * (3*ret2.get(2));
//            System.out.println("ocgpa diff "+diffcga);
//            d5 = (cga-diffcga)/(3 * ret2.get(1));
//            System.out.println("ocgpa d5 "+d5);
//
//        }
//        if(d5 > 4)
//            d5 =  3 + random.nextDouble();

        d5 = getOutGPA(ret2.get(0),d2,ret2.get(1),3.0);

        modelAndView.addObject("oegpa", df.format(d5));
        double d6 = 0;
//        if(d4 > 0 && d5 >0){
//            d6 = (d4 +d5)/2;
//        }
//        if(d6 > 4)
//            d6 =  3 + random.nextDouble();

        double totalpoints = ret2.get(0) + ret1.get(0);
        double numoflcass  = ret2.get(1) + ret1.get(1);

        d6 =  getOutGPA(totalpoints,d3,numoflcass,3.0);

        modelAndView.addObject("oggpa", df.format(d6));

        modelAndView.addObject("plan", this.plan);


        list1= new ArrayList<>();
        list1.addAll(getc(degree.getPrecourses()));
        modelAndView.addObject("lcp", String.join(",",list1));

        return modelAndView;
    }

    public Double getOutGPA(Double points,Double gpa,Double numofclass,Double overall){
       Double ret = 0.0;

       Double numofclass1 = (3 * numofclass);
       Double totalup = (points) + ((overall - gpa) * (3 * numofclass1));
       ret = totalup / numofclass1;

        return ret;
    }



    public String  outstandinglist(List<Course> courses){

        System.out.println("---------------------------------");
        List<String> ret =  new ArrayList<>();
        String gpa = null;
        String reg = "\\d+\\.\\d+";
        String reg1 = "\\d+";
        Double d = 0.0;
        Double count = 0.0;
        List<String> grade =  new ArrayList<>();
        grade.add("W");
        grade.add("P");
        grade.add("CR");
        Double count_core = 0.0;

        for(Course point : courses){
            count_core++;

            if(point.getGrade() != null && point.getGrade().length() > 0 &&  !grade.contains(point.getGrade().trim())) {

                if (point.getPoints() != null && point.getGrade() != null) {
                    //System.out.println("points :" + point.getPoints() + " num: " + point.getNumber() + " grade :" + point.getGrade());
                    if (point.getPoints().contains(".") && point.getPoints().matches(reg)) {

                        String number = point.getNumber().split("\\s+")[1];
                        number = String.valueOf(number.charAt(1));
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        d = d + Double.parseDouble(point.getPoints());
                        if(Double.parseDouble(point.getPoints()) <= 0.0)
                            ret.add(point.getNumber());
                    }
                    if (point.getPoints().matches(reg1)) {
                        String number = point.getNumber().split("\\s+")[1];
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        number = String.valueOf(number.charAt(1));
                        d = d + Double.parseDouble(point.getPoints());
                        if(Double.parseDouble(point.getPoints()) <= 0.0)
                            ret.add(point.getNumber());
                    }
                }
            }
        }

        return String.join(",",ret);
    }

    public List<Double>  avggpa(List<Course> courses){

        System.out.println("---------------------------------");
        List<Double> ret =  new ArrayList<>();
        String gpa = null;
        String reg = "\\d+\\.\\d+";
        String reg1 = "\\d+";
        Double d = 0.0;
        Double count = 0.0;
        List<String> grade =  new ArrayList<>();
        grade.add("W");
        grade.add("P");
        grade.add("CR");
        Double count_core = 0.0;

        for(Course point : courses){
            count_core++;

            if(point.getGrade() != null && point.getGrade().length() > 0 &&  !grade.contains(point.getGrade().trim())) {

                if (point.getPoints() != null && point.getGrade() != null) {
                    //System.out.println("points :" + point.getPoints() + " num: " + point.getNumber() + " grade :" + point.getGrade());
                    if (point.getPoints().contains(".") && point.getPoints().matches(reg)) {

                        String number = point.getNumber().split("\\s+")[1];
                        number = String.valueOf(number.charAt(1));
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        d = d + Double.parseDouble(point.getPoints());
                        if(Double.parseDouble(point.getPoints()) > 0.0)
                            count++;
                    }
                    if (point.getPoints().matches(reg1)) {
                        String number = point.getNumber().split("\\s+")[1];
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        number = String.valueOf(number.charAt(1));
                        d = d + Double.parseDouble(point.getPoints());
                        if(Double.parseDouble(point.getPoints()) > 0.0)
                            count++;
                    }
                }
            }
        }


        ret.add(d);
        ret.add(count);
        ret.add(count_core);
        System.out.println("count of diff length "+count+" count core "+count_core+" avg core "+d);
        return ret;
    }

    public String getCouresforSem(List<Course> course){

        Set<String> list =  new HashSet<>();
        String reg = "\\d+\\.\\d+";
        String reg1 = "\\d+";
        Double d = 0.0;
        Double count = 0.0;
        List<String> grade =  new ArrayList<>();
        grade.add("W");
        grade.add("P");
        grade.add("CR");
        for(Course point : course){


            if(point.getGrade() != null && point.getGrade().length() > 0 &&  !grade.contains(point.getGrade().trim())) {

                if (point.getPoints() != null && point.getGrade() != null) {
                    //System.out.println("points :" + point.getPoints() + " num: " + point.getNumber() + " grade :" + point.getGrade());
                    if (point.getPoints().contains(".") && point.getPoints().matches(reg)) {

                        String number = point.getNumber().split("\\s+")[1];
                        number = String.valueOf(number.charAt(1));
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        d = d + Double.parseDouble(point.getPoints());
                        if(point.getUtdsem() != null  && point.getUtdsem().length() > 3)
                                    list.add(point.getNumber());
                    }
                    if (point.getPoints().matches(reg1)) {
                        String number = point.getNumber().split("\\s+")[1];
                        number = String.valueOf(number.charAt(1));
                        System.out.println("number to be consider "+number+" course number :"+point.getNumber());
                        d = d + Double.parseDouble(point.getPoints());
                        if( point.getUtdsem() != null  && point.getUtdsem().length() > 3)
                            list.add(point.getNumber());
                    }
                }
            }
        }
        return String.join(",",list);
    }

    public String getCouresforOut(List<Course> course){
        String reg = "\\d+\\.\\d+";
        String reg1 = "\\d+";
        List<String> grade =  new ArrayList<>();
        grade.add("W");
        grade.add("P");
        grade.add("CR");
        List<String> list =  new ArrayList<>();
        for(Course point : course){
            if(point.getGrade() != null && point.getGrade().length() > 0 &&  !grade.contains(point.getGrade().trim())) {
                if (point.getPoints() != null && point.getGrade().length() > 0) {
                    list.add(point.getNumber());
                }
            }
        }
        return String.join(",",list);
    }

    public List<String> getc(List<Course> courses){
        List<String> list = new ArrayList<>();
        for(Course point : courses){
            if(point.getNumber() != null && point.getNumber().length() > 3){
                list.add(point.getNumber());
            }
        }
        return list;
    }


    @GetMapping("/download-pdf")
    @ResponseBody
    public ResponseEntity<Resource> downloadPdf(HttpServletResponse response) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "trans.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        InputStream fileInputStream = myService.readLinesFromFileInResourceFolderPDF("sample.pdf");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(fileInputStream));

    }

    @PostMapping("/upload")
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileContent = "";
        List<String> linesList = new ArrayList<>();
        boolean condition = true;
        if(!file.isEmpty()) {
            try {
                InputStream inputStream = file.getInputStream();
                PDDocument document = PDDocument.load(inputStream);
                this.downloadfile = file;

                // Create PDF text stripper
                PDFTextStripper stripper = new PDFTextStripper();

                // Extract text from PDF document
                String text = stripper.getText(document);

                // Split text into lines
                String[] lines = text.split("\\r?\\n");

                // Create list to store lines

                // Add lines to list
                for (String line : lines) {
                    linesList.add(line);
                }

                // Close PDF document
                document.close();
                myService.writeToFileInResourceFolderPDF("sample.pdf",file.getInputStream());

                this.filedata = fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        CyberSecurityDegreeeSource degree = null;
        if(linesList.size() > 10) {

             String p = readPlanDetails();
             this.plan = p;
             List<String> coursesList = getCourseOnPlan(p);
             CyberSecurityDegreeeSource d1 = assignDefaultCourses(coursesList.get(0),coursesList.get(1),coursesList.get(2));

             degree = processPDF(d1, linesList);
             degree.setAuditflag(true);
            this.cyberdegree = degree;
        }
        else
        {
            degree = this.cyberdegree;
        }

        modelAndView.addObject("courses", degree.getCourses());
        modelAndView.addObject("corecourses", degree.getCorecourses());
        modelAndView.addObject("twocourses", degree.getTwocourses());
        modelAndView.addObject("appcourses", degree.getAppcourses());
        modelAndView.addObject("othercourses", degree.getOthercourses());
        modelAndView.addObject("precourses", degree.getPrecourses());

        modelAndView.addObject("sdname", degree.getSdname());
        modelAndView.addObject("sdnumber", degree.getSdnumber());
        modelAndView.addObject("sdprogram", degree.getSdprogram());
        modelAndView.addObject("sdgrad", degree.getSdgrad());
        modelAndView.addObject("plan", this.plan);
        modelAndView.addObject("condition", condition);
        modelAndView.addObject("enabled", true);

        modelAndView.setViewName("course.html");
        // Return the name of the Thymeleaf template that should be used to render the page
        return modelAndView;

    }

    @GetMapping("/uploaddata")
    public ModelAndView uploadForm(Model model) {
        model.addAttribute("fileContent", "");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploaddata.html");
        return modelAndView;
    }

    public void addData(String plan){
        List<String> content = new ArrayList<>();
        content.add("plan:"+plan);

        try {
            myService.writeToFileInResourceFolder("plan.txt",content);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/courses")
    public ModelAndView showCourseTable(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("cs_c1","cs_c2","cs_pre");
        degree.setPlan("Cyber Security");

        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        addData(degree.getPlan());
        return modelAndView;
    }

    @GetMapping("/datascience")
    public ModelAndView showCourseTabledatascience(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("ds_c1","ds_c2","ds_pre");
        degree.setPlan("Data Science");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }

    @GetMapping("/intsystem")
    public ModelAndView showCourseTableintsystem(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("is_c1","is_c2","is_pre");
        degree.setPlan("Intelligent Systems");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }

    @GetMapping("/intcomputing")
    public ModelAndView showCourseTableintcomputing(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("ic_c1","ic_c2","ic_pre");
        degree.setPlan("Interactive Computing");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }

    @GetMapping("/softengineering")
    public ModelAndView showCourseTablesoftengineering(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("ic_c1","ic_c2","ic_pre");
        degree.setPlan("Software Engineering");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }

    @GetMapping("/nandt")
    public ModelAndView showCourseTablenandt(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("nandt_c1","nandt_c2","nandt_pre");
        degree.setPlan("Networks and Telecommunications");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }

    @GetMapping("/tcscience")
    public ModelAndView showCourseTabletcscience(Model model) {

        CyberSecurityDegreeeSource degree = null;
        degree = assignDefaultCourses("tcs_c1","tcs_c2","tcs_pre");
        degree.setPlan("Traditional Computer Science");
        addData(degree.getPlan());
        ModelAndView modelAndView = getModelView(degree,"course.html");
        modelAndView.addObject("plan", degree.getPlan());
        this.cyberdegree = degree;
        return modelAndView;
    }



    public CyberSecurityDegreeeSource assignDefaultCourses(String c1,String c2,String pre){
        CyberSecurityDegreeeSource degree = new CyberSecurityDegreeeSource();
        Map<String,List<Course>> map = transUtil.processDefault();
        List<Course> empty = new ArrayList<>();
        List<Course> corecourses = map.getOrDefault(c1,new ArrayList<>());
        List<Course> courses = map.getOrDefault(c2,empty);
        List<Course> precourses = map.getOrDefault(pre,empty);

        empty.add(new Course(" ", " "," "," " ," "," "));
        empty.add(new Course(" "," "," "," "," "," "));


        degree.setCorecourses(corecourses);
        degree.setCourses(courses);
        degree.setPrecourses(precourses);

        degree.setAppcourses(empty);
        degree.setTwocourses(empty);
        degree.setTwocourses(empty);
        return degree;
    }


    public CyberSecurityDegreeeSource processPDF(CyberSecurityDegreeeSource degree,List<String> pdfdata) {
        CyberSecurityDegreeeSource retVal = new CyberSecurityDegreeeSource();

        List<Course> coursList = new ArrayList<>();
        List<Course> eleList = new ArrayList<>();


        String regex = "\\d+";
        String prev1 = null;
        String utdsem = null;
        String transfer = null;
        String prev2 = null;
        boolean trans = false;
        String transfercredit = "Transfer Credits";
        List<String> trnasfernum = new ArrayList<>();

        for(String line : pdfdata) {

            if(line.contains("Name:") && retVal.getSdname().isEmpty() )
                retVal.setSdname(line.split(":")[1].trim());

            if(line.contains("Student ID:") && retVal.getSdnumber().isEmpty() )
                retVal.setSdnumber(line.split(":")[1].trim());

            if(line.contains("Active in Program") && prev1 != null && prev1.contains("Program:") && retVal.getSdprogram().isEmpty())
                retVal.setSdprogram(line.split(":")[0].trim());

            if(line.contains("Print Date:") && prev1 != null && retVal.getSdgrad().isEmpty())
                retVal.setSdgrad(line.split(":")[1].trim());

            if(line.contains("Course") && line.contains("Description") && line.contains("Attempted") &&
               line.contains("Earned") && line.contains("Grade") && line.contains("Points")){

                if(prev1 != null && utdsem != null && prev1.length() <=5)
                {
                    utdsem = utdsem;
                }
                else
                  utdsem = prev1;

            }

            if(line.trim().equalsIgnoreCase(transfercredit)) {
                trans = true;
            }

            if(trans && utdsem !=null && line.split("\\s+")[0].trim().startsWith("GOVT")){
                trnasfernum.add(line.split("\\s+")[1].trim());
            }


            String values[] = line.split("\\s+");
            if( (values[0].trim().startsWith("CS") || values[0].trim().startsWith("SE") )
                && values[1].trim().matches(regex)) {

                int num = Integer.parseInt(values[1].trim());
                if(num < 5000)
                    continue;

                Course c = new Course();
                c.setNumber(values[0].trim()+" "+values[1].trim());
                c.setPoints(values[values.length-1]);
                c.setGrade(values[values.length-2]);
                String name = "";
                for(int i =2;i<values.length-3;i++)
                {
                    if(values[i].matches("\\d+\\.\\d+"))
                        break;
                    name = name+" "+values[i];
                }
                c.setTitle(name);
                c.setTransfer("No");
                c.setUtdsem(utdsem);
                coursList.add(c);
            }
            if(courseNames().contains(values[0].trim())) {
                int num = Integer.parseInt(values[1].trim());
                if(num < 5000)
                    continue;

                Course c = new Course();
                c.setNumber(values[0].trim()+" "+values[1].trim());
                c.setPoints(values[values.length-1]);
                c.setGrade(values[values.length-2]);
                String name = "";
                for(int i =2;i<values.length-3;i++)
                {
                    if(values[i].matches("\\d+\\.\\d+"))
                        break;
                    name = name+" "+values[i];
                }
                c.setTitle(name);
                c.setTransfer("No");
                c.setUtdsem(utdsem);
                eleList.add(c);
            }



            prev2 = prev1;
            prev1 = line.trim();



        }

        Map<String,Course> mapCore = new HashMap<>();
        Map<String,Course> mapCour = new HashMap<>();
        Map<String,Course> mapPre = new HashMap<>();

        List<Course> corecources = new ArrayList<>();

        List<Course> courses = new ArrayList<>();

        List<Course> twocourses = new ArrayList<>();

        List<Course> appcourses = new ArrayList<>();

        List<Course> othercourses = new ArrayList<>();

        List<Course> precourses = new ArrayList<>();

        boolean checkflag = false;

        for(Course cc : coursList) {
            checkflag = false;
            if(trnasfernum.size() > 1 && trnasfernum.contains(cc.getNumber().split("\\s+")[1])){
                cc.setTransfer("Yes");
            }

            for (Course coreList : degree.getCorecourses()) {
                String num = coreList.getNumber().split("\\s+")[1];
                if (num.equalsIgnoreCase(cc.getNumber().split("\\s+")[1])){
                    mapCore.put(cc.getNumber().trim(),cc);
                    checkflag = true;

//                    Course c = coreList;
//                    System.out.println("Corecourse "+cc.getNumber()+" "+cc.getTitle()+" "+cc.getGrade());
//                    List<Course> b = corecources;
//                    corecources.clear();
//                    for(Course p : b)
//                    {
//                        if(p.getNumber().split("\\s+")[1].equalsIgnoreCase(num)){
//                            continue;
//                        }
//                        else
//                            corecources.add(p);
//                    }
//                    corecources.add(cc);
                }
            }

            if(!degree.getCourses().isEmpty() && degree.getCourses().size() > 1) {
                for (Course coreList : degree.getCourses()) {
                    if(coreList.getNumber() != null && coreList.getNumber().length() > 3) {

                        String num = coreList.getNumber().split("\\s+")[1];
                        if (num.equalsIgnoreCase(cc.getNumber().split("\\s+")[1])) {
                            System.out.println("courses "+cc.getNumber()+" "+cc.getTitle()+" "+cc.getGrade());
                            List<Course> b = courses;
                            mapCour.put(cc.getNumber().trim(),cc);
                            checkflag = true;
//                            courses.clear();
//                            for (Course p : b) {
//                                if (p.getNumber().split("\\s+")[1].equalsIgnoreCase(num)) {
//                                    continue;
//                                } else
//                                    courses.add(p);
//                            }
//                            courses.add(cc);
                        }
                    }
                }
            }

            for (Course coreList : degree.getPrecourses()) {
                String num = coreList.getNumber().split("\\s+")[1];
                if (coreList.getNumber().split("\\s+")[1].equalsIgnoreCase(cc.getNumber().split("\\s+")[1])){
                    System.out.println("pre "+cc.getNumber()+" "+cc.getTitle()+" "+cc.getGrade());
                    mapPre.put(cc.getNumber().trim(),cc);
                    checkflag = true;
//                    List<Course> b = precourses;
//                    precourses.clear();
//                    for(Course p : b)
//                    {
//                        if(p.getNumber().split("\\s+")[1].equalsIgnoreCase(num)){
//                            continue;
//                        }
//                        else
//                            precourses.add(p);
//                    }
//                    precourses.add(cc);
                }
            }

            if(!checkflag && twocourses.size() != 2) {
                checkflag = true;
                twocourses.add(cc);
            }

            if(!checkflag && twocourses.size() == 2 && appcourses.size() < 3 ) {
                checkflag = true;
                appcourses.add(cc);
            }

            if(!checkflag && twocourses.size() == 2 && appcourses.size() == 3) {
                checkflag = true;
                boolean flag = false;
               for(Course s : appcourses)
               {
                   if(s.getTitle().equalsIgnoreCase(cc.getTitle())){
                       flag = true;
                   }

               }
               if(!flag)
                  othercourses.add(cc);
            }

        }

        corecources.addAll(mapCore.values());
        courses.addAll(mapCour.values());
        precourses.addAll(mapPre.values());

        corecources.addAll(notEqualCources(corecources,degree.getCorecourses()));
        courses.addAll(notEqualCources(courses,degree.getCourses()));
        precourses.addAll(notEqualCources(precourses,degree.getPrecourses()));

        for(Course cc : eleList) {

            if (trnasfernum.size() > 1 && trnasfernum.contains(cc.getNumber().split("\\s+")[1])) {
                cc.setTransfer("Yes");
            }
            othercourses.add(cc);
        }


        retVal.setTwocourses(twocourses);
        retVal.setPrecourses(precourses);
        retVal.setAppcourses(appcourses);
        retVal.setCourses(courses);
        retVal.setCorecourses(corecources);
        retVal.setOthercourses(othercourses);

        return retVal;
    }


    public List<Course> notEqualCources(List<Course> mainc , List<Course> degreec) {
        List<Course> ret = new ArrayList<>();
        for(Course cc : degreec) {
            if(cc.getNumber()!=null && cc.getNumber().length() > 3){
            String num2 = cc.getNumber().split("\\s+")[1];
            boolean flag = false;
            for (Course coreList : mainc) {
                String num1 = coreList.getNumber().split("\\s+")[1];

                if (num2.equalsIgnoreCase(num1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ret.add(cc);
            }
        }
        }
        return ret;
    }

    public List<String> courseNames(){
        List<String> names = new ArrayList<>();
        names.add("ECS");
        names.add("HIST");
        names.add("MATH");
        names.add("MUSI");
        names.add("UNIV");
        names.add("EPCS");
        names.add("GOVT");
        names.add("HONS");
        names.add("PSY");
        names.add("PHYS");
        return names;
    }

    public ModelAndView getModelView(CyberSecurityDegreeeSource degree,String htmlname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", degree.getCourses());
        modelAndView.addObject("corecourses", degree.getCorecourses());
        modelAndView.addObject("twocourses", degree.getTwocourses());
        modelAndView.addObject("appcourses", degree.getAppcourses());
        modelAndView.addObject("othercourses", degree.getOthercourses());
        modelAndView.addObject("precourses", degree.getPrecourses());

        modelAndView.addObject("sdname", degree.getSdname());
        modelAndView.addObject("sdnumber", degree.getSdnumber());
        modelAndView.addObject("sdprogram", degree.getSdprogram());
        modelAndView.addObject("sdgrad", degree.getSdgrad());
        modelAndView.addObject("enabled",degree.isAuditflag());
        modelAndView.setViewName(htmlname);
        // Return the name of the Thymeleaf template that should be used to render the page
        return modelAndView;
    }


    @GetMapping("/getData")
    public String showForm(Model model) {
        model.addAttribute("data", new Data());
        return "getData";
    }

    @PostMapping("/getData")
    public ModelAndView getData(@ModelAttribute Data data) {

        CyberSecurityDegreeeSource degree = null;
        if(this.cyberdegree == null) {

            String p = readPlanDetails();
            this.plan = p;
            List<String> coursesList = getCourseOnPlan(p);
            degree = assignDefaultCourses(coursesList.get(0),coursesList.get(1),coursesList.get(2));


        }
        else {

            Map<String,List<Course>> map = addeditdata(data.getName());
            degree = addDetialstodegree(this.cyberdegree,map);
        }
        // Return the name of the Thymeleaf template that should be used to render the page
        this.cyberdegree = degree;
        return getModelView(degree,"course.html");
    }

    @GetMapping("/getUpdate")
    public String showFormupdate(Model model) {
        model.addAttribute("data", new Data());
        return "getData";
    }

    @PostMapping("/getUpdate")
    public ModelAndView getDataupdate(@ModelAttribute Data data) {

        CyberSecurityDegreeeSource degree = null;
        if(this.cyberdegree == null) {
            String p = readPlanDetails();
            this.plan = p;
            List<String> coursesList = getCourseOnPlan(p);
            degree = assignDefaultCourses(coursesList.get(0),coursesList.get(1),coursesList.get(2));


        }
        else {
            degree = this.cyberdegree;

            if(data.getName() != null){
                Map<String,List<Course>> map = addeditdata(data.getName());
                if(map.size() > 0){
                    degree.setCorecourses(updatedata(degree.getCorecourses(),map.getOrDefault("c1",new ArrayList<>())));
                    degree.setCourses(updatedata(degree.getCourses(),map.getOrDefault("c2",new ArrayList<>())));
                    degree.setOthercourses(updatedata(degree.getOthercourses(),map.getOrDefault("c5",new ArrayList<>())));
                    degree.setAppcourses(updatedata(degree.getAppcourses(),map.getOrDefault("c4",new ArrayList<>())));
                    degree.setTwocourses(updatedata(degree.getTwocourses(),map.getOrDefault("c3",new ArrayList<>())));
                    degree.setPrecourses(updatedata(degree.getPrecourses(),map.getOrDefault("c6",new ArrayList<>())));
                }
            }

        }
        this.cyberdegree = degree;
        return  getModelView(degree,"course.html");
    }

    private Map<String,List<Course>> addeditdata(String name) {
        Map<String,List<Course>> map = new HashMap<>();
        if(name.contains(",") && name.contains("-")) {
            String values[] = name.split("#");

            for (int i = 0; i < values.length; i++) {
                String details[] = values[i].split("-");
                String cname = details[0];
                if (details[1] != null) {
                    String course[] = details[1].split(",");
                    Course cc = new Course();
                    if (course.length == 6) {
                        cc.setTitle(course[0]);
                        cc.setNumber(course[1]);
                        cc.setUtdsem(course[2]);
                        cc.setTransfer(course[3]);
                        cc.setGrade(course[4]);
                        cc.setPoints(course[5]);
                    }
                     List<Course> list = map.getOrDefault(cname,new ArrayList<>());
                     list.add(cc);
                     map.put(cname,list);

                }
            }
        }
        return map;
    }

    public CyberSecurityDegreeeSource addDetialstodegree(CyberSecurityDegreeeSource degree,Map<String,List<Course>> map) {



        CyberSecurityDegreeeSource addDegree = degree;
        for(String name : map.keySet()) {

            if(name.equalsIgnoreCase("c1")) {
                List<Course> list =degree.getCorecourses();
                list.addAll(map.get("c1"));
                addDegree.setCorecourses(list);
            }
            if(name.equalsIgnoreCase("c2")) {
                List<Course> list =degree.getCourses();
                list.addAll(map.get("c2"));
                addDegree.setCourses(list);
            }
            if(name.equalsIgnoreCase("c3")) {
                List<Course> list =degree.getTwocourses();
                list.addAll(map.get("c3"));
                addDegree.setTwocourses(list);
            }
            if(name.equalsIgnoreCase("c4")) {
                List<Course> list =degree.getAppcourses();
                list.addAll(map.get("c4"));
                addDegree.setAppcourses(list);
            }
            if(name.equalsIgnoreCase("c5")) {
                List<Course> list =degree.getOthercourses();
                list.addAll(map.get("c5"));
                addDegree.setOthercourses(list);
            }
            if(name.equalsIgnoreCase("c6")) {
                List<Course> list =degree.getPrecourses();
                list.addAll(map.get("c6"));
                addDegree.setPrecourses(list);
            }
        }

        return addDegree;
    }


    private List<Course> updatedata(List<Course> other , List<Course> updateList) {

    List<Course> list = new ArrayList<>();
    List<Course> b = new ArrayList<>();
    for(Course cc : other) {
        Course ss = null;
        boolean add = false;
        boolean update = false;
        Course aa = null;
        for (Course coreList : updateList) {
            String num = coreList.getNumber().split("\\s+")[1];
            if (num.equalsIgnoreCase(cc.getNumber().split("\\s+")[1])) {
               ss = coreList;

               update = true;
            }
        }

            if(update){
                b.add(ss);
            }else
               b.add(cc);


    }

        return b;
    }


    @GetMapping("/getDelete")
    public String showFormDelete(Model model) {
        model.addAttribute("data", new Data());
        return "getData";
    }

    @PostMapping("/getDelete")
    public ModelAndView getDataDelete(@ModelAttribute Data data) {

        CyberSecurityDegreeeSource degree = null;
        if(this.cyberdegree == null) {
            String p = readPlanDetails();
            this.plan = p;
            List<String> coursesList = getCourseOnPlan(p);
            degree = assignDefaultCourses(coursesList.get(0),coursesList.get(1),coursesList.get(2));


        }
        else {
            degree = this.cyberdegree;
            List<String> list = null;
            if(data.getName() != null){
                list = getDeletedList(data.getName());
                if(list.size() > 0){
                    degree.setCorecourses(deleteCourses(degree.getCorecourses(),list));
                    degree.setCourses(deleteCourses(degree.getCourses(),list));
                    degree.setOthercourses(deleteCourses(degree.getOthercourses(),list));
                    degree.setAppcourses(deleteCourses(degree.getAppcourses(),list));
                    degree.setTwocourses(deleteCourses(degree.getTwocourses(),list));
                    degree.setPrecourses(deleteCourses(degree.getPrecourses(),list));
                }
            }

        }
        this.cyberdegree = degree;
        // Return the name of the Thymeleaf template that should be used to render the page
        return   getModelView(degree,"course.html");
    }

    public List<String> getDeletedList(String name) {
        List<String> names = new ArrayList<>();
        String values[] = name.split(",");
        for(int i=0;i<values.length;i++){
            String num = values[i].split("\\s+")[1];
            names.add(num);
        }
        return names;
    }

    public List<Course> deleteCourses(List<Course> courses,List<String> list) {


        List<Course> cc = new ArrayList<>();
        if(list !=null && list.size() >0) {
            for (Course c : courses) {
                String num = c.getNumber().split("\\s+")[1];

                if (list.contains(num))
                { continue;
                }
                else
                    cc.add(c);
            }
        }
        return cc;
    }

    public void readdefaultcources(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("detailscores.txt");


        String fileContent = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        System.out.println(fileContent);

    }


    public String readPlanDetails(){
        String retVal = null;
        try {
            List<String> readData = myService.readLinesFromFileInResourceFolder("plan.txt");
            for(String data : readData){
                if(data.contains("plan:")){
                    this.plan = data.split(":")[1];
                    retVal = this.plan;

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retVal;
    }

    public List<String> getCourseOnPlan(String plan){
        List<String> list =  new ArrayList<>();

        if(plan.equalsIgnoreCase(Constants.cs)){
            list.add("cs_c1");
            list.add("cs_c2");
            list.add("cs_pre");
        }

        if(plan.equalsIgnoreCase(Constants.ds)){
            list.add("ds_c1");
            list.add("ds_c2");
            list.add("ds_pre");
        }

        if(plan.equalsIgnoreCase(Constants.is)){
            list.add("is_c1");
            list.add("is_c2");
            list.add("is_pre");
        }

        if(plan.equalsIgnoreCase(Constants.ic)){
            list.add("ic_c1");
            list.add("ic_c2");
            list.add("ic_pre");
        }

        if(plan.equalsIgnoreCase(Constants.se)){
            list.add("se_c1");
            list.add("se_c2");
            list.add("se_pre");
        }

        if(plan.equalsIgnoreCase(Constants.nandt)){
            list.add("nandt_c1");
            list.add("nandt_c2");
            list.add("nandt_pre");
        }

        if(plan.equalsIgnoreCase(Constants.tcs)){
            list.add("tcs_c1");
            list.add("tcs_c2");
            list.add("tcs_pre");
        }


        return list;
    }


}
