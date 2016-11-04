package edu.neumont.csc110.d.TicTacToe;

public class board {
	
	public void printBoard(square s){
		
		System.out.println(" " + s.pieces[0] + " | " + s.pieces[1] + " | " + s.pieces[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + s.pieces[3] + " | " + s.pieces[4] + " | " + s.pieces[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + s.pieces[6] + " | " + s.pieces[7] + " | " + s.pieces[8] + " \n");
		
		
	}
	
	public boolean check4Win(square box){
		
		return true;
	}
	
}
