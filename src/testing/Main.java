package testing;

import java.util.Scanner;

public final class Main
{
    private Main(){}
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in))
        {
            int tab[]={1,-1,9,8,-88,-55,40,55};
            for(int i : tab)
            {
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println(TD4Bis.valPos(tab));
            System.out.println(TD4Bis.valNeg(tab));
        }
    }
}