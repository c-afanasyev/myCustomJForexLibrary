package mylibrary;

import com.dukascopy.api.IChart;
import com.dukascopy.api.drawings.IVerticalLineChartObject;

import java.awt.Color;

public class VerticalLinesPlotter {
    public void plotVerticalLine(IChart chart, String quote){

        IVerticalLineChartObject verticalLineChartObject;
        verticalLineChartObject = chart.getChartObjectFactory().createVerticalLine(getTimeCode(quote),
                Long.parseLong(getTimeCode(quote)));

        if (Integer.parseInt(getUpTicksString(quote)) < Math.abs(Integer.parseInt(getDownTicksString(quote))))
            verticalLineChartObject.setColor(Color.red);
        else if (Integer.parseInt(getUpTicksString(quote)) > Math.abs(Integer.parseInt(getDownTicksString(quote))))
            verticalLineChartObject.setColor(Color.green);
        else
            verticalLineChartObject.setColor(Color.white);

        if (!getUpTicksString(quote).equals("0") && !getDownTicksString(quote).equals("0"))
            verticalLineChartObject.setText(getUpTicksString(quote) + " " + getDownTicksString(quote));
        else if (getDownTicksString(quote).equals("0"))
            verticalLineChartObject.setText(getUpTicksString(quote));
        else
            verticalLineChartObject.setText(getDownTicksString(quote));

        if (Math.abs(Integer.parseInt(getUpTicksString(quote)) + Integer.parseInt(getDownTicksString(quote))) < 2)
            verticalLineChartObject.setLineWidth(2.0f);


        chart.add(verticalLineChartObject);
    }

    //@YMH18,USA30.IDX/USD,1518991199999,178,-168 -> !(get '-168')!
    String getDownTicksString(String string){
        return string.substring(string.lastIndexOf(',')+1);
    }

    //@YMH18,USA30.IDX/USD,1518991199999,178,-168 -> !(get '178')!
    String getUpTicksString(String string){
        return string.substring(string.lastIndexOf(
                ',', string.lastIndexOf(',')-1)+1, string.lastIndexOf(','));
    }

    //@YMH18,USA30.IDX/USD,1518991199999,178,-168 -> !(get '1518991199999')!
    String getTimeCode(String string){
        return string.substring(string.indexOf(
                ',', string.indexOf(',')+1)+1, string.lastIndexOf(
                        ',', string.lastIndexOf(',')-1));

    }

}
