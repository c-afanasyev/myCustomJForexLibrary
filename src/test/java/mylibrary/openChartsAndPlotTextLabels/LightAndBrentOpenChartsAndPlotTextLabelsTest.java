package mylibrary.openChartsAndPlotTextLabels;

import org.junit.BeforeClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class LightAndBrentOpenChartsAndPlotTextLabelsTest {
    public static LightAndBrentOpenChartsAndPlotTextLabels lightAndBrentOpenChartsAndPlotTextLabels;

    @BeforeClass
    public static void beforeClass() {
        lightAndBrentOpenChartsAndPlotTextLabels = new LightAndBrentOpenChartsAndPlotTextLabels(null, 2018);
    }


    @org.junit.Test
    public void initialiseArrayOfMonths()  throws NoSuchMethodException,
                                                  InvocationTargetException,
                                                  IllegalAccessException {

        String[] arrayOfMonths = {"CLF18", "CLG18", "CLH18", "CLJ18", "CLK18", "CLM18",
                                  "CLN18", "CLQ18", "CLU18", "CLV18", "CLX18", "CLZ18",
                                  "EBF18", "EBF18_minus5", "EBG18", "EBG18_minus5", "EBH18", "EBH18_minus5",
                                  "EBJ18", "EBJ18_minus5", "EBK18", "EBK18_minus5", "EBM18", "EBM18_minus5",
                                  "EBN18", "EBN18_minus5", "EBQ18", "EBQ18_minus5", "EBU18", "EBU18_minus5",
                                  "EBV18", "EBV18_minus5", "EBX18", "EBX18_minus5", "EBZ18", "EBZ18_minus5"};

        Method method = LightAndBrentOpenChartsAndPlotTextLabels.class.getDeclaredMethod(
                "initialiseArrayOfMonths", int.class);
        method.setAccessible(true);
        String[] output = (String[])method.invoke(lightAndBrentOpenChartsAndPlotTextLabels, 2018);

        assertArrayEquals(arrayOfMonths, output);

    }

}