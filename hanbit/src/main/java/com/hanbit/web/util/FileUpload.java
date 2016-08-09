package com.hanbit.web.util;


import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private FileOutputStream fos;
	public String uploadFile(MultipartFile file,String path,String fileName){
		try {
			byte[] fileData = file.getBytes();
			fos = new FileOutputStream(path+"\\"+fileName);
			fos.write(fileData);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null){
				try {
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return path+fileName;
	}
}
