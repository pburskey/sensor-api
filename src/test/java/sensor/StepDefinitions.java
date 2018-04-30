package sensor;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.burskey.sensor.api.payload.SensorEventItemPayload;
import com.burskey.sensor.domain.SensorMonitorEventItem;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class StepDefinitions {

    SensorEventItemPayload payload = null;



    @Given("^that I have a measurement$")
    public void that_I_have_a_measurement(DataTable arg1) {

        this.payload = new SensorEventItemPayload();
        assertNotNull(payload);
        List<Map<String, String>> list = arg1.asMaps(String.class, String.class);

        for (Map<String, String> map : list)
        {

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



}
