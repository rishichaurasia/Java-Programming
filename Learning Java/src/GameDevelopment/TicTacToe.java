package GameDevelopment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

	public static final int BOARD_SIZE = 3;

	public static enum GameStatus {
		Incomplete, XWins, ZWins, Tie
	}

	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	boolean crossTurn = true;
	
	int movesCount = 0;
	final int maxMoves = BOARD_SIZE*BOARD_SIZE;

	public TicTacToe() {
		super.setTitle("TicTacToe");
		super.setSize(800, 800);
		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(grid);
		Font font = new Font("Comic Sans", 1, 150); // Font name, style, size
		for (int row = 0; row < BOARD_SIZE; row++) {

			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton();
				buttons[row][col] = button;
				button.setFont(font);
				button.addActionListener(this);
				super.add(button);
			}

		}
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton clickedButton = (JButton) e.getSource();
		makeMove(clickedButton);
		GameStatus gs = this.getGameStatus();
		
		if(gs == GameStatus.Incomplete)
			return;
		
		declareWinner(gs);
		
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to play again?");
		if(choice == JOptionPane.YES_OPTION) {
			// set texts of all buttons to empty strings
			for (int row = 0; row < BOARD_SIZE; row++) {

				for (int col = 0; col < BOARD_SIZE; col++) {
			
					buttons[row][col].setText("");
					
				}

			}
			movesCount = 0;
			crossTurn = true;
		}else {
			super.dispose();
		}

	}

	private void declareWinner(GameStatus gs) {
		
		if(gs == GameStatus.XWins) {
			JOptionPane.showMessageDialog(this, "X Wins");
		}else if(gs == GameStatus.ZWins)
			JOptionPane.showMessageDialog(this, "Z Wins");
		else
			JOptionPane.showMessageDialog(this, "It's a Tie");
		
	}

	private GameStatus getGameStatus() {

		String text1 = "", text2 = "";

		// text inside rows
		for (int row = 0; row < BOARD_SIZE; row++) {
			int col;
			for (col = 0; col < BOARD_SIZE - 1; col++) {

				text1 = buttons[row][col].getText();
				text2 = buttons[row][col + 1].getText();
				if (text1.isEmpty() || !text1.equals(text2))
					break;

			}

			if (col == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}

		}
		
		// text inside cols
		for (int col = 0; col < BOARD_SIZE; col++) {
			int row;
			for (row = 0; row < BOARD_SIZE - 1; row++) {

				text1 = buttons[row][col].getText();
				text2 = buttons[row+1][col].getText();
				if (text1.isEmpty() || !text1.equals(text2))
					break;

			}

			if (row == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}

		}
		
		// text inside first diagonals
		int i;
		for(i = 0; i<BOARD_SIZE-1; i++) {
			
			text1 = buttons[i][i].getText();
			text2 = buttons[i+1][i+1].getText();
			if (text1.isEmpty() || !text1.equals(text2))
				break;
		}
		if (i == BOARD_SIZE - 1) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}
		
		// text inside second diagonals
		for(i = 0; i<BOARD_SIZE-1; i++) {
			
			text1 = buttons[i][BOARD_SIZE-i-1].getText();
			text2 = buttons[i+1][BOARD_SIZE-1-(i+1)].getText();
			if (text1.isEmpty() || !text1.equals(text2))
				break;
		}
		if (i == BOARD_SIZE - 1) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}
		
		if(movesCount == maxMoves)
			return GameStatus.Tie;
		else
			return GameStatus.Incomplete;
	}

	private void makeMove(JButton clickedButton) {

		String btntext = clickedButton.getText();

		if (btntext.isEmpty()) {

			if (crossTurn) {
				clickedButton.setText("X");
			} else
				clickedButton.setText("0");

			crossTurn = !crossTurn;
			movesCount++;

		} else {

			JOptionPane.showMessageDialog(this, "Invalid Move");

		}

	}

}
