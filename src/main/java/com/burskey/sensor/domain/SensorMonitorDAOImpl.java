package com.burskey.sensor.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class SensorMonitorDAOImpl implements SensorMonitorDAO
{

    private static final String const_insert_system_monitor_event = "insert into sensor_monitor_event(start, stop, create_ts) values(:start , :stop , :create_ts )";
    private static final String const_insert_system_monitor_event_item = "insert into sensor_monitor_event_item(sensor_monitor_event_skey, recordedDateTime, measurement) values(:sensor_monitor_event_skey, :recordedDateTime , :measurement)";



    @Autowired
    DataSource dataSource = null;


    @Override
    public SensorMonitorEvent save(SensorMonitorEvent event) {


        if (event != null)
        {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.dataSource);
            MapSqlParameterSource map = new MapSqlParameterSource();
            map.addValue("start", event.getStart(), Types.TIMESTAMP);
            map.addValue("stop", event.getStart(), Types.TIMESTAMP);
            map.addValue("create_ts", event.getCreationDate(), Types.TIMESTAMP);

            int count = template.update(const_insert_system_monitor_event, map, keyHolder);
            if (count > 0)
            {
                Long skey = keyHolder.getKey().longValue();
                event.setSensorMonitorEventSkey(skey);
            }


            for(SensorMonitorEventItem item : event.getItems())
            {
                item.setSensorMonitorEventSkey(event.getSensorMonitorEventSkey());

                keyHolder = new GeneratedKeyHolder();
                map = new MapSqlParameterSource();
                map.addValue("sensor_monitor_event_skey", item.getSensorMonitorEventSkey(), Types.BIGINT);
                map.addValue("recordedDateTime", item.getTimeStamp(), Types.TIMESTAMP);
                map.addValue("measurement", item.getMeasurement(), Types.DECIMAL);

                count = template.update(const_insert_system_monitor_event_item, map, keyHolder);
                if (count > 0)
                {
                    Long skey = keyHolder.getKey().longValue();
                    item.setSensorMontiorEventItemSkey(skey);

                }



            }





        }

        return event;

    }


    @Override
    public SensorMonitorEventItem[] getLastNEvents(int limit) {
        SensorMonitorEventItem[] events = null;

        String sql = "select sensor_monitor_event_skey, sensor_monitor_event_item_skey, recordedDateTime, measurement\n" +
                "from sensor_monitor_event_item\n" +
                "where 1=1\n" +
                "  and sensor_monitor_event_skey in \n" +
                "  (\n" +
                "    select sensor_monitor_event_skey\n" +
                "    from sensor_monitor_event\n" +
                "    where 2=2\n" +
                "    order by create_ts desc \n" +
                "    limit :limit\n" +
                "  ) order by recordedDateTime";
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.dataSource);
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("limit", limit, Types.INTEGER);

        List<SensorMonitorEventItem> list = template.query(sql, map, this.getItemRowMapper() );

        SensorMonitorEventItem[] items = null;
        if (list != null && !list.isEmpty())
        {
            items = list.toArray(new SensorMonitorEventItem[list.size()]);
        }

        return items;
    }

    public RowMapper<SensorMonitorEventItem> getItemRowMapper()
    {
        return new RowMapper<SensorMonitorEventItem>() {
            @Override
            public SensorMonitorEventItem mapRow(ResultSet resultSet, int i) throws SQLException {
                SensorMonitorEventItem dto = new SensorMonitorEventItem();

                dto.setMeasurement(resultSet.getBigDecimal("measurement"));
                dto.setSensorMonitorEventSkey(resultSet.getLong("sensor_monitor_event_skey"));
                dto.setSensorMontiorEventItemSkey(resultSet.getLong("sensor_monitor_event_item_skey"));
                dto.setTimeStamp(resultSet.getTimestamp("recordedDateTime"));



                return dto;
            }
        };
    }


    public SensorMonitorEvent getSensorMonitorEvent(Long skey)
    {
        SensorMonitorEvent event = null;

        String sql = "select sensor_monitor_event_skey, start, stop, create_ts\n" +
                "from sensor_monitor_event\n" +
                "where 1=1\n" +
                "  and sensor_monitor_event_skey = :sensor_monitor_event_skey";
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.dataSource);
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("sensor_monitor_event_skey", skey, Types.INTEGER);

        List<SensorMonitorEvent> list = template.query(sql, map, this.getEventRowMapper() );

        if (list != null && !list.isEmpty())
        {
            event = list.get(0);
        }

        return event;
    }


    public RowMapper<SensorMonitorEvent> getEventRowMapper()
    {
        return new RowMapper<SensorMonitorEvent>() {
            @Override
            public SensorMonitorEvent mapRow(ResultSet resultSet, int i) throws SQLException {
                SensorMonitorEvent dto = new SensorMonitorEvent();
                dto.setCreationDate(resultSet.getTimestamp("create_ts"));
                dto.setSensorMonitorEventSkey(resultSet.getLong("sensor_monitor_event_skey"));
                dto.setStart(resultSet.getTimestamp("start"));
                dto.setStop(resultSet.getTimestamp("stop"));



                return dto;
            }
        };
    }


    @Override
    public SensorMonitorEvent getLastEvent() {
        return null;
    }
}
