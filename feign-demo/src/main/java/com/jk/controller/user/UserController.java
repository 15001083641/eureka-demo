package com.jk.controller.user;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jk.model.freemaker.Ma;
import com.jk.model.freemaker.UserBean;
import com.jk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //查询用户信息
    @RequestMapping(value = "queryUser")
    @ResponseBody
    public HashMap queryUser(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        List<UserBean> list = userService.queryUser();
        map.put("data",list);
        map.put("count",list.size());
        map.put("code","");
        map.put("msg","查询成功");
        return map;
    }


    /**
     * 生成二维码
     *
     * @throws WriterException
     * @throws IOException
     */
    @RequestMapping(value = "createMa")
    @ResponseBody
    public  Map createMa() throws WriterException, IOException {

        HashMap<String,Object> map = new HashMap<String,Object>();
        try {
            Integer userId =1;
            //生成6为随机数
           int myMa = (int)((Math.random()*9+1)*100000);
            //带着用户id去中间码表中查询用户是否存在
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

           // Date now = new Date();
             Ma maa  = userService.queryUserId(userId);
            if(maa==null){
                //证明用户二维码不存在，走新增
                Ma ma = new Ma();
                ma.setUserid(userId);
                ma.setNewMa(Integer.toString(myMa));
                ma.setCreateTime(new Date());

                Calendar nowTime = Calendar.getInstance();
                nowTime.add(Calendar.MINUTE, 1);
                String format = sdf.format(nowTime.getTime());
                ma.setValidTime(sdf.parse(format));

                userService.insertMa(ma);

            }else{
                //证明用户二维码存在，走修改
               // Long s = (System.currentTimeMillis() - hqtime) / (1000 * 60);
                //判断用户的二维码有效期是否过期
               long shijian = (maa.getValidTime().getTime()-maa.getCreateTime().getTime())/(1000 * 60);
               if(shijian>1){
                   System.out.println("二维码失效");
                   map.put("text","二维码失效");
               }else{
                 /*  map.put("text","")
                   System.out.println("二维码展示给前台");*/
                   String filePath = "D:\\apache-tomcat-8.0.0\\webapps\\ROOT";
                   String fileName = "zxing.png";
                   String content = "http://192.168.0.140:8763/chaMa/freeMarker.do";
                   int width = 300; // 图像宽度
                   int height = 300; // 图像高度
                   String format = "png";// 图像类型
                   Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
                   hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                   BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                           BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
                   Path path = FileSystems.getDefault().getPath(filePath, fileName);
                   MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
                   map.put("flag",true);
               }
            }

        }catch (Exception e){
            e.printStackTrace();
            map.put("flag",false);
        }
        return map;
       // System.out.println("输出成功.");
    }
}