package com.tech.designpattern.creationalPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBill {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
  
		GetPlanFactory planFactory = new GetPlanFactory();
		
		System.out.println("Enter name of the plan for which the bill will be generated");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String planName = br.readLine();
		System.out.println("Enter the numbers of units for bill will be calculated");
		int units = Integer.parseInt(br.readLine());
		
		Plan p = planFactory.getPlan(planName);
		
		System.out.print("Bill amount for " + planName + "of" + units + ": ");
		p.getRate();
		p.calculateBill(units);
	}

}
