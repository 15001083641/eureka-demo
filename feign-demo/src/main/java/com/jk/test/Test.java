package com.jk.test;

import com.jk.model.freemaker.*;
import com.jk.service.freemaker.FreeMakerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "freeMarker")
public class Test {

    @Autowired
    private FreeMakerService freeMakerService;

    //创建模板html后缀
    @RequestMapping(value = "freeMarker")
    @ResponseBody
    public Boolean freeMarker()throws IOException, TemplateException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "展示列表");
        //去mysql数据库中查询
        Integer userid=1;

        //查询用户信息
        List<UserBean> list =  freeMakerService.queryUserInfo(userid);
        //查询教育经历
        List<EducationExperience> educationList = freeMakerService.queryEducationList(userid);
        //查询技能专长
        List<Expertise> expertiseList = freeMakerService.expertiseList(userid);
        //查询项目
        List<Project> projectList = freeMakerService.projectList(userid);
        //查询工作经历
        List<WorkExperience> workExperienceList = freeMakerService.workExperienceList(userid);
        map.put("list",list);
        map.put("educationList",educationList);
        map.put("expertiseList",expertiseList);
        map.put("projectList",projectList);
        map.put("workExperienceList",workExperienceList);

        // 找到模板文件*.ftl
        Configuration freemarker_cfg = new Configuration();
        String ftlppath = "E:\\demo\\";
        freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
        Template template = freemarker_cfg.getTemplate("test.ftl");
        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\demo\\test.html"), "utf-8"));
        //进行处理
        template.process(map, out);
        return true;
    }

    //创建模板
    @RequestMapping(value = "createWord")
    @ResponseBody
    public Boolean createWord()throws IOException, TemplateException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "展示列表");
        //去mysql数据库中查询
        Integer userid=1;

        //查询用户信息
        List<UserBean> list =  freeMakerService.queryUserInfo(userid);
        //查询教育经历
        List<EducationExperience> educationList = freeMakerService.queryEducationList(userid);
        //查询技能专长
        List<Expertise> expertiseList = freeMakerService.expertiseList(userid);
        //查询项目
        List<Project> projectList = freeMakerService.projectList(userid);
        //查询工作经历
        List<WorkExperience> workExperienceList = freeMakerService.workExperienceList(userid);
        map.put("list",list);
        map.put("educationList",educationList);
        map.put("expertiseList",expertiseList);
        map.put("projectList",projectList);
        map.put("workExperienceList",workExperienceList);

        // 找到模板文件*.ftl
        Configuration freemarker_cfg = new Configuration();
        freemarker_cfg.setDefaultEncoding("utf-8");
        String ftlppath = "E:\\demo\\";
        freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
        Template template = freemarker_cfg.getTemplate("bigbirdsun1.ftl","utf-8");
        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\demo\\bigbirdsun1.doc"), "utf-8"),10240);
        //进行处理
        template.process(map, out);
        out.close();
        return true;
    }


   /* public static void main(String[] args) throws IOException, TemplateException {
        // 制造数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "展示列表");
        //去mysql数据库中查询
       // List list =  freeMakerService.queryUserInfo();



        // 找到模板文件*.ftl
        Configuration freemarker_cfg = new Configuration();
        String ftlppath = "E:\\demo\\";
        freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
        Template template = freemarker_cfg.getTemplate("test.ftl");
        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\demo\\test.html"), "utf-8"));
        //进行处理
        template.process(map, out);
    }*/

}
