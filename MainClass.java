package assignment0;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
//Declaring the value of width of the border
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the width of the border: ");
		int W = sc.nextInt();
		int t_avg = 0;
//Making objects of the classes		
		
		Border B = new Border(W);
		Sensor S = new Sensor();
		Sensor S1 = new Sensor();
		Sensor S2 = new Sensor();
		Sensor S3 = new Sensor();
		Infiltrator I = new Infiltrator();
		Clock C = new Clock();
		
//Assigning values
		
		double p = S.dutyCycle;
		System.out.print("Enter the On Probability: ");
		p = sc.nextDouble();
		int t = C.time;
		
		int steps = 0;				

		
//The Game Begins
		for(int i = 0; i < 10; i++) {
			
			t = 0;
			steps = 0;
			I.hasCrossed = false;
				
			while(!I.hasCrossed) {
					
				S.isOn = ran.nextInt(100) < p * 100.0;
				S1.isOn = ran.nextInt(100) < p * 100.0;
				S2.isOn = ran.nextInt(100) < p * 100.0;
				S3.isOn = ran.nextInt(100) < p * 100.0;

					
				I.hasMoved = (!S.isOn) && (!S1.isOn || !S2.isOn || !S3.isOn);
					
				if(I.hasMoved) {
					steps++;
				}
				
				if(steps == B.W) {
					I.hasCrossed = true;
				}
					
				t += 10;
			}
			
			t_avg += t;
			
		}
		t_avg /= 10;
		System.out.println(t_avg + " seconds.");
		sc.close();
	}

}
