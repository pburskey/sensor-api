insert into sensor_monitor_event(start, stop, create_ts) values(current_timestamp , current_timestamp , current_timestamp );
insert into sensor_monitor_event_item(sensor_monitor_event_skey, recordedDateTime, measurement) values(1, current_timestamp , 1.23)

