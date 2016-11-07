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
		boolean gameOver = true;
		boolean win = true;
		//X win conditions
		if(box.pieces[0] == 'X' && box.pieces[1] == 'X' && box.pieces[2] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[3] == 'X' && box.pieces[4] == 'X' && box.pieces[5] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[6] == 'X' && box.pieces[7] == 'X' && box.pieces[8] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[0] == 'X' && box.pieces[3] == 'X' && box.pieces[6] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[1] == 'X' && box.pieces[4] == 'X' && box.pieces[7] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[2] == 'X' && box.pieces[5] == 'X' && box.pieces[8] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[0] == 'X' && box.pieces[4] == 'X' && box.pieces[8] == 'X'){
			System.out.println("Player 1 wins!");
		}
		else if(box.pieces[2] == 'X' && box.pieces[4] == 'X' && box.pieces[6] == 'X'){
			System.out.println("Player 1 wins!");
		}
		//now to O win conditions
		else if(box.pieces[0] == 'O' && box.pieces[1] == 'O' && box.pieces[2] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[3] == 'O' && box.pieces[4] == 'O' && box.pieces[5] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[6] == 'O' && box.pieces[7] == 'O' && box.pieces[8] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[0] == 'O' && box.pieces[3] == 'O' && box.pieces[6] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[1] == 'O' && box.pieces[4] == 'O' && box.pieces[7] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[2] == 'O' && box.pieces[5] == 'O' && box.pieces[8] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[0] == 'O' && box.pieces[4] == 'O' && box.pieces[8] == 'O'){
			System.out.println("Player 2 wins!");
		}
		else if(box.pieces[2] == 'O' && box.pieces[4] == 'O' && box.pieces[6] == 'O'){
			System.out.println("Player 2 wins!");
		}
		//no win yet
		else {
			gameOver = false;
			win = false;
		}
		//Stalemate
		//boolean stalemate = false;
		int index = 0;
		while(index < 9){
			if(win == false && (box.pieces[index] == 'X' || box.pieces[index] == 'O')){
				index++;
			}
			else {
				break;
			}
		}
		if(index == 9){
			System.out.println("Stalemate!");
			gameOver = true;
		}
		
			
		return gameOver;
	}
	
}
