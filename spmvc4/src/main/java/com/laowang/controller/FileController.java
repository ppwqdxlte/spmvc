package com.laowang.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

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

}
