//Main function, runs the story
package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;



public class Main {

	public static void main(String[] args) {

		RandomNumGenerator rand;
		rand = new RandomNumGenerator();
		
		World world;
		world = new World();
		
		
		ArrayList<Rule> newRuleArrayList = new ArrayList<Rule>();
		
		People person1;
		People person;

		person = new People(world,"Riddle");
		person1 = new People(world,"Adam");
		
		while(true){
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Add rules to queue
			newRuleArrayList.addAll(person.queryRules(world));
			newRuleArrayList.addAll(person1.queryRules(world));

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		int highestPCount = 0;             // PCount is the number of ways the rule is correct for the world

		if(newRuleArrayList.isEmpty()){ // if no more new rules, end story
			
			System.out.print(" The End");
			break;
			
		}//if
		
		for(int t=0; t < newRuleArrayList.size(); t++){// find best fitting rule
			
			if(highestPCount <= newRuleArrayList.get(t).getPCount() && newRuleArrayList.get(t).getPCount() > 0){
				
				highestPCount = newRuleArrayList.get(t).getPCount();
				
			}//if
			else{
				
				newRuleArrayList.remove(t);
				
			}//else
			
		}//for		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// if there are more than one fitting rule a random rule is chosen
		int num = 0;
		Rule output = null;
		
		num = rand.randNum(newRuleArrayList.size());
		
		while(newRuleArrayList.get(num).equals(null)){
			
			num = rand.randNum(newRuleArrayList.size());
		}
		
		output = newRuleArrayList.get(num);
		System.out.print(output.getResponce() + "\n");
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// updates world and removes used rules
		
		world.getWorld().putAll(output.getMemories());
		output.resetPCount();
		person.removeRule(output.getName());
		person1.removeRule(output.getName());
		person.resetRules();
		person1.resetRules();
		newRuleArrayList.clear();
		world.update();
		person.update();
		person1.update();
	}//for
		

		
	}//main

}//Main
