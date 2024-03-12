import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	// Created global ArrayLists (so all the methods have access to it) for player and positions 
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Created a game board containing 3 rows and 3 columns
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', ' ', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard);
		
		// Created a while true statement to loop the code indefinitely
		while(true) {
			// Create a scanner to ask the user to input a number 1-9 for placement of your mark
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your placement (1-9):");
			int playerPosition = input.nextInt();
			while(playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
				System.out.println("This is taken, enter another position: ");
				playerPosition = input.nextInt();
			}
			
			placePiece(gameBoard, playerPosition, "Player");
			
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			// Generated random numbers from 1-9 for the CPU to choose
			Random rand = new Random();
			int cpuPosition = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
				cpuPosition = rand.nextInt(9) + 1;
			}
			placePiece(gameBoard, cpuPosition, "CPU");
			
			printGameBoard(gameBoard);
			
			result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
	}
	
	// Created a method to print the game board
	public static void printGameBoard(char[][] gameBoard) {
		// Create 2 for loops to print out the game board
		for(char[] row : gameBoard) {
			for(char column : row) {
				System.out.print(column);
			}
				System.out.println();
		}
			
	}
	
	// Created a method to pass the gameBoard, position of the piece, and users
	public static void placePiece(char[][] gameBoard, int position, String user) {
		
		char symbol = ' ';
		
		// Created an if statement for the player = 'X' and CPU = 'O'
		if (user.equals("Player")) {
			symbol = 'X';
			playerPositions.add(position);
		}
		else if (user.equals("CPU")) {
			symbol = 'O';
			cpuPositions.add(position);
		}
		
		// Created a switch case to print the symbols 'X' or 'O' on the chosen position of the game board
		switch(position) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;	
			default:
				break;
		}
	}
	
	// Created a method to find and return the winner of the game 
	public static String checkWinner() {
		
		// Created a list to find the 3 in-a-row positions
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List diagonal1 = Arrays.asList(1, 5, 9);
		List diagonal2 = Arrays.asList(7, 5, 3);

		// Add the above list to a list to iterate through the win conditions so it does not create many lines of code
		List<List> winConditions = new ArrayList<List>();
		winConditions.add(topRow);
		winConditions.add(middleRow);
		winConditions.add(bottomRow);
		winConditions.add(leftColumn);
		winConditions.add(middleColumn);
		winConditions.add(rightColumn);
		winConditions.add(diagonal1);
		winConditions.add(diagonal2);
		
		for(List l : winConditions) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations! You Won!";
			}
			else if (cpuPositions.containsAll(l)) {
				return "You Lose.";
			}
			else if(playerPositions.size() + cpuPositions.size() ==9)
				return "No Winners.";
		}
		
		return "";
	}

}
