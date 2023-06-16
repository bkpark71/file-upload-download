package com.example.fileupload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;


@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUpload {
  //properties 파일의 값을 가져올 수 있음
  @Value("${file.dir}")
  private String fileDir;

  @GetMapping("/upload")
  public String newFile(){
    return "upload-form";
  }

  // 스프링은 MultipartFile 이라는 인터페이스로 멀티파트 파일을 매우 편리하게 지원한다.
  @PostMapping("/upload")
  public String saveFile(@RequestParam String itemName,
                         @RequestParam MultipartFile file,
                         HttpServletRequest request)
                         throws IOException {
    log.info("request = {}", request);
    log.info("itemName = {}", itemName);
    log.info("file = {}",file);

    if(!file.isEmpty()){
      String fullPath = fileDir + file.getOriginalFilename();
      log.info("파일 저장 fullPath = {}",fullPath);
      file.transferTo(new File(fullPath));
    }

    return "upload-form";
  }
}
