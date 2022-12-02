//and d1p2 ig


package D1;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class D1P1{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("D1/d1input.txt");
        Scanner scan = new Scanner(input);
        ArrayList<Integer> elves = new ArrayList<Integer>();

        //adds all the total numbers of calories for each elf to the array
        while(scan.hasNextLine())
        {
            int totalCals = 0; 
            String currCals = scan.nextLine();

            while(currCals != "")//while it isn't a blank line, not quite sure how to write that
            {
              //  System.out.println(currCals);
                totalCals+= Integer.valueOf(currCals);

                if(scan.hasNextLine())
                {
                currCals = scan.nextLine();
                }
                else
                {
                    break;
                }
            }

            elves.add(totalCals);
        }

        //searches for largest number in array of elves
        //first most
        int idx0 = 0;
        int amt0 = 0; 
        //second most
        int idx1 = 0; 
        int amt1 = 0;
        //third most
        int idx2 = 0;
        int amt2 = 0;

      //  System.out.println(elves.size());
        for(int j = 0; j<3; j++)
        {
            int amt = 0; 
            int idx = 0;

            for(int i = 0; i<elves.size(); i++)
            {

                if(elves.get(i)> amt)
                {
                  //  System.out.println(amt);
                    idx = i;
                    amt = elves.get(i);
                }
            }

            elves.remove(idx);

            //assigns the variables to hold each place 
            switch(j)
            {
                case 0:
                    amt0 = amt;
                    idx0 = idx;
                break;

                case 1: 
                    amt1 = amt;
                    idx1 = idx;
                break;

                case 2:
                    amt2 = amt;
                    idx2 = idx;
                break;
            }
        }

        System.out.println("Most: " +  idx0 + "- " + amt0);
        System.out.println("Second Most: " + idx1 + "- " + amt1);
        System.out.println("Third Most: " + idx2 + "- " + amt2);
        System.out.println("Total: " + (amt0+amt1+amt2) );
    }
}
