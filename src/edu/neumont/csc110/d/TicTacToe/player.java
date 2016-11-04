package edu.neumont.csc110.d.TicTacToe;

public class player {
	public int playerNumber;
	
	public int getChoice(square s){
		int input;
		while(true){
			input = ConsoleUI.promptForInt("Please enter a number between 1 and 9: ", 1, 9);
			if(s.pieces[input - 1] != 'X' && s.pieces[input - 1] != 'O') break;
			else System.out.println("That has already been picked, please pick another number");
		}
		
		return input - 1;
	}
}
