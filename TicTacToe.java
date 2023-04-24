import java.util.*;

public class TicTacToe{

    static String[] board = {"E","E","E","E","E","E","E","E","E"};
	static Boolean play = true;
    static String player = "X"; // X or O

    public static void printBoard(){
        // Update the board after each player
        System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
    }

    // check the winning case or draw
    public static String winnerPlayer(){
        if (board[0].equals(board[1]) && board[0].equals(board[2]) && board[0]!="E"){
            return "win - player " + board[0];
        }else if (board[3].equals(board[4]) && board[3].equals(board[5]) && board[3]!="E"){
            return "win - player " + board[3];
        }else if (board[6].equals(board[7]) && board[6].equals(board[8]) && board[6]!="E"){
            return "win - player " + board[6];
        }else if (board[0].equals(board[3]) && board[0].equals(board[6]) && board[0]!="E"){
            return "win - player " + board[0];
        }else if (board[1].equals(board[4]) && board[1].equals(board[7]) && board[1]!="E"){
            return "win - player " + board[1];
        }else if (board[2].equals(board[5]) && board[2].equals(board[8]) && board[2]!="E"){
            return "win - player " + board[2];
        }else if (board[0].equals(board[4]) && board[0].equals(board[8]) && board[0]!="E"){
            return "win - player " + board[0];
        }else if (board[2].equals(board[4]) && board[2].equals(board[6]) && board[2]!="E"){
            return "win - player " + board[2];
        }
        for (int i = 0; i < 9; i++){
            if(board[i] == "E"){
                return null;
            }
        }
        return "draw";
    }

    public static void main(String[] args) {            
        while (play == true){
            System.out.println(" 3x3 Tic-Tac-Toe. Player [" + player + "] starts first. ");          
            printBoard();
            Scanner sc = new Scanner(System.in);

            while (winnerPlayer() == null){
                System.out.println(" player [" + player + "] please enter 1 to 9 on board: ");
                int input = sc.nextInt();

                // check if it is invalid input
                if (!(input < 10 && input > 0)){
                    System.out.println("Invalid input; please enter 1 to 9 on board: ");
                    continue;
                }
                
                if (board[input -1] == "E"){
                    
                    board[input -1] = player;
                    printBoard();
                }else{
                    System.out.println(" Slot taken. player [" + player + "] Please re-enter to an empty [E] slot ");
                    
                    continue;
                }
                if (player.equals("X")){
                    player = "O";
                }else{
                    player = "X";
                }
            }
                
            if (winnerPlayer() == "Draw"){
                System.out.println(" Draw. Do you want to re-play? [y/n] ");           
                while (true){
                    String select = sc.next();
                    switch (select){
                        case "y":
                            board = new String[]{"E","E","E","E","E","E","E","E","E"};
                            main(args);
                        case "n":
                            sc.close();
                            System.out.println("Thanks for playing. ");
                            return;
                        default: 
                            System.out.println("Wrong input. Please re-enter: ");
                    }
                }           
            }else{
                System.out.println( winnerPlayer() + ". Do you want to re-play? [y/n] ");            
                while (true){
                    String select = sc.next();
                    switch (select){
                        case "y":
                            board = new String[]{"E","E","E","E","E","E","E","E","E"};
                            main(args);
                        case "n":
                            sc.close();
                            System.out.println("Thanks for playing. ");
                            return;
                        default: 
                            System.out.println("Wrong input. Please re-enter: ");
                    }
                }
            }
        }
        System.exit(1);
    } 
}