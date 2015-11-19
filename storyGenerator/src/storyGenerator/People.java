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

/*This is the default class for the actor agents*/

package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// A basic actor
public class People {
	
	Behavior behavior;
	
	String name;
	ArrayList<Rule> ruleArrayList = new ArrayList<Rule>();
	
	public People(World w, String n){
		
		behavior = new Behavior(); //Behavior controls when the agent chooses to do
		
		name = n;
		World world = w;
		
		createRuleArrayList(); // initialized the list of rules
		
	}//People
	
	
	// initialized the list of rules
	void createRuleArrayList(){
		RuleList rulelist;
		rulelist = new RuleList();
				
		ruleArrayList = rulelist.getRuleArrayList();
		
		for(int numRules=0; numRules<ruleArrayList.size();numRules++){
			String text;
			text = ruleArrayList.get(numRules).getAllCriteria().toString().replaceAll("<name>", name);
			ruleArrayList.get(numRules).addAllCriteria(stringToHashmap(text));
			
			text = ruleArrayList.get(numRules).getMemories().toString().replaceAll("<name>", name);
			ruleArrayList.get(numRules).addAllMemories(stringToHashmap(text));
			
			ruleArrayList.get(numRules).addResponce(ruleArrayList.get(numRules).getResponce().replaceAll("<name>",name)); 
		}//for
		
	}//createRuleArrayList
	
	//Picks the next rule
	ArrayList<Rule> queryRules(World world){

		ArrayList<Rule> newRuleArrayList = new ArrayList<Rule>();
		boolean rejected;
		for(int ml=0; ml<ruleArrayList.size();ml++){
			
			ruleArrayList.get(ml).addResponce(ruleArrayList.get(ml).getResponce().replaceAll("<name>",name)); 
			
		}//for
		
		
		for(int i=0; i<ruleArrayList.size(); i++){
			rejected = false;
			for(int r=0; r<ruleArrayList.get(i).getAllCriteria().size(); r++){
				
				
				
				if(world.getWorld().containsKey(ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r])&& world.getWorld().get(ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r]).toString().equals(ruleArrayList.get(i).getCriteria((String) ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r])) && rejected == false){
					
					ruleArrayList.get(i).addPCount();
					
				}//if
				else if(world.getWorld().containsKey(ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r])&& !world.getWorld().get(ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r]).toString().equals(ruleArrayList.get(i).getCriteria((String) ruleArrayList.get(i).getAllCriteria().keySet().toArray()[r]))&& rejected == false){
					
					ruleArrayList.get(i).resetPCount();
					//r = ruleArrayList.get(i).getAllCriteria().size()+1;
					rejected = true;
				}//else
				
			}//for
			
				if(ruleArrayList.get(i).getPCount() > 0 && rejected == false){
 
					newRuleArrayList.add(ruleArrayList.get(i));
					
				}//if
		
	}//for

		return newRuleArrayList;
		
	}//queryList
	
	//Converts strings for rules to be stored in hashmaps for easy retrieval
 HashMap<String,Object> stringToHashmap(String text){
	
	HashMap<String, Object> hashmap = new HashMap<String, Object>();
	 text = text.replace("{", "");
	 text = text.replace("}", "");
	for(String keyValue : text.split(", ")) {        
	 
	String[] pairs = keyValue.split("=");    
	
	hashmap.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
	 
	}//for
		
	return hashmap;
 }//stringToHashmap
	
	
 // removes used rule
 void removeRule(String n){
		
		for(int s=0; s <ruleArrayList.size(); s++){
			
			if(ruleArrayList.get(s).getName().equals(n)){
				
				ruleArrayList.remove(ruleArrayList.remove(s));
				
			}//if
			
		}//for
		
	}//removeRule
	
	//Updates actor
 void update(){
		
		behavior.changeState();
		
	}//update
	
   //resetRules
	void resetRules(){
		
		for(int i=0; i <ruleArrayList.size(); i++){
			
			ruleArrayList.get(i).resetPCount();
			
		}//for
		
	}//removeRule
	
}//class People


