package mylibrary;

import com.dukascopy.api.*;
import com.dukascopy.api.drawings.IScreenLabelChartObject;
import com.dukascopy.api.drawings.IScreenLabelChartObject.Corner;

import java.awt.*;

public class TextPlotter {

    public void plotText(String text, IChart chart){
        IScreenLabelChartObject label =
                chart.getChartObjectFactory().createScreenLabel(text);
        label.setCorner(Corner.TOP_RIGHT);
        label.setxDistance(25);
        label.setyDistance(25);
        label.setText(text, new Font(Font.SERIF, Font.BOLD, 14));
        label.setColor(Color.white);
        chart.add(label);
    }
}
