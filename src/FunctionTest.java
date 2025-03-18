import com.sun.jdi.VoidType;
import com.sun.jdi.VoidValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FunctionTest
{
    private FunctionTest() {}

    private static void createAndShowGUI(List<String> list)
    {
        System.out.println("Create And Show GUI");
        list.add("Banane");
        list.add("Fraise");
        list.add("Framboise");
    }

    private static void set(List<String> list, Consumer<List<String>> exe)
    {
        exe.accept(list);
    }

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        List<String> list = new ArrayList<>();

        set(list, exe -> createAndShowGUI(list));

        for(String s : list)
            System.out.println(s);
    }
}
