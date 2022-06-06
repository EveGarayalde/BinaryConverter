package main;

import mod.Msg;

//This is the main class which holds all the methods needed for the code
public class main {
	
	//This is the main method which is where the code starts
	public static void main(String[] args0) {
		openPage();
	}
	
	//This creates a conversion table for the user and has the user choose between inputting an integer or a binary code. 
	public static void openPage() {
		int[] og = new int[8];
		og[0] = 128; og[1] = 64;
		og[2] = 32; og[3] = 16;
		og[4] = 8; og[5] = 4;
		og[6] = 2; og[7] = 1;
		
		String BOARD = "";
		String space = " ";
		BOARD += "Conversion Table: \n";
		BOARD += "binary value: ";
		for (int i = 0; i < og.length; i++) {
			BOARD += "1" + space + space;
		}
		BOARD += "\ninteger value:     ";
		for (int i = 0; i < og.length; i++) {
			BOARD += og[i] + space;
		}
		
		String[] options = {"binary", "integer"};
		int opts = 0;
		opts = Msg.opt(options, BOARD + "\n\nWhat would you like to input? ", "Converter");
		if (opts == 0) {
			convertBCToInt();
		}
		else if (opts == 1) {
			convertIntToBC();
		}
	}
	
	//this converts the inputed binary code into an integer.
	public static void convertBCToInt() {
		String BC = Msg.in("Your binary must be 8 digits long");
		if (BC.length() > 8) {
			Msg.msg("That's greater than 8 digits!");
			convertBCToInt();
		}
		
		int[] og = new int[8];
		og[0] = 128; og[1] = 64;
		og[2] = 32; og[3] = 16;
		og[4] = 8; og[5] = 4;
		og[6] = 2; og[7] = 1;
		
		int[] bc = new int[BC.length()];
		for (int i = 0; i < BC.length(); i++) {
			bc[i] = Integer.parseInt(BC.substring(i, i+1));
		}
		
		int[] don = new int[bc.length];
		for (int i = 0; i < bc.length; i++) {
			if (bc[i] == 1) {
				don[i] = og[i];
			}
			else {
				don[i] = 0;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < don.length; i++) {
			sum += don[i];
		}
		
		Msg.msg(drawConv(og, bc, don, sum));
		exit(sum);
		
	}
	
	//this converts the inputed integer into a binary code.
	public static void convertIntToBC() {
		String IN = Msg.in("Your integer value must be less than 255");
		if (IN.length() > 255) {
			Msg.msg("That's greater than 255!");
			convertIntToBC();
		}
		
		int in = Integer.parseInt(IN);
		
		int[] og = new int[8];
		og[0] = 128; og[1] = 64;
		og[2] = 32; og[3] = 16;
		og[4] = 8; og[5] = 4;
		og[6] = 2; og[7] = 1;
		
		int[] bc = new int[og.length];
		for (int i = 0; i < bc.length; i++) {
			if (og[i] == in || og[i] < in) {
				bc[i] = og[i];
				if (in != 0) 
					in -= og[i];
			}
			else {
				bc[i] = 0;				
			}
		}
		
		int[] don = new int[og.length];
		for (int i = 0; i < don.length; i++) {
			if (bc[i] != 0) {
				don[i] = 1;
			}
			else {
				don[i] = 0;
			}
		}
		
	Msg.msg(drawConv2(IN, bc, don));
	exit(don);
		
	}
	
	//this draws out the conversion for the user (from binary to int)
	public static String drawConv(int[] og, int[] bc, int[] don, int sum) {
		String BOARD = "";
		String space = " ";

		for (int i = 0; i < bc.length; i++) {
			BOARD += bc[i] + space;
		}
		BOARD += "\n\n";
		for (int i = 0; i < don.length; i++) {
			BOARD += don[i] + space;
		}
		BOARD += "\n";
		BOARD += sum;
		
		return BOARD;
		
	}
	
	//this draws out the conversion for the user (from int to binary)
	public static String drawConv2(String IN, int[] bc, int[] don) {
		String BOARD = "";
		String space = " ";
		
		BOARD += IN + "\n\n";
		for (int i = 0; i < bc.length; i++) {
			BOARD += bc[i] + space;
		}
		BOARD += "\n";
		for (int i = 0; i < don.length; i++) {
			BOARD += don[i] + space;
		}
		
		return BOARD;
	}
	
	//This is the exit method which is what runs when the user want to exit the program (for when the convert binary to int)
	public static void exit(int sum) {
		String[] options = {"back to home page", "exit"};
		int opts = 0;
		opts = Msg.opt(options, "Your integer is: \n\n" + sum + "\n\nWhat would you like to do?", "Converter");      
		if (opts == 0) {
			Msg.msg("Click ok to continue!");
			openPage();
		}
		else if (opts == 1) {
			Msg.msg("Goodbye!");
		}
	}
	
	//This is the exit method which is what runs when the user want to exit the program (for when they convert int to binary)
	public static void exit(int[] don) {
		String BOARD = "";
		String space = " ";
		BOARD += "\n";
		for (int i = 0; i < don.length; i++) {
			BOARD += don[i] + space;
		}
		
		String[] options = {"back to home page", "exit"};
		int opts = 0;
		opts = Msg.opt(options, "Your binary code is: \n" + BOARD + "\n\nWhat would you like to do?", "Converter");      
		if (opts == 0) {
			Msg.msg("Click ok to continue!");
			openPage();
		}
		else if (opts == 1) {
			Msg.msg("Goodbye!");
		}
	}
	
}
