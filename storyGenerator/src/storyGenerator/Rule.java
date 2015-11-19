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

/* This is a basic rule object*/


package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Rule {
	
	String name;  //Name of the Rule
	
	HashMap criteria;  //What rule needs to be able to happen
	
	String responce; //What the rule does
	
	HashMap remember; //the after effects of the rule
	
	int pCount = 0; // the possibility of the rule happening
	
	
	//Basic rule constructor
	public Rule(){
		
		criteria = new HashMap();
		
		remember = new HashMap();
		
	}//Rule
	
	//Gives the rule a name
	void setName(String n){
		
		name = n;
		
	}//setName
	
	//gets the rules name
	String getName(){
		
		return name;
		
	}//getName
	
	//adds the requirements for the rule to happen	
	void addCriteria(String key, Object value){
		
		criteria.put(key, value);
		
	}//addCriteria
	
	void addAllCriteria(HashMap hm){

		criteria = hm;
	
		
		
	}//addAllCriteria
	
	//gets the requirements for the rule to happen	
	Object getCriteria(String key){
		
		Object value;
		
		value = criteria.get(key);
		
		return value;
		
	}//getCriteria
	
	//gets all the criteria from rule
	HashMap<String,Object> getAllCriteria(){
		
		return criteria;
	}
	 
	
	// adds what the rule does
	void addResponce(String input){
		
		responce = input;
		
	}//addResponce
	
	// gets what the rule does
	String getResponce(){
		
		return responce;
		
	}//getResponce
	
	// adds the after effects of the rule
	void addMemory(String key, Object value){
		
		remember.put(key, value);
		
	}//addCriteria
	
	// gets the after effects of the rules
	Map getMemories(){
		
		return remember;
	}
	
	Object getMemory(String key){
		
		Object value;
		
		value = remember.get(key);
		
		return value;
		
	}//getCriteria
	
	// gets all the after efects of a rule
	void addAllMemories(HashMap hm){

		remember = hm;
		
	}//addAllMemories
	
	// adds one point to the probability that the rule is chosen
	void addPCount(){
		
		pCount++;
		
	}//addPCount
	
	//resets pcount to 0
	void resetPCount(){
		
		pCount = 0;

	}//addPCount
	
	//gets current pcount
	int getPCount(){
		
		return pCount;
		
	}//getPCount
	

	
}//class Rule
