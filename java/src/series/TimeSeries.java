package series;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TimeSeries
{
    private Map<Integer, Double> timeSeries = new TreeMap<>();

    public void put(int time_AxisX, double decimalValue)
    {
        timeSeries.put(time_AxisX, decimalValue);
    }

    public double get(int time_AxisX)
    {
        return timeSeries.get(time_AxisX);
    }

    public Set<Entry<Integer, Double>> values()
    {
        return timeSeries.entrySet();
    }

    @Override
    public String toString()
    {
        return timeSeries.toString();
    }

    public int size()
    {
        return timeSeries.size();
    }

    public TimeSeries()
    {

    }

    public TimeSeries(double[] timeSeriesArray)
    {
        int i = 0;
        for (double decVal : timeSeriesArray)
        {
            timeSeries.put(i++, decVal);
        }
    }

    public double[] toArray()
    {
        double[] timeSeriesArray = new double[size()];
        int i = 0;
        for (Entry<Integer, Double> valueEntry : values())
        {
            timeSeriesArray[i++] = valueEntry.getValue();
        }
        return timeSeriesArray;
    }
}
