package storyGenerator;

import java.util.Random;

public class RandomNumGenerator {
	
	public RandomNumGenerator(){
		
		
		
	}//randomNumGenerator
	
	public int randNum(int possible){
		
		int number = 0;
		
		Random rand = new Random();
		//possible++;
		
		number = rand.nextInt(possible);
		
		return number;
	}//randNum

}//class randomNumGenerator
