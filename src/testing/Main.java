package testing;

import java.util.Scanner;

public final class Main
{
    private Main(){}
    public static void main(String[] args)
    {
        TD53.tab2DimDefault(new int[6][13]);
        try(Scanner sc = new Scanner(System.in))
        {
            TD5Bis.moyClassSup(sc);
        }
    }
}