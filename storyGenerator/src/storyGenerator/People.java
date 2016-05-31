// the actors of the story
package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class People {
	
	Behavior behavior;// attribute to guide actions character will likely take
	
	String name;// name of character
	
	ArrayList<Rule> ruleArrayList = new ArrayList<Rule>();
	
	public People(World w, String n){
		//creates character
		
		behavior = new Behavior();
		
		name = n;
		World world = w;
		
		createRuleArrayList();
		
	}//People
	
	void createRuleArrayList(){
		// creates rules for character
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
	
	void removeRule(String n){
		
		for(int s=0; s <ruleArrayList.size(); s++){
			
			if(ruleArrayList.get(s).getName().equals(n)){
				
				ruleArrayList.remove(ruleArrayList.remove(s));
				
			}//if
			
		}//for
		
	}//removeRule
	
	void update(){
		
		behavior.changeState();
		
	}//update
	
	void resetRules(){
		
		for(int i=0; i <ruleArrayList.size(); i++){
			
			ruleArrayList.get(i).resetPCount();
			
		}//for
		
	}//removeRule
	
}//class People


