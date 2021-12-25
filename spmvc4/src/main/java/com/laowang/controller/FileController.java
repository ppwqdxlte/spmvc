package com.laowang.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/download/1")
    public ResponseEntity<byte[]> download1(HttpServletRequest request) throws IOException {
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/static/js/jquery-3.6.0.min.js");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition","attachment:filename=jquery-3.6.0.min.js");
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.OK);
    }

    /*
    * Apache Commons MultipartFile这个组件是MVC提供的，不是Spring默认的，所以必须要在springmvc配置文件里配置这个bean
    * */
    @RequestMapping("/upload/1")
    public String upload1(@RequestParam(value = "uploadedFile",required = false) MultipartFile multipartFile,
                          @RequestParam(value = "desc",required = false) String desc,HttpServletRequest request) throws IOException {
        System.out.println(desc);
        System.out.println(multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File(
                request.getServletContext().getRealPath("")+"/WEB-INF/upload/"+multipartFile.getOriginalFilename()));
        return "success";
    }

    /*
    * 多文件上传
    * */
    @RequestMapping("/upload/2")
    public String upload2(@RequestParam(value = "uploadedFile",required = false) MultipartFile[] multipartFiles,
                          @RequestParam(value = "desc",required = false) String desc,HttpServletRequest request) throws IOException {
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()){ //必须非空判断，否则容易报错
                multipartFile.transferTo(new File(
                        request.getServletContext().getRealPath("")+"/WEB-INF/upload/"+multipartFile.getOriginalFilename()));
            }
        }
        return "success";
    }

}
