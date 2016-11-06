package edu.neumont.csc110.d.TicTacToe;

import java.io.IOException;

public class game {

	public static void main(String[] args) throws IOException {
		board b = new board();
		square s = new square();
		player p = new player();
		player p2 = new player();
		p.playerNumber = 1;
		p2.playerNumber = 2;
		b.printBoard(s);
//		
//		
//		
		while (b.check4Win(s) == false) {
			int p1C = p.getChoice(s);
			s.placeMarker(p, p1C);
			b.printBoard(s);
			int p2C = p.getChoice(s);
			s.placeMarker(p2, p2C);
			b.printBoard(s);
		}
	}

}
