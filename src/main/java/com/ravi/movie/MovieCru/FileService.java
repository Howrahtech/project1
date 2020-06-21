package com.ravi.movie.MovieCru;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Autowired
	private MovieJpaRepsitory movieJpaRepsitory;
	
	private final Path rootLocation = Paths.get("ProfilePictureStore");
	 public void store(MultipartFile file,Movie movie) {
	  try {
		  
		  //
		  byte[] bytes = file.getBytes();
          Path path = Paths.get("images/asset/"+ file.getOriginalFilename());
          Files.write(path, bytes);
          movie.setImgUrl(path+"");
          movieJpaRepsitory.save(movie);
	   System.out.println(file.getOriginalFilename());
	   System.out.println(rootLocation.toUri());
	 //  File file1=new File(rootLocation.toUri());
	  // movie.setImgUrl("assets/img/"+file.getOriginalFilename());
	   System.out.println("assets/img/"+file.getOriginalFilename()); 
	 //  System.out.println(file.getClass().getResource("").getFile().getAb);
	   Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
	  } catch (Exception e) {
	   throw new RuntimeException("FAIL!");
	  }
	 }
	
	
}



