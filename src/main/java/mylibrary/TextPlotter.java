package mylibrary;

import com.dukascopy.api.*;
import com.dukascopy.api.drawings.ITextChartObject;

import java.awt.*;
import java.util.List;

public class TextPlotter {

    public void plotText(String text, IChart chart, long time, double price){
        ITextChartObject textChartObject;
        textChartObject = chart.getChartObjectFactory().createText(text,
                time, price);
        textChartObject.setText(text);
        textChartObject.setFontColor(Color.white);

        chart.add(textChartObject);
    }

    public double getPriceForTextPlotting(IContext context, Instrument instrument, long time){
        IHistory history = context.getHistory();
        long prevBarStartTime;
        long timeFor12MonthsForward;
        long lastTickTime;
        List<IBar> bars = null;

        try{
            prevBarStartTime = history.getPreviousBarStart(Period.DAILY, time);
            //timeFor12MonthsForward = prevBarStartTime + 31536000000l;

            timeFor12MonthsForward = history.getTimeForNBarsForward(Period.DAILY, prevBarStartTime, 365);
            lastTickTime = history.getStartTimeOfCurrentBar(instrument, Period.DAILY);

            long to = lastTickTime < timeFor12MonthsForward ? lastTickTime : timeFor12MonthsForward;

            bars = history.getBars(instrument, Period.DAILY, OfferSide.BID,
                    prevBarStartTime, to);
        }
        catch (JFException e){
            context.getConsole().getErr().println(e.toString());
            context.stop();
        }

        //find the biggest price by module
        double initPrice = bars.get(0).getClose();
        double price = bars.get(0).getClose();
        double difference = 0;

        for (int i = 1; i <  bars.size(); i++) {

            if (Math.abs(initPrice-bars.get(i).getClose()) > difference) {
                difference = Math.abs(initPrice-bars.get(i).getClose());
                price = bars.get(i).getClose();
            }
            if (Math.abs(initPrice-bars.get(i).getOpen()) > difference) {
                difference = Math.abs(initPrice-bars.get(i).getOpen());
                price = bars.get(i).getOpen();
            }
        }
        return price;
    }
}
