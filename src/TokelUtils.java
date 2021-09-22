import java.math.BigDecimal;

public class TokelUtils
{
    public static BigDecimal fractPart(BigDecimal num)
    {
        int wholePart = num.intValue();
        return num.subtract(BigDecimal.valueOf(wholePart));
    }
}
