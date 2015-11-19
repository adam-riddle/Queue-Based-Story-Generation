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

/* This is a list of available rules. Currently filled with placeholder*/

package storyGenerator;

import java.util.ArrayList;

public class RuleList{
	
	//place holder variables
	int n1;
	int n2;
	String place1;
	boolean c1;
	boolean c2;
	
	ArrayList<Rule> ruleArrayList;
	
	//Placeholder rules
	public RuleList(){
		
		ruleArrayList = new ArrayList<Rule>();
		
		Rule rule1 = new Rule();
		rule1.setName("rule1");
		rule1.addCriteria("n1", 0);
		rule1.addCriteria("c1", true);
		rule1.addCriteria("c2", true);
		rule1.addResponce("<name> is a string");
		rule1.addMemory("n1", n1=n1+1);
		rule1.addMemory("c2", false);
		ruleArrayList.add(rule1);
		
		Rule r2 = new Rule();
		r2.setName("r2");
		r2.addCriteria("n1", 1);
		r2.addCriteria("c1", true);
		r2.addCriteria("c2", false);
		r2.addResponce("<name> is a robot.");
		r2.addMemory("n2", 0);
		r2.addMemory("c2", false);
		ruleArrayList.add(r2);
		
		Rule r25 = new Rule();
		r25.setName("r25");
		r25.addCriteria("n1", 1);
		r25.addCriteria("c1", true);
		r25.addCriteria("c2", false);
		r25.addResponce("<name> is a clone.");
		r25.addMemory("n2", 0);
		r25.addMemory("c2", false);
		r25.addMemory("n1", n1=n1+1);
		ruleArrayList.add(r25);
		
		Rule r3 = new Rule();
		r3.setName("r3");
		r3.addCriteria("n2", 0);
		r3.addResponce("<name> is a responce");
		ruleArrayList.add(r3);
		
		Rule never = new Rule();
		never.setName("never");
		never.addCriteria("place1", "hell");
		never.addResponce("You should never see me");
		ruleArrayList.add(never);

		
	}
	
	ArrayList<Rule> getRuleArrayList(){
		
		return ruleArrayList;
		
	}//getRuleArrayList
}
