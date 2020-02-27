package com.mycompany.myapp.Helper;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileHelper {	
	MultipartFile file1;
	MultipartFile file2;
	MultipartFile file3;

	
	public FileHelper(MultipartFile file1,MultipartFile file2,MultipartFile file3) {
		this.file1=file1;
		this.file2=file2;
		this.file3=file3;

	}
	
	
public String getFiles(int i){
		
		List<MultipartFile> fileList= new ArrayList<MultipartFile>();
		fileList.add(file1);
		fileList.add(file2);
		fileList.add(file3);
		
		List<String> list = new ArrayList<String>();
		if(!fileList.isEmpty()) {	
		String path="\\C:\\Users\\82108\\STUDYSPRING\\";
			for(MultipartFile mf:fileList) {
				if(mf.getOriginalFilename().isEmpty()) {
					list.add(null);
					continue;
				}
				
				UUID uuid=UUID.randomUUID();
				
				File saveFile = new File(path,uuid+"_"+mf.getOriginalFilename());				
				try {
					System.out.println(saveFile);
					mf.transferTo(saveFile);
					list.add("/resources/uploads/"+uuid+"_"+mf.getOriginalFilename());
					
				} catch(Exception e){
					e.printStackTrace();
				}
			}						
		}
		System.out.println(list.get(i-1));
		return list.get(i-1);
	}
}
