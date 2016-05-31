// hard coded in rules for convenience until I decide the best way of inputing new rules.
package storyGenerator;

import java.util.ArrayList;

public class RuleList{
	//place holder rules
	int n1;
	int n2;
	String place1;
	boolean c1;
	boolean c2;
	
	ArrayList<Rule> ruleArrayList;
	
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
		never.addCriteria("place1", "nope");
		never.addResponce("You should never see me");
		ruleArrayList.add(never);

		
	}
	
	ArrayList<Rule> getRuleArrayList(){
		
		return ruleArrayList;
		
	}//getRuleArrayList
}
