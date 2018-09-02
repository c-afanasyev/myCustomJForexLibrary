package uncompilable;

import java.util.*;
import java.io.*;

import com.dukascopy.api.*;

import mylibrary.VerticalLinesPlotter;

@Library("MyCustomJForexLibrary-1.0.jar")
public class PlotBalanceFromMultithread implements IStrategy {
    private IEngine engine;
    private IConsole console;
    private IHistory history;
    private IContext context;
    private IIndicators indicators;
    private IUserInterface userInterface;
    private VerticalLinesPlotter verticalLinesPlotter;
    private Set<IChart> setOfCharts;
    private Map<String, IChart> mapOfCharts;

    @Configurable("Source of signals")
    public File file = new File("C:/jforex/files/cmeResults1h.csv");

    public void onStart(IContext context) throws JFException {
        this.engine = context.getEngine();
        this.console = context.getConsole();
        this.history = context.getHistory();
        this.context = context;
        this.indicators = context.getIndicators();
        this.userInterface = context.getUserInterface();

        setOfCharts = context.getCharts();
        mapOfCharts = new HashMap<>();
        verticalLinesPlotter = new VerticalLinesPlotter();

        for(IChart chart:setOfCharts){
            mapOfCharts.put(getChartLabelText(chart), chart);
        }

        parseFile(file);
        context.stop();
    }

    public void onAccount(IAccount account) throws JFException {
    }

    public void onMessage(IMessage message) throws JFException {
    }

    public void onStop() throws JFException {
    }

    public void onTick(Instrument instrument, ITick tick) throws JFException {
    }

    public void onBar(Instrument instrument, Period period, IBar askBar, IBar bidBar) throws JFException {
    }

    private String getChartLabelText(IChart chart){
        for (IChartObject object:chart.getAll()){
            if (object.getType().equals(IChart.Type.SCREEN_LABEL)){
                return object.getText();
            }
            else if (object.getType().equals(IChart.Type.TEXT))
                return object.getText();
        }

        //if not found an any textObject -> stop context
        console.getWarn().println("There is now any textObject on the chart " + chart.getInstrument());
        context.stop();
        return null;
    }

    private void parseFile(File file){
        //@EUH18,EUR/USD,1518991199999,15000,-11000
        try
        {
            String readedLine;
            BufferedReader bufRdrParse  = new BufferedReader(new FileReader(file));

            while((readedLine = bufRdrParse.readLine()) != null)
            {
                if(mapOfCharts.containsKey(readedLine.substring(0, readedLine.indexOf(','))))
                    verticalLinesPlotter.plotVerticalLine(mapOfCharts.get(
                            readedLine.substring(0, readedLine.indexOf(','))), readedLine);
            }

            bufRdrParse.close();
        }

        catch (Exception e)
        {
            console.getErr().println(e);
        }

    }

}

