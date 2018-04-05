package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.*;
import com.dukascopy.api.feed.util.TimePeriodAggregationFeedDescriptor;
import mylibrary.TextPlotter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractOpenChartsAndPlotTextLabels {
    protected IContext context;
    protected int year;
    protected TextPlotter textPlotter;
    protected ZonedDateTime zdt;
    protected long time;
    protected IChart[] arrayOfCharts;
    protected String [] arrayOfMonths;

    public String[] getArrayOfMonths() {
        return arrayOfMonths;
    }

    protected AbstractOpenChartsAndPlotTextLabels(IContext context, int year) {
        if (year < 2000 || year > 2099) {
            context.getConsole().getErr().println("Year must be between 2000 and 2099");
            context.stop();
        }

        this.context = context;
        this.year = year;
        textPlotter = new TextPlotter();
        zdt = ZonedDateTime.of(this.year, 1, 1, 0, 0, 0, 0, ZoneId.of("GMT"));
        time = zdt.toInstant().toEpochMilli();
        arrayOfMonths = initialiseArrayOfMonths(year);
        arrayOfCharts = new IChart[arrayOfMonths.length];
    }

    public void openAndPlot(){
        String stringNameOfInstrument;
        double priceForTextPlotting;

        //subscribe instruments
        Set<Instrument> setOfInstruments = new HashSet<>();
        for (String month:arrayOfMonths) {
            setOfInstruments.add(Instrument.fromString(
                    NameOfJForexInstrumentSwitch.getNameOfJForexInstrument(month)));
        }
        context.setSubscribedInstruments(setOfInstruments, true);


        //Open charts and plot textLabels on each
        for (int i = 0; i < arrayOfCharts.length; i++) {
            //determine the string name of the instrument to be used for
            //opening a new chart
            stringNameOfInstrument = NameOfJForexInstrumentSwitch.getNameOfJForexInstrument(arrayOfMonths[i]);

            //open new chart
            arrayOfCharts[i] = context.openChart(
                    new TimePeriodAggregationFeedDescriptor(
                            Instrument.fromString(stringNameOfInstrument),
                            Period.DAILY,
                            OfferSide.BID));

            //determine the price which will used as a parameter for
            //plotting textLabel on a chart
            priceForTextPlotting = textPlotter.getPriceForTextPlotting(
                    context,
                    Instrument.fromString(stringNameOfInstrument),
                    time);

            //plot textLabel on chart
            textPlotter.plotText(arrayOfMonths[i],
                    arrayOfCharts[i],
                    time,
                    priceForTextPlotting);
        }

    }

    protected abstract String[] initialiseArrayOfMonths(int year);

}
