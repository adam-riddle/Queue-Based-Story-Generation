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

/*This is the main class*/

package storyGenerator;

import java.util.ArrayList;
import java.util.HashMap;



public class Main {

	public static void main(String[] args) {

		RandomNumGenerator rand;
		rand = new RandomNumGenerator();
		
		World world;
		world = new World();
		//IBTLibrary btLibrary = new TerranMarineBTLibrary();
		
		ArrayList<Rule> newRuleArrayList = new ArrayList<Rule>();
		
		People person1;
		People person;

		person = new People(world,"Riddle");
		person1 = new People(world,"Adam");
		
		while(true){
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//QueryRules
			newRuleArrayList.addAll(person.queryRules(world));
			newRuleArrayList.addAll(person1.queryRules(world));

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		int highestPCount = 0;

		if(newRuleArrayList.isEmpty()){
			
			System.out.print(" The End");
			break;
			
		}//if
		
		for(int t=0; t < newRuleArrayList.size(); t++){
			
			if(highestPCount <= newRuleArrayList.get(t).getPCount() && newRuleArrayList.get(t).getPCount() > 0){
				
				highestPCount = newRuleArrayList.get(t).getPCount();
				
			}//if
			else{
				
				newRuleArrayList.remove(t);
				
			}//else
			
		}//for		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int num = 0;
		Rule output = null;
		
		num = rand.randNum(newRuleArrayList.size());
		
		while(newRuleArrayList.get(num).equals(null)){
			
			num = rand.randNum(newRuleArrayList.size());
		}
		
		output = newRuleArrayList.get(num);
		System.out.print(output.getResponce() + "\n");
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
