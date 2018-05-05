package sensor;

import com.burskey.sensor.api.payload.SensorEventPayload;
import com.burskey.sensor.domain.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.burskey.sensor.api.payload.SensorEventItemPayload;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    SensorEventItemPayload payload = null;

    List<Double> measurements = new ArrayList<>();
    SensorStatistics statistics = null;

    @Given("^that I have a measurement$")
    public void that_I_have_a_measurement(DataTable arg1) {

        this.payload = new SensorEventItemPayload();
        assertNotNull(payload);
        List<Map<String, String>> list = arg1.asMaps(String.class, String.class);

        for (Map<String, String> map : list) {

            payload.setTimeStamp(map.get("Date and Time"));
            payload.setMeasurement(map.get("Measurement"));

        }


    }

    @Then("^the date and time are understood$")
    public void the_date_and_time_are_understood() {

        assertNotNull(payload.getTimeStamp());
        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);
        assertNotNull(item.getTimeStamp());


    }

    @Then("^the measurement is understood$")
    public void the_measurement_is_understood() {
        assertNotNull(payload.getMeasurement());
        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);
        assertNotNull(item.getMeasurement());
    }

    @Given("^that I have the following measurements$")
    public void that_I_have_the_following_measurements(List<String> list) {

        if (list != null) {
            this.statistics = new SensorStatistics();
            this.measurements = new ArrayList<Double>();
            for (String aString : list) {
                SensorMonitorEventItem item = new SensorMonitorEventItem();
                item.setMeasurement(aString);
                this.measurements.add(item.getMeasurement());
            }
        }


    }

        @Then("^the standard deviation is < \"([^\"]*)\"$")
        public void the_standard_deviation_is(String arg1) {
            assertNotNull(this.measurements);
            assertFalse(this.measurements.isEmpty());
            assertNotNull(this.statistics);

            this.statistics.collect(this.measurements);

            Double deviation = (new BigDecimal(arg1)).doubleValue();
            assertNotNull(this.statistics.standardDeviation);
            assertTrue(this.statistics.standardDeviation.doubleValue() < deviation.doubleValue());

        }

}
