package testing;

import java.util.Scanner;

public final class Main
{
    private Main(){}
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in))
        {
            System.out.println(TD4.moyenne(10, 20, 18, 14, 8, 6, 4));
        }
    }
}