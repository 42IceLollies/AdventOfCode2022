package D4;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class D4 {
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("D4/input.txt");
        Scanner scan = new Scanner(input);

        int totalOverlaps=0;
        while(scan.hasNextLine())
        {
            String curr = scan.nextLine();
            int[] first = stringify(curr.substring(0,curr.indexOf(",")));
            int[] second = stringify(curr.substring(curr.indexOf(",")+1));

            if(findOverlap(first, second))
            {
                totalOverlaps++;
            }

            // if(first.contains(second)||second.contains(first))
            // {
            //     totalOverlaps++;
            // }
        }

        System.out.println(totalOverlaps);


    }

    //now it's technically array-ify
    public static int[] stringify(String input){
       // String temp = ",";
        int start = Integer.parseInt(input.substring(0,input.indexOf('-')));
        int end = Integer.parseInt(input.substring(input.indexOf('-')+1));
        int[] temp = new int[end-start + 1];

        int j = 0; 
        for(int i = start; i<=end; i++)
        {
            temp[j] = i;
            // temp  = (temp+i+",");
            j++;
        }

        return temp;
    }

    public static boolean findOverlap(int[] inputOne, int[] inputTwo)
    {

        //searches for each array of inputOne in inputTwo
        for(int i = 0; i<inputOne.length; i++)
        {
            for(int j = 0; j<inputTwo.length; j++)
            {
                if(inputTwo[j] == inputOne[i])
                {
                    return true;
                }
            }
        }


        return false;
    }
    
}


