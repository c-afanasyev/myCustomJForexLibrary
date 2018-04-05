package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.IContext;

public final class GoldAndSilverOpenChartsAndPlotTextLabels extends AbstractOpenChartsAndPlotTextLabels {
    public GoldAndSilverOpenChartsAndPlotTextLabels(IContext context, int year) {super(context, year);}

    @Override
    protected String[] initialiseArrayOfMonths(int year) {

        String yearToString;
        String [] arrayOfMonths = {"QGCG", "QGCH", "QGCJ", "QGCM",
                                   "QGCQ", "QGCV", "QGCZ",
                                   "QSIF", "QSIG", "QSIH", "QSIJ",
                                   "QSIK", "QSIN", "QSIU", "QSIZ"};


        if (year != 2000)
            yearToString = String.valueOf(year-2000);
        else
            yearToString = "00";

        //add the number of the year to the futures symbols
        for (int i = 0; i < arrayOfMonths.length; i++) {arrayOfMonths[i] += yearToString;}

        return arrayOfMonths;
    }
}
