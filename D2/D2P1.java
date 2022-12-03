//once again, this is also just puzzle two because I'm to lazy to make a new file

package D2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class D2P1 {
    public static void main(String[] args) throws FileNotFoundException
    {
        //rules:
        //A,X: Rock  - One Point
        int rock = 1;
        //B.Y: Paper - Two Points
        int paper = 2;
        //C,Z: Scissors - Three Points
        int scissors = 3;

        //Lost: 0
        int lost = 0;
        //Draw: 3
        int draw = 3;
        //Won: 6
        int won = 6;

        //Score for single round: score of shape plus score of outcome

        
        File input = new File("D2/d2input.txt");
        Scanner turn = new Scanner(input);


        int totalPoints = 0;

        while(turn.hasNextLine())
        {
            String turns = turn.nextLine();
            char oppTurn = turns.charAt(0);
            int oppTurnNum = oppTurn-64;
            int winStatus = (turns.charAt(2)-88)*3;
            int yourTurn = chooseMove(oppTurnNum, winStatus); //not actually yourturn for the second puzzle but too lazy to change it  

            totalPoints+=winStatus;
            //System.out.print(yourTurn);
            totalPoints+= yourTurn;




            //puzzle one

        //     switch(yourTurn)
        //     {
        //         case 1:
        //             //rock
        //             totalPoints+=rock;
        //             switch(oppTurn)
        //             {
        //                 case 'A':
        //                     totalPoints+=draw;
        //                 break;
        //                 case 'B':
        //                     totalPoints+=lost;
        //                 break;
        //                 case 'C':
        //                     totalPoints+=won;
        //                 break;
        //             }
        //         break;

        //         case 2:
        //             //paper
        //             totalPoints+=paper;
        //             switch(oppTurn)
        //             {
        //                 case 'A':
        //                     totalPoints+=won;
        //                 break;
        //                 case 'B':
        //                     totalPoints+=draw;
        //                 break;
        //                 case 'C':
        //                     totalPoints+=lost;
        //                 break;
        //             }
        //         break;

        //         case 3:
        //             //scissors
        //             totalPoints+=scissors;
        //             switch(oppTurn)
        //             {
        //                 case 'A':
        //                     totalPoints+=lost;
        //                 break;
        //                 case 'B':
        //                     totalPoints+=won;
        //                 break;
        //                 case 'C':
        //                     totalPoints+=draw;
        //                 break;
        //             }
        //         break;
        //     }
         
         }

        System.out.println(totalPoints);

   

    }
    
            public static int chooseMove(int move, int winStatus)
            {
                //System.out.println(move);

                if(winStatus == 0)
                {
                    int newMove = move-1;
                    if(newMove == 0)
                        return 3;
                    return newMove;
                }

                if(winStatus == 3 )
                {
                    return move;

                }

                if(winStatus == 6)
                {
                    int newMove = move+1;
                    if(newMove == 4)
                    return 1;
                    return newMove;
                }

                return -1;
            }

}


