package com.burskey.sensor.api;

import com.burskey.sensor.domain.PlanarDetermination;
import com.burskey.sensor.domain.SimpleStatistics;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SensorInDecline {

    public static double data[] = new double[]
            {
                    36.12,
                    36.44,
                    35.98,
                    35.4,
                    35.41,
                    35.17,
                    35.27,
                    35.33,
                    34.98,
                    35.53,
                    35.12,
                    35.09,
                    34.49,
                    35.04,
                    34.44,
                    35.19,
                    34.83,
                    35.24,
                    34.87,
                    34.61,
                    35.41,
                    34.08,
                    34.09,
                    34.9,
                    34.44,
                    34.44,
                    34.3,
                    35.14,
                    33.8,
                    34.52,
                    33.63,
                    33.72,
                    33.61,
                    33.51,
                    33.94,
                    33.87,
                    33.41,
                    33.75,
                    33.3,
                    33.21,
                    33.19,
                    34.35,
                    33.99,
                    33.53,
                    33.6,
            };


    @Test
    public void test_1() throws Exception {

        assertNotNull(data);
        int chunkSize = (int) Math.sqrt(data.length);
        assertEquals(6, chunkSize);

    }


    @Test
    public void test_2() throws Exception {

        assertNotNull(data);
        int chunkSize = (int) Math.sqrt(data.length);
        assertEquals(6, chunkSize);
        List<List<Double>> chunkLists = SimpleStatistics.chunks(data);
        assertNotNull(chunkLists);
        assertEquals(8, chunkLists.size());

    }


    @Test
    public void test_3() throws Exception {

        assertNotNull(data);

        List<List<Double>> chunkLists = SimpleStatistics.chunks(data);
        assertNotNull(chunkLists);

        DoubleSummaryStatistics stats = Arrays.stream(data).summaryStatistics();
        assertNotNull(stats);



    }




    @Test
    public void test_4() throws Exception {

        assertNotNull(data);

        SimpleStatistics statistics = new SimpleStatistics(data);

        Double average = statistics.getSummaryStatistics().getAverage();
        assertNotNull(average);



    }






    @Test
    public void test_5() throws Exception {

        assertNotNull(data);

        PlanarDetermination planarDetermination = new PlanarDetermination(data);
        assertEquals(PlanarDetermination.Determination.DECLINE, planarDetermination.getDetermination());

    }




}
