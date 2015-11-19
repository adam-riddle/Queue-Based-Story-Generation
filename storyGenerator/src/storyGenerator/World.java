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

/* This is the story world class. This class is likely to be replaced by a child of parent*/

package storyGenerator;

import java.util.HashMap;

public class World {
	
	HashMap world;
	Time time;
	 //basic world constructor
	public World(){
		
		time = new Time();
		
		world = new HashMap<String,Object>();
		world.put("n1", 0);
		world.put("c1", true);
		world.put("c2", true);

		

		
	}//World
	
	//add an object to the world
	void addWorldPiece(String key, Object value){
		
		world.put(key, value);
		
	}//addWorldPiece
	
	//get an object in the world
	Object getWorldPiece(String object){
		
		Object value;
		
		value = world.get(object);
		
		return value;
		
	}//getWorldPiece
	
	//get the world
	HashMap<String,Object> getWorld(){
		
		return world;
	}
	
	//moves time in the world
	void update(){
		
		time.changeState();
		
	}//update

		
	}//getWorld

//clash World
