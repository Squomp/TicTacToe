package edu.neumont.csc110.d.TicTacToe;

import java.io.IOException;

//import edu.neumont.csc110.d.utils.ConsoleUI;

public class game {

	public void run() throws IOException {
		board b = new board();
		//square s = new square();
		player p = new player();
		player p2 = new player();
		p.playerNumber = 1;
		p2.playerNumber = 2;

		boolean playGame = true;
		while (playGame) {
			System.out.println("Welcome to Tic-Tac-Toe!");
			String[] options = { "New Game" };
			int newGame = ConsoleUI.promptForMenuSelection(options, true);

			if (newGame == 1) {
				square s = new square();
				b.printBoard(s);
				boolean win = false;
				while (win == false) {
					int p1C = p.getChoice(s, p.playerNumber);
					s.placeMarker(p, p1C);
					b.printBoard(s);
					win = b.check4Win(s);
					if (!win) {
						int p2C = p.getChoice(s, p2.playerNumber);
						s.placeMarker(p2, p2C);
					}
					b.printBoard(s);
					win = b.check4Win(s);
				}
			}
			else {
				playGame = false;
			}
		}
	}

}
