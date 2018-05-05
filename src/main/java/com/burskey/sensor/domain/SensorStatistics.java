package com.burskey.sensor.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SensorStatistics {
    public Double high = null;
    public Double low = null;
    public Number standardDeviation = null;
    public List<Double> history = null;
    public Double mean = null;

    public void collect(List<Double> list) {
        if (list != null) {
            this.history = list;
            for (Double aMeasurement : this.history) {
                if (aMeasurement != null) {


                    if (this.high == null || this.high < aMeasurement) {
                        this.high = aMeasurement;

                    }

                    if (this.low == null || this.low > aMeasurement) {
                        this.low = aMeasurement;


                    }
                }
            }

            Number[] numbers = this.history.toArray(new Number[this.history.size()]);
            this.standardDeviation = this.standardDeviation(numbers);
        }


    }


    protected Number standardDeviation(Number[] numbers) {

        Double standardDeviation = null;
        if (numbers != null)
        {
            standardDeviation = DoubleStatistics.computeStandardDeviation(numbers);
        }

        Number[] trimmed = this.removeOutliers(numbers);
        Double trimmedStandardDeviation = DoubleStatistics.computeStandardDeviation(trimmed);



        return trimmedStandardDeviation;
    }



    protected Number[] removeOutliers(Number[] numbers)
    {
        Arrays.sort(numbers);

        int length = numbers.length;
        double trimPercent = .05;

        int trim = (int) (length * trimPercent);

        for (int i = 0; i < trim; i++) {
            numbers[i] = null;
        }


        for (int i = 0; i < trim; i++) {
            int index = (numbers.length - 1) - i;
            numbers[index] = null;
        }

        List<Number> list = new ArrayList<>();
        for (Number number: numbers)
        {
            if (number != null)
            {
                list.add(number);
            }
        }



        numbers = list.toArray(new Number[list.size()]);
        Arrays.sort(numbers);
        return numbers;

    }







}
