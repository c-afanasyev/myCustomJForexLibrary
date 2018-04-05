package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.*;


public final class FXAndEquitiesOpenChartsAndPlotTextLabels extends AbstractOpenChartsAndPlotTextLabels{

    public FXAndEquitiesOpenChartsAndPlotTextLabels(IContext context, int year) {
        super(context, year);
    }

    @Override
    protected String[] initialiseArrayOfMonths(int year) {
        String yearToString;
        String[] arrayOfMonths = {"@ESH", "@ESM", "@ESU", "@ESZ",
                                  "@NQH", "@NQM", "@NQU", "@NQZ",
                                  "@YMH", "@YMM", "@YMU", "@YMZ",
                                  "@EUH", "@EUM", "@EUU", "@EUZ",
                                  "@BPH", "@BPM", "@BPU", "@BPZ",
                                  "@ADH", "@ADM", "@ADU", "@ADZ",
                                  "@NEH", "@NEM", "@NEU", "@NEZ",
                                  "@CDH", "@CDM", "@CDU", "@CDZ",
                                  "@JYH", "@JYM", "@JYU", "@JYZ",
                                  "@SFH", "@SFM", "@SFU", "@SFZ"};

        if (year != 2000)
            yearToString = String.valueOf(this.year-2000);
        else
            yearToString = "00";
        //add the number of the year to the futures symbols
        for (int i = 0; i < arrayOfMonths.length; i++) {arrayOfMonths[i] += yearToString;}

        return arrayOfMonths;
    }

}






