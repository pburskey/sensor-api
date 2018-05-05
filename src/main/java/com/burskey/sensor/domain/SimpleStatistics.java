package com.burskey.sensor.domain;

import java.util.*;
import java.util.stream.Collectors;


public class SimpleStatistics
{
    private DoubleSummaryStatistics summaryStatistics = null;
    private double[] numbers = null;


    public SimpleStatistics(List<Double> list)
    {
        this(asDoubles(list));
    }

    public SimpleStatistics(double[] aNumbers)
    {
        this.numbers = aNumbers;
        if (this.numbers != null)
        {


            this.summaryStatistics = Arrays.stream(this.numbers).summaryStatistics();
        }
    }

    public DoubleSummaryStatistics getSummaryStatistics() {
        return summaryStatistics;
    }

    public double[] getNumbers() {
        return numbers;
    }

    public static List<List<Double>> chunks(double[] doubles) {
        List<List<Double>> chunkLists = null;
        if (doubles != null) {
            chunkLists = new ArrayList<>();
            int chunkSize = (int) Math.sqrt(doubles.length);

            List<Double> list = Arrays.stream(doubles).boxed().collect(Collectors.toList());

            int count = 0;

            List<Double> current = null;
            for (Iterator<Double> iterator = list.iterator(); iterator.hasNext(); ) {
                Double aDouble = iterator.next();

                count++;
                int modBreak = (count % chunkSize);
                if (modBreak == 0) {
                    current = null;
                    count = 0;
                }

                if (current == null) {
                    current = new ArrayList<Double>();
                    chunkLists.add(current);
                }

                current.add(aDouble);
            }


        }

        return chunkLists;
    }


    static double[] asDoubles(List<Double> list)
    {
        double[] doubles = null;
        if (list != null && !list.isEmpty())
        {
            doubles = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                doubles[i] = list.get(i);

            }

        }
        return doubles;
    }





}
