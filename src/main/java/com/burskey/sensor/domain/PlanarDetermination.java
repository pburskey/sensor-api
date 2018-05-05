package com.burskey.sensor.domain;

import java.util.ArrayList;
import java.util.List;

public class PlanarDetermination {
    private double[] data = null;
    private List<Determination> determinationHistory = null;
    private Determination determination = null;

    public static enum Determination {
        DECLINE, STABLE, ASCEND
    }


    public PlanarDetermination(List<Double> list)
    {
        this(SimpleStatistics.asDoubles(list));
    }

    public PlanarDetermination(double[] aData) {
        this.data = aData;
    }

    public List<Determination> getDeterminationHistory() {
        return determinationHistory;
    }

    public Determination getDetermination() {
        if (this.determination == null) {
            this.determinationHistory = new ArrayList<>();

            List<List<Double>> chunkLists = SimpleStatistics.chunks(this.data);


            List<SimpleStatistics> statisticsList = new ArrayList<>();
            for (List<Double> list : chunkLists) {
                SimpleStatistics statistics = new SimpleStatistics(list);
                statisticsList.add(statistics);
            }

            SimpleStatistics previous = null;
            int averagePlane = 0;
            int linkedMaxPlane = 0;
            int linkedMinPlane = 0;
            for (SimpleStatistics current : statisticsList) {
                int current_averagePlane = 0;
                int current_linkedMaxPlane = 0;
                int current_linkedMinPlane = 0;
                if (previous == null) {
                    previous = current;
                } else {
                    if (current.getSummaryStatistics().getAverage() < previous.getSummaryStatistics().getAverage()) {
                        current_averagePlane--;
                    } else {
                        current_averagePlane++;
                    }

                    if (current.getSummaryStatistics().getMax() < previous.getSummaryStatistics().getMax()) {
                        current_linkedMaxPlane--;
                    } else {
                        current_linkedMaxPlane++;
                    }

                    if (current.getSummaryStatistics().getMin() < previous.getSummaryStatistics().getMin()) {
                        current_linkedMinPlane--;
                    } else {
                        current_linkedMinPlane++;
                    }

                }

                int sum = (current_averagePlane + current_linkedMaxPlane + current_linkedMinPlane);
                averagePlane=+current_averagePlane;
                linkedMaxPlane=+current_linkedMaxPlane;
                linkedMinPlane=+current_linkedMinPlane;
                if (sum < 0) {
                    this.determinationHistory.add( Determination.DECLINE);
                } else if (sum > 0) {
                    this.determinationHistory.add( Determination.ASCEND);
                } else {
                    this.determinationHistory.add( Determination.STABLE);
                }

            }


            int sum = (averagePlane + linkedMaxPlane + linkedMinPlane);

            if (sum < 0) {
                this.determination = ( Determination.DECLINE);
            } else if (sum > 0) {
                this.determination =( Determination.ASCEND);
            } else {
                this.determination = ( Determination.STABLE);
            }

        }
        return this.determination;
    }
}
