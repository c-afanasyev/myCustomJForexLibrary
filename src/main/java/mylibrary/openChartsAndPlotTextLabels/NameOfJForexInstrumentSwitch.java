package mylibrary.openChartsAndPlotTextLabels;

public class NameOfJForexInstrumentSwitch {

    public static String getNameOfJForexInstrument(final String nameOfFuturesInstrument){

        if (nameOfFuturesInstrument.contains("_minus5")) {return "BRENT.CMD/USD";}

        switch (nameOfFuturesInstrument.substring(0, nameOfFuturesInstrument.length()-3)){
            case "@ES" : return "USA500.IDX/USD";

            case "@NQ" : return "USATECH.IDX/USD";

            case "@YM" : return "USA30.IDX/USD";

            case "QCL" : return "LIGHT.CMD/USD";

            case "EB" : return "BRENT.CMD/USD";

            case "QHG" : return "COPPER.CMD/USD";

            case "QNG" : return "GAS.CMD/USD";

            case "QGC" : return "XAU/USD";

            case "QSI" : return "XAG/USD";

            case "@EU" : return "EUR/USD";

            case "@BP" : return "GBP/USD";

            case "@AD" : return "AUD/USD";

            case "@NE" : return "NZD/USD";

            case "@CD" : return "USD/CAD";

            case "@JY" : return "USD/JPY";

            case "@SF" : return "USD/CHF";

            default : return null;
        }

    }
}
