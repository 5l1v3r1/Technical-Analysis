package strategy.evaluator;

import indicators.movingaverage.MovingAverage;
import java.util.ArrayList;
import java.util.List;
import series.TimeSeries;
import series.TimeSeriesGenerator;
import com.tictactec.ta.lib.MAType;

public class Backtestor
{

    public void findBestParameters(TimeSeries indicator1, TimeSeries indicator2)
    {
        for (int period_min = 5; period_min < 100; period_min += 5)
        {
            for (int period_max = period_min + 1; period_max < 100; period_max += 5)
            {
                for (int j = 0; j < 1000; j++)
                {
                    double[] in = TimeSeriesGenerator.getRandomTimeSeries(1024).toArray();

                    TimeSeries sma1 = MovingAverage.ma(in, period_min, MAType.Sma);
                    TimeSeries sma2 = MovingAverage.ma(in, period_max, MAType.Sma);

                    double profit = 0.0;
                    List<Double> profits = new ArrayList<>();
                    int beg = Math.max(period_min, period_max);
                    for (int i = beg; i < in.length; i++)
                    {
                        if ((sma1.get(i) < sma2.get(i)) && (sma1.get(i - 1) >= sma2.get(i - 1)))
                        {
                            profits.add(in[i]);
                            profit += in[i];
                        }

                        if ((sma1.get(i) > sma2.get(i)) && (sma1.get(i - 1)) <= sma2.get(i - 1))
                        {
                            profits.add(-in[i]);
                            profit -= in[i];
                        }
                    }

                }

            }
        }

    }

    public static void f2(int period)
    {
        double[] in = TimeSeriesGenerator.getRandomTimeSeries(1024).toArray();
        TimeSeries sma1 = MovingAverage.ma(in, period, MAType.Sma);
        List<Double> profits = new ArrayList<>();
        double profit = 0.0;
        for (int i = period + 1; i < in.length; i++)
        {
            if ((in[i] < sma1.get(i)) && (in[i - 1] >= sma1.get(i - 1)))
            {
                profits.add(in[i]);
                profit += in[i];
            }

            if ((in[i] > sma1.get(i)) && (in[i - 1] <= sma1.get(i - 1)))
            {
                profits.add(-in[i]);
                profit -= in[i];
            }
        }

        if (Math.abs(profit) > 900)
        {
            profit -= profits.get(profits.size() - 1);
        }

        System.out.println(profit);
    }

}
