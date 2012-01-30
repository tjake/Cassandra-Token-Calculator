
import java.math.BigInteger;

public class TokenCalulator
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length == 0)
            {
                System.err.println("Usage: calculate_token.sh [node] [total]");
		return;
            }

            Integer node  = Integer.valueOf(args[0]);
            Integer total = Integer.valueOf(args[1]);
            
            if(node < 0 || total <= 0 || node >= total)
                throw new RuntimeException("Invalid input: "+node+" "+total);
            
            BigInteger token = BigInteger.valueOf(node);
            BigInteger pow   = BigInteger.valueOf(2).pow(127).subtract(BigInteger.ONE);
            token = token.multiply(pow).divide(BigInteger.valueOf(total));

            System.out.println("Token "+node+" of "+total+": "+token.abs().toString());

	    return;
        }
        catch(Throwable t)
        {
            t.printStackTrace();
            System.err.println("Usage: calculate_token.sh [node] [total]");
        }
        
    }   
}
