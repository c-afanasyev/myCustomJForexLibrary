package uncompilable;

import com.dukascopy.api.*;
import com.dukascopy.api.drawings.ILabelChartObject;
import mylibrary.openChartsAndPlotTextLabels.AbstractOpenChartsAndPlotTextLabels;
import mylibrary.openChartsAndPlotTextLabels.OpenChartsAndPlotTextLabelsFactory;

import java.util.Calendar;

public class OpenChartsAndPlotTextLables implements IStrategy{

    @Configurable(value = "Set Of Instruments",
                  obligatory = true,
                  options = {"FX and Equities", "Gold and Silver", "Light and Brent", "Copper and Natural Gas"})
    public String setOfInstrumentsToPlot = "FX and Equities";

    @Configurable(value = "Year", stepSize = 1, obligatory = true)
    public int year = 2018;

    Calendar calendar = Calendar.getInstance();
    @Override
    public void onStart(IContext context) throws JFException {

        AbstractOpenChartsAndPlotTextLabels chartOpenerAndPlotter =
                OpenChartsAndPlotTextLabelsFactory.getInstance(context, setOfInstrumentsToPlot, year);
        chartOpenerAndPlotter.openAndPlot();

        context.stop();

    }

    @Override
    public void onTick(Instrument instrument, ITick tick) throws JFException {

    }

    @Override
    public void onBar(Instrument instrument, Period period, IBar askBar, IBar bidBar) throws JFException {

    }

    @Override
    public void onMessage(IMessage message) throws JFException {

    }

    @Override
    public void onAccount(IAccount account) throws JFException {

    }

    @Override
    public void onStop() throws JFException {

    }
}
