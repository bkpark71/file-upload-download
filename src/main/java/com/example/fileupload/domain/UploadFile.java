package com.example.fileupload.domain;

import lombok.Data;

@Data
public class UploadFile {
  private String uploadFileName; // 고객이 업로드한 파일명
  private String storeFileName;  // 서버내부에서 관리하는 파일명,
                                 // 업로드파일이름이 같은 경우 중복되지 않게 하기 위함.

  public UploadFile(String uploadFileName, String storeFileName){
    this.uploadFileName = uploadFileName;
    this.storeFileName = storeFileName;
  }
}
