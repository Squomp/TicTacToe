package edu.neumont.csc110.d.TicTacToe;

public class square {
	public char[] pieces = {'1','2','3','4','5','6','7','8','9'};
	
	public void placeMarker(player p, int choice){
		if(p.playerNumber == 1) pieces[choice] = 'X';
		else if (p.playerNumber == 2) pieces[choice] = 'O';
		else System.out.println("You can only have 2 players");
	}

}
