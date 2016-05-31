package storyGenerator;

import java.io.File;

public class FileFinder {
	
	String path;

	public FileFinder(String path,String name,String type){
		

		path = path+name+type;
		

	}//fileFinder
	
	public String getPath(){
		
		return path;
				
	}//getPath
	
	public int getFileCount(String path){
		File file;
		file = new File(path);
		
		int fileCount = 0;
		
		fileCount = file.listFiles().length;
		
		return fileCount;
		
	}//getFileCount
	
	public String getFile(String path, int num){
		File file;
		file = new File(path);
		
		String newFile;
		
		newFile = file.listFiles()[num].getName();
		
		path = path + newFile;
		
		return path;
		
	}//getFile
	
	public int getFolderCount(){
		
		return 0;
		
	}//getFolderCount
	
	public boolean isEmpty(){
		
		return true;
	}

	
}//class fileFinder
