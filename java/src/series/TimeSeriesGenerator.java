package series;

import java.util.Random;

public class TimeSeriesGenerator
{
    static Random random = new Random();

    public static TimeSeries getRandomTimeSeries(final int length)
    {
        double[] out = new double[length];
        out[0] = 1000;
        for (int i = 1; i < length; i++)
        {
            out[i] = out[i-1] + random.nextInt(20) - random.nextInt(20); 
        }
        
        return new TimeSeries(out);
    }
}