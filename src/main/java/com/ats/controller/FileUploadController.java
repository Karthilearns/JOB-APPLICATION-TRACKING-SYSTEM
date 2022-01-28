package com.ats.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@Value("${file.upload-dir}")
	String FILE_UPLOAD_DIR;
	@PostMapping("/uploads")
	public  ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		
	    File myfile = new File(FILE_UPLOAD_DIR+file);
	    myfile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(myfile);
	    fos.write(file.getBytes());
	    fos.close();
	    
	    return new ResponseEntity<>("file uploaded successfully", HttpStatus.OK);
	    
	}
	
	
   
}
