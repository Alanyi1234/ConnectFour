import java.util.*;
public class ConnectFour {
	public static void main (String[]args) {
		System.out.println("red goes first!" );
		String[][] gameBoard = board(); //<-- gets modified by methods inorder to pretend pieces are falling
		printBoard(gameBoard);
		int count =0;
		boolean a = true;
		while(a){
			try {
				
				if (count % 2 == 0) {
					redPattern(gameBoard);
				}
				else { 
					yellowPattern(gameBoard);
				
				}
			}
		//catch filling up the roll
		catch(Exception ex){
					System.out.println("Please enter a number between 0-6");
					//TODO loop back if entered incorrectly 
					
					
				}
			
				count++;//We need to keep track of the turns
				if(Win(gameBoard)!= null) {
					
				
					if(Win(gameBoard) == "R") {
						System.out.println("Red wins");
						a= false;
						}
					else if( Win(gameBoard) == "Y") {
						System.out.println("Yellow wins");
						a= false;
						}
					}	
				printBoard(gameBoard);
			
			
		}
		
	}
	//Makes the Board
	public static String[][] board(){
		String [][ ]a = new String[7][15];
		for (int i = 0; i<a.length; i++) {
			
			for (int j = 0; j<a[i].length; j++) {
				if (j%2 ==0) {
					a[i][j] = "|";
				}
				else {
					a[i][j]= " ";
				}
					
			}
		}
		return a;
	}
	
	//Prints the board
	public static void printBoard(String[][] a) {
		System.out.print(" 0 1 2 3 4 5 6    Column numbers");
		for(int i = 0; i<a.length-1; i++) {
			System.out.println();
			for(int j = 0; j<a[i].length; j++) {
				
				System.out.print(a[i][j]);
			}
		}
		System.out.println();
		System.out.println("^^^^^^^^^^^^^^^"); //bottom of the board
		
	}
	//Red team for the board
	
	// edit the board so that Red drops a piece into it
	public static void redPattern(String [][]a) {
		Scanner stdin= new Scanner(System.in);
		int b = 2*stdin.nextInt()+1;
		for (int i =5; i>=0; i--) {
			if (a[i][b].compareTo(" ")== 0) {
			a[i][b] = "R";
			break;
			}
			
		}
		
		
	}
	public static void yellowPattern(String [][]a) {
		Scanner stdin= new Scanner(System.in);
		int b = 2*stdin.nextInt()+1;
		for (int i =5; i>=0; i--) {
			if (a[i][b].compareTo(" ")== 0) {
				a[i][b] = "Y";
				break;
			}
		}
		
		
	}
	public static String Win(String [][]a) {
		//TODO Done left to right
		
		for(int i = 0; i< 6; i++) {// add 2 because of the | | between the board
			for (int j =1; j <8 ; j+=2) {
				
				
				if(	(a[i+1][j] != " ") 
						&& (a[i+1][j] == a[i+1][j+2])
						&& (a[i+1][j] == a[i+1][j+4])
						&& (a[i+1][j] == a[i+1][j+6]) ) {
					
					return a[i+1][j];
				}
				//else return null; // unnecessary? 
			}
				
		}
		//TODO DOne up down
		for(int i = 0; i< 6; i ++ ) {// add 2 because of the | | between the board
			for (int j =1; j <8 ; j+=2) {
				
				if(	(a[i][j] != " ") 
						&& (a[i][j] == a[i+1][j])
						&& (a[i][j] == a[i+2][j])
						&& (a[i][j] == a[i+3][j]) ) {
					
					return a[i+1][j];
				}
				//else return null; // unnecessary? 
			}
	
		}
		//TODO diagonal left to right upward
		/*for(int i = 0; i< 6; i ++ ) {// add 2 because of the | | between the board
			for (int j =0; j < 8; j+=2) {
				System.out.println("this is the value of i" + i);
				System.out.println("this is the value of j" + j);
				System.out.println("Letter" + a[i][j]);
				if(		a[i][j] != " " && 
						a[i][j] == a[i+1][j+2] && 
						a[i][j] == a[i+2][j+4] && 
						a[i][j] == a[i+3][j+6] ) {
					return a[i][j];
				}
			}
		}
		*/
		for (int i =0; i <= 2; i++) {
			for (int j = 1; j<8; j+=2){ // Top right to bottom left diagonal
				
				if (a[i][j]!=" " 
						&& a[i][j]== a[i+1][j+2] 
						&& a[i][j] == a[i+2][j+4]
						&& a[i][j]== a[i+3][j+6]) {
					System.out.println(a[i][j]);
					return a[i][j];
					
				}
			}
		}
		for (int i =3; i <6; i++) {
			for (int j= 1; j<8; j+=2) {
				if(a[i][j]!=" " 
						&& a[i][j]== a[i-1][j+2] 
						&& a[i][j] == a[i-2][j+4]
						&& a[i][j] == a[i-3][j+6]) {
					
					return a[i][j];
				}
				
				}
			
		}
		
		//TODO diagonal downward
		/*for(int i = 0; i< a.length; i +=2 ) {// add 2 because of the | | between the board
			for (int j =0; j < a[i].length ; j++) {
				if(		a[i+1][j] != " " && 
						a[i+1][j] == a[i+1][j+1] && 
						a[i+1][j] == a[i+2][j+3] && 
						a[i+1][j] == a[i+3][j+5] &&
						a[i+1][j] == a[i+4][j+7]) {
					return a[i][j] + " is the winner";
				}
			}
		}
		System.out.println("hello");
		return null;
		*/
		return null;
	}
	
}
