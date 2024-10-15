package testing;

public final class Utils
{
    private Utils() {}

    public static void msg(String str)
    {
        System.out.print(str);
    }

    public static void msgLn(String str)
    {
        System.out.println(str);
    }

    /* Fait la factorisation d'un entier */
    public static int facto(int nbr)
    {
        for(int i = nbr-1; i > 0; i--)
        {
            nbr=nbr*i;
        }
        return nbr;
    }    
}