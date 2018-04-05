package mylibrary;

import static org.junit.Assert.*;


public class VerticalLinesPlotterTest {
    @org.junit.Test
    public void getDownTicksString() throws Exception {
        //@YMH18,USA30.IDX/USD,1518991199999,178,-168
        VerticalLinesPlotter verticalLinesPlotter1 = new VerticalLinesPlotter();
        assertEquals("-168", verticalLinesPlotter1.getDownTicksString(
                "@YMH18,USA30.IDX/USD,1518991199999,178,-168"));

        //@SFH18,USD/CHF,1518991199999,5,-6
        VerticalLinesPlotter verticalLinesPlotter2 = new VerticalLinesPlotter();
        assertEquals("-6", verticalLinesPlotter2.getDownTicksString(
                "@SFH18,USD/CHF,1518991199999,5,-6"));

        //@JYH18,USD/JPY,1518991199999,20,-18
        VerticalLinesPlotter verticalLinesPlotter3 = new VerticalLinesPlotter();
        assertEquals("-18", verticalLinesPlotter3.getDownTicksString(
                "@JYH18,USD/JPY,1518991199999,20,-18"));


    }

    @org.junit.Test
    public void getUpTicksString() throws Exception {
        //@YMH18,USA30.IDX/USD,1518991199999,178,-168
        VerticalLinesPlotter verticalLinesPlotter1 = new VerticalLinesPlotter();
        assertEquals("178", verticalLinesPlotter1.getUpTicksString(
                "@YMH18,USA30.IDX/USD,1518991199999,178,-168"));

        //@SFH18,USD/CHF,1518991199999,5,-6
        VerticalLinesPlotter verticalLinesPlotter2 = new VerticalLinesPlotter();
        assertEquals("5", verticalLinesPlotter2.getUpTicksString(
                "@SFH18,USD/CHF,1518991199999,5,-6"));

        //@JYH18,USD/JPY,1518991199999,20,-18
        VerticalLinesPlotter verticalLinesPlotter3 = new VerticalLinesPlotter();
        assertEquals("20", verticalLinesPlotter3.getUpTicksString(
                "@JYH18,USD/JPY,1518991199999,20,-18"));
    }

    @org.junit.Test
    public void getTimeCode() throws Exception {
        //@YMH18,USA30.IDX/USD,1518991199999,178,-168
        VerticalLinesPlotter verticalLinesPlotter1 = new VerticalLinesPlotter();
        assertEquals("1518991199999", verticalLinesPlotter1.getTimeCode(
                "@YMH18,USA30.IDX/USD,1518991199999,178,-168"));

        //@SFH18,USD/CHF,1518991199999,5,-6
        VerticalLinesPlotter verticalLinesPlotter2 = new VerticalLinesPlotter();
        assertEquals("1518991199999", verticalLinesPlotter2.getTimeCode(
                "@SFH18,USD/CHF,1518991199999,5,-6"));

        //@JYH18,USD/JPY,1518991199999,20,-18
        VerticalLinesPlotter verticalLinesPlotter3 = new VerticalLinesPlotter();
        assertEquals("1518991199999", verticalLinesPlotter3.getTimeCode(
                "@JYH18,USD/JPY,1518991199999,20,-18"));
    }

}