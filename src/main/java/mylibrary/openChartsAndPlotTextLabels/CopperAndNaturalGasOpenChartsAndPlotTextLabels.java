package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.IContext;

public final class CopperAndNaturalGasOpenChartsAndPlotTextLabels extends AbstractOpenChartsAndPlotTextLabels {
    public CopperAndNaturalGasOpenChartsAndPlotTextLabels(IContext context, int year) {super(context, year);}

    @Override
    protected String[] initialiseArrayOfMonths(int year) {
        String yearToString;
        String [] arrayOfMonths = {"QHGF", "QHGG", "QHGH", "QHGJ", "QHGK", "QHGM",
                                   "QHGN", "QHGQ", "QHGU", "QHGV", "QHGX", "QHGZ",
                                   "QNGF", "QNGG", "QNGH", "QNGJ", "QNGK", "QNGM",
                                   "QNGN", "QNGQ", "QNGU", "QNGV", "QNGX", "QNGZ"};


        if (year != 2000)
            yearToString = String.valueOf(year-2000);
        else
            yearToString = "00";

        //add the number of the year to the futures symbols
        for (int i = 0; i < arrayOfMonths.length; i++) {arrayOfMonths[i] += yearToString;}

        return arrayOfMonths;
    }

}
