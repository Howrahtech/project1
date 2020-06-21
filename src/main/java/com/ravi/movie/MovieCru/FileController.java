package com.ravi.movie.MovieCru;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	
	
	 @Autowired
	 FileService fileservice;
	 @CrossOrigin(origins = "http://localhost:6200") // Call  from Local Angualar
	 @PostMapping(path="/profile/uploadpicture", consumes = "application/json", produces = "application/json")
	 public ResponseEntity< String > handleFileUpload(@RequestParam("file") MultipartFile file,@RequestBody Movie movie ) {
	  String message = "";
	  try {
	   fileservice.store(file,movie);
	   File file1=new File(file.getOriginalFilename());
	   file1.getAbsolutePath();
	   message = "You successfully uploaded " + file.getOriginalFilename() + "!"+ file1.getAbsolutePath();
	   return ResponseEntity.status(HttpStatus.OK).body(message);
	  } catch (Exception e) {
	   message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
	   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	  }
	 }
	
}
