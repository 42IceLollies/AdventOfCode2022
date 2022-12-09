package D5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class D5 {
    public static void main(String args[]) throws FileNotFoundException
    {
        File input = new File("D5/input.txt");
        Scanner scan = new Scanner(input);

        ArrayList<ArrayList<Character>> crates = new ArrayList();
        //             [L] [M]         [M]    
        //         [D] [R] [Z]         [C] [L]
        //         [C] [S] [T] [G]     [V] [M]
        // [R]     [L] [Q] [B] [B]     [D] [F]
        // [H] [B] [G] [D] [Q] [Z]     [T] [J]
        // [M] [J] [H] [M] [P] [S] [V] [L] [N]
        // [P] [C] [N] [T] [S] [F] [R] [G] [Q]
        // [Z] [P] [S] [F] [F] [T] [N] [P] [W]
        //  1   2   3   4   5   6   7   8   9 

                crates.add(new ArrayList<Character>(Arrays.asList('Z', 'P', 'M', 'H', 'R')));
                crates.add(new ArrayList<Character>(Arrays.asList('P', 'C', 'J', 'B')));
                crates.add(new ArrayList<Character>(Arrays.asList('S', 'N', 'H', 'G', 'L', 'C', 'D')));
                crates.add(new ArrayList<Character>(Arrays.asList('F', 'T', 'M', 'D', 'Q', 'S', 'R', 'L')));
                crates.add(new ArrayList<Character>(Arrays.asList('F', 'S', 'P', 'Q', 'B', 'T', 'Z', 'M')));
                crates.add(new ArrayList<Character>(Arrays.asList('T', 'F', 'S', 'Z', 'B', 'G')));
                crates.add(new ArrayList<Character>(Arrays.asList('N', 'R', 'V')));
                crates.add(new ArrayList<Character>(Arrays.asList('P', 'G', 'L', 'T', 'D', 'V', 'C', 'M')));
                crates.add(new ArrayList<Character>(Arrays.asList('W', 'Q', 'N', 'J', 'F', 'M', 'L')));
            
        
        while(scan.hasNextLine())
        {
            //0- cuantas cajas
            //1 - pila que pierda cajas
            //2 - pila que gana cajas
            int[] move = findMove(scan.nextLine());

            //mueva las cajas 
            int i = 0;

            ArrayList<Character> stack = crates.get(move[1]-1);
            ArrayList<Character> newStack = crates.get(move[2]-1);

            System.out.println("moves: " + move[0]);

            //mientras menos cajas han moveados que dice
            while(i<move[0])
            {
                //copia el pila de cajas que los pierda y los agrega a la pila que gana
                
                newStack.add(stack.get(stack.size()-1));

                //los quita de pila de que tomó
                stack.remove(stack.size()-1);
                i++;

                // System.out.println(newStack.get(newStack.size()-1));
               //System.out.println(stack.get(stack.size()-1));
                
            }

            
            for(int k = 0; k<crates.size(); k++)
            {
                for(int j = 0; j<crates.get(k).size(); j++)
                {
                    System.out.print(crates.get(k).get(j));
                }
                System.out.println();
            }
            System.out.println();
        }

        String temp = "";
        for(ArrayList<Character> curr: crates)
        {
            temp += curr.get(curr.size()-1);
        }

        System.out.println(temp);


    }

    //consigue numeros de las lineas
    public static int[] findMove(String line)
    {
        int[] temp = new int[3];

        int idx = 0; 
        for(int i = 0; i< line.length(); i++)
        {
            if(line.charAt(i)<60 && line.charAt(i)>40)
            {
                temp[idx] = Integer.parseInt(line.substring(i, i+1));
                idx++;
            }
            if(idx == 3)
            {
                break;
            }
        }
        // System.out.println(line + ", " + Arrays.toString(temp));
        return temp;
    }
    
}
