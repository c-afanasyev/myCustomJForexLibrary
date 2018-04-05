package mylibrary.openChartsAndPlotTextLabels;

import com.dukascopy.api.*;



public final class LightAndBrentOpenChartsAndPlotTextLabels extends AbstractOpenChartsAndPlotTextLabels {
    public LightAndBrentOpenChartsAndPlotTextLabels(IContext context, int year) {super(context, year);}

    @Override
    protected String[] initialiseArrayOfMonths(int year) {

        String yearToString;
        String [] arrayOfMonths = {"QCLF", "QCLG", "QCLH", "QCLJ", "QCLK", "QCLM",
                                   "QCLN", "QCLQ", "QCLU", "QCLV", "QCLX", "QCLZ",
                                   "EBF", "EBF", "EBG", "EBG", "EBH", "EBH",
                                   "EBJ", "EBJ", "EBK", "EBK", "EBM", "EBM",
                                   "EBN", "EBN", "EBQ", "EBQ", "EBU", "EBU",
                                   "EBV", "EBV", "EBX", "EBX", "EBZ", "EBZ"};

        if (year != 2000)
            yearToString = String.valueOf(year-2000);
        else
            yearToString = "00";

        //add the number of the year to the futures symbols
        for (int i = 0; i < arrayOfMonths.length; i++) {arrayOfMonths[i] += yearToString;}

        //add postfix "_minus5" to an every second Brent symbol
        for (int i = 13; i < arrayOfMonths.length; i += 2) {arrayOfMonths[i] += "_minus5";}

        return arrayOfMonths;
    }
}
