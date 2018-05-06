package com.burskey.sensor.api;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SensorMonitorDAOTest {

    private EmbeddedDatabase db;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
    }

    @Test
    public void testFindByname() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        List<Date> list = template.queryForList("select start from sensor_monitor_event where sensor_monitor_event_skey = 1", new MapSqlParameterSource(), Date.class);
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
