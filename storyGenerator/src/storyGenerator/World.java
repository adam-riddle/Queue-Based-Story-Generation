//Story world
package storyGenerator;

import java.util.HashMap;

public class World {
	
	HashMap world;
	Time time;
	
	public World(){
		
		time = new Time();
		
		world = new HashMap<String,Object>();
		world.put("n1", 0);
		world.put("c1", true);
		world.put("c2", true);

		

		
	}//World
	
	void addWorldPiece(String key, Object value){ //world pieces are not actor objects in world
		
		world.put(key, value);
		
	}//addWorldPiece
	
	Object getWorldPiece(String object){
		
		Object value;
		
		value = world.get(object);
		
		return value;
		
	}//getWorldPiece
	
	HashMap<String,Object> getWorld(){
		
		return world;
	}
	
	void update(){ // update world
		
		time.changeState();
		
	}//update

		
	}//getWorld

//clash World
