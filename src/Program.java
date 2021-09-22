import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        IScript script;
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice)
        {
            case 1 -> script = new Script1();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        script.run();
    }
}
