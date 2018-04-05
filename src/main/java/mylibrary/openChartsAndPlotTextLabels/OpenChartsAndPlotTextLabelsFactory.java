package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.IContext;

public class OpenChartsAndPlotTextLabelsFactory {

    public static AbstractOpenChartsAndPlotTextLabels getInstance(IContext context, String nameOfTheSetOfInstruments, int year){
        if (year < 2000 || year > 2099) {
            context.getConsole().getErr().println("Year must be between 2000 and 2099");
            context.stop();
        }

        switch (nameOfTheSetOfInstruments){
            case "FX and Equities" : return new FXAndEquitiesOpenChartsAndPlotTextLabels(context, year);

            case "Gold and Silver": return new GoldAndSilverOpenChartsAndPlotTextLabels(context, year);

            case "Light and Brent": return new LightAndBrentOpenChartsAndPlotTextLabels(context, year);

            case "Copper and Natural Gas": return new CopperAndNaturalGasOpenChartsAndPlotTextLabels(context, year);

        }

        //If switch doesn't contains the requested setOfInstruments -> print Error and stop the Strategy
        context.getConsole().getErr().println("Invalid name of the instruments set! Factory doesn't contains the: \"" + nameOfTheSetOfInstruments +"\"");
        context.stop();

        //this "null" return is unreached
        return null;
    }

}
