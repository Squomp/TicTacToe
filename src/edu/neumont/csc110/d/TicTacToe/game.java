package edu.neumont.csc110.d.TicTacToe;

public class game {

	public static void main(String[] args) {
		board b = new board();
		square s = new square();
		player p = new player();
		
		b.printBoard();
		
		
		
		int p1C = p.getChoice();
		s.placeMarker(1, p1C);
		int p2C = p.getChoice();
		s.placeMarker(2, p2C);
	}

}
