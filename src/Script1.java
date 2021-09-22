import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Script1 implements IScript
{
    @Override
    public void run()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number:");
        String num = in.next();
        num = num.replace(',', '.');
        System.out.println("Enter the radix:");
        int radix = in.nextInt();
        System.out.println("Enter the decimal places:");
        int decimalPlaces = in.nextInt();

        BigDecimal decimalNum = new BigDecimal(num);
        BigDecimal decimalRadix = new BigDecimal(radix);

        ArrayList<Integer> whole = new ArrayList<>();
        ArrayList<Integer> fract = new ArrayList<>();

        BigDecimal fr = TokelUtils.fractPart(decimalNum);

        for (int i = decimalNum.intValue(); i > 0; i /= radix)
        {
            whole.add(i % radix);
        }

        for(int i = 0; i < decimalPlaces && fr.doubleValue() != 0; i++)
        {
            fr = fr.multiply(decimalRadix);
            fract.add(fr.intValue());
            fr = TokelUtils.fractPart(fr);
        }

        Collections.reverse(whole);

        if(whole.isEmpty())
        {
            System.out.print(0);
        }

        for(int i : whole)
        {
            System.out.print(i);
        }

        if(!fract.isEmpty())
        {
            System.out.print(",");

            for (int i : fract)
            {
                System.out.print(i);
            }
        }
    }
}
