package com.jk.controller.user;


import com.itextpdf.text.pdf.BaseFont;
import com.jk.model.freemaker.*;
import com.jk.service.freemaker.FreeMakerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "chaMa")
public class ChaMaController {

    @Autowired
    private FreeMakerService freeMakerService;

    //查用户二维码信息


    /**
     * 转pdf页面
     * @return
     */
    @RequestMapping(value = "freeMarker")
   public String freeMarker() throws IOException, TemplateException {
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

        //* 创建配置 *//*
        Configuration cfg = new Configuration();
        //* 指定模板存放的路径 *//*
        cfg.setDirectoryForTemplateLoading(new File("D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\"));
        cfg.setDefaultEncoding("UTF-8");
        //* 从上面指定的模板目录中加载对应的模板文件 *//*
        Template temp = cfg.getTemplate("test.ftl");

        //* 将生成的内容写入hello .html中 *//*

        String file1 = "D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\test.html";
        File file = new File(file1);
        if (!file.exists())
            file.createNewFile();
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        temp.process(map, out);
        out.flush();

        String url = new File(file1).toURI().toURL().toString();
        String outputFile = "D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\test.pdf";
        OutputStream os = new FileOutputStream(outputFile);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        // 解决中文问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        try {
           //* simsun.ttc*//*
            fontResolver.addFont("D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
           //* fontResolver.addFont("D:\\freemarker\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
           fontResolver.addFont("D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {
            e.printStackTrace();
        }
           //* fontResolver.addFont("C:/Windows/Fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);*//*
        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("转换成功！");
        os.close();
        return "ma";
    }


  /*public String freeMarker()throws IOException, TemplateException {
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
        String ftlppath = "D:\\apache-tomcat-8.0.0\\webapps\\ROOT";
        freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
        Template template = freemarker_cfg.getTemplate("test.ftl");
        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\apache-tomcat-8.0.0\\webapps\\ROOT\\test.html"), "utf-8"));
        //进行处理
        template.process(map, out);
        return "ma";
    }*/
}
