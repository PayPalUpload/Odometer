package odometer;

import java.util.Scanner;

public class Odometer {
	static int digits,min_reading,max_reading;
	
	public Odometer(int dig) {
		digits = dig;
		min_reading = findMinReading();
			
	}
public static int findMinReading() {
	
	int reading=0;
	for(int i = 1; i <= digits; i++){
		reading = reading * 10 + i;
	}
	return reading;	
	}

public static int findMaxReading(){
	
	int reading = 0;
	for(int i = 10 - digits; i <= 9; i++){
		reading = reading * 10 + i;
	}
	return reading;
}
public static int[] getDigits(int reading){
	int[] arrOfDigits = new int[digits];
	int index = 0;
	while(reading != 0){
		arrOfDigits[index++] = reading % 10;
		reading /= 10;
	}
	return arrOfDigits;
}
public static boolean isCorrectReading(int reading) {
	
	int[] arrOfDigits = getDigits(reading);
	for( int i=0; i < digits-1 ; i++){
		if( !(arrOfDigits[i] > arrOfDigits[i+1] && arrOfDigits[i] != 0))  
			return false;
				
			
	}
	return true;
}
public static int convertToReading(int[] arr){
	int reading = 0;
	for(int i = digits - 1 ; i >= 0; i--){
		reading = reading * 10 + arr[i];
	}
	return reading;
}

public static int getNext(int reading){
	int[] arrOfDigits = getDigits(reading);
	int i=0;
	while(true){
		if(arrOfDigits[i] > 0 && arrOfDigits[i] < 9){
			arrOfDigits[i]++;
			int r = (convertToReading(arrOfDigits));
		}
		else{
			i++;
		}
	}
	
	
	//return 0;
}

public static int getNextBrute(int reading) {
	if (reading == findMaxReading()) {
		return findMinReading();
	}
	while(true){ 
	if(isCorrectReading(reading+1))
		 return reading+1;
	else
		reading++;
	}
}

public static int getPrevBrute(int reading) {
	if (reading == findMinReading()) {
		return findMaxReading();
	}
	while(true){ 
	if(isCorrectReading(reading-1))
		 return reading-1;
	else
		reading--;
	}
}
public static void main(String[] args){
	    System.out.println("Enter number of digits");
	    Scanner in = new Scanner(System.in);
	    int digits = in.nextInt();
		Odometer odo = new Odometer(digits);
		System.out.println("Max :"+odo.findMaxReading());
		System.out.println("Min :"+odo.findMinReading());
		System.out.println("Enter reading");
		int reading = in.nextInt();
		System.out.println("Next :"+odo.getNextBrute(reading));
		System.out.println("Prev :"+odo.getPrevBrute(reading));
		
	}
	
}
