package D3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3 {
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("D3/input.txt");
        Scanner scan = new Scanner(input);

        int totalPriority = 0;

        while(scan.hasNextLine())
        {
          //  String curr = scan.nextLine();

            //split
           // int splitPoint = curr.length()/2;
            // String compartOne = curr.substring(0,splitPoint);
            // String compartTwo = curr.substring(splitPoint);
            String packOne = scan.nextLine();
            String packTwo = scan.nextLine();
            String packThree = scan.nextLine();

            //find
            char duplicate = ' ';//more like triplicate ig
            // for(int i = 0; i<compartOne.length(); i++)
            // {
            //     if(compartTwo.contains(compartOne.substring(i, i+1)))
            //     {
            //         duplicate = compartOne.charAt(i);
            //         break;
            //     }
            // }

                 for(int i = 0; i<packOne.length(); i++)
            {
                String searchFor = packOne.substring(i, i+1);
                if(packTwo.contains(searchFor) && packThree.contains(searchFor))
                {
                    duplicate = packOne.charAt(i);
                    break;
                }
            }

            //prioritize
            if(duplicate>90)
            {
                //gets priority based on ascii number
                totalPriority+=(duplicate-96);
            } else
            {
                totalPriority += (duplicate -38);
            }
        }

        //report
        System.out.println(totalPriority);

    }
    
}
