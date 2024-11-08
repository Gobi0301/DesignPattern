package com.techymeet.buscontroller;

import java.util.ArrayList;
import java.util.Scanner;

import com.techymeet.busbo.Busbo;

public class Bus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Busbo buses[] = new Busbo[50];
		ArrayList<Busbo> buses = new ArrayList<>();
		
		
		Scanner sc = new Scanner(System.in);
		int opt = 1;
		while(opt == 1) {
			System.out.println("Enter 1 to book and 2 to exit :");
			opt = sc.nextInt();
			if(opt == 1) {
				System.out.println("Booking....");
			}
		} 
		
		

	}

}
