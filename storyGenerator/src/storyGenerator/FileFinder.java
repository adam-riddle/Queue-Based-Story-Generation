/*Copyright [2015] [Adam Riddle]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

/* This class could eventually be used to quarry text or image files*/

package storyGenerator;

import java.io.File;

public class FileFinder {
	
	String path;

	public FileFinder(String path,String name,String type){
		

		path = path+name+type;
		

	}//fileFinder
	
	// gets folder path
	public String getPath(){
		
		return path;
				
	}//getPath
	
	// gets number of files in given directory
	public int getFileCount(String path){
		File file;
		file = new File(path);
		
		int fileCount = 0;
		
		fileCount = file.listFiles().length;
		
		return fileCount;
		
	}//getFileCount
	
	//gets file from directory
	public String getFile(String path, int num){
		File file;
		file = new File(path);
		
		String newFile;
		
		newFile = file.listFiles()[num].getName();
		
		path = path + newFile;
		
		return path;
		
	}//getFile
	
	
	
}//class fileFinder
