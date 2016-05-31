package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Rule {
	
	String name; // identity of rule
	HashMap criteria; //what the rule needs to happen
	String responce; //what the rule does
	HashMap remember;//what effect does the rule leave behind
	int pCount = 0; //number things in the world the rule needs 
	
	public Rule(){
		
		criteria = new HashMap();
		
		remember = new HashMap();
		
	}//Rule
	
	void setName(String n){
		
		name = n;
		
	}//setName
	
	String getName(){
		
		return name;
		
	}//getName
	
	void addCriteria(String key, Object value){
		
		criteria.put(key, value);
		
	}//addCriteria
	
	void addAllCriteria(HashMap hm){

		criteria = hm;
	
		
		
	}//addCriteria
	
	Object getCriteria(String key){
		
		Object value;
		
		value = criteria.get(key);
		
		return value;
		
	}//getCriteria
	
	HashMap<String,Object> getAllCriteria(){
		
		return criteria;
	}
	 
	
	void addResponce(String input){
		
		responce = input;
		
	}//addResponce
	
	String getResponce(){
		
		return responce;
		
	}//getResponce
	
	void addMemory(String key, Object value){
		
		remember.put(key, value);
		
	}//addCriteria
	
	Map getMemories(){
		
		return remember;
	}
	
	Object getMemory(String key){
		
		Object value;
		
		value = remember.get(key);
		
		return value;
		
	}//getCriteria
	
	void addAllMemories(HashMap hm){

		remember = hm;
		
	}//addAllMemories
	
	void addPCount(){
		
		pCount++;
		
	}//addPCount
	
	void resetPCount(){
		
		pCount = 0;

	}//addPCount
	
	int getPCount(){
		
		return pCount;
		
	}//getPCount
	

	
}//class Rule
