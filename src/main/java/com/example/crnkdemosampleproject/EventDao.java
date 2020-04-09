package com.example.crnkdemosampleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_STATEMENT = "select * from event";

	public List<Event> getEvents() {

		List<Event> events = new ArrayList<Event>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_STATEMENT);

		for (Map<String, Object> row : rows) {
			Event event = new Event();
			int eventId = (int) row.get("eventId");
			event.setId(Long.valueOf(eventId));
			event.setEventName((String) row.get("eventName"));
			event.setAddress((String) row.get("address"));

			events.add(event);
		}

		return events;
	}

	public Event findEventyEventId(Long eventId) {
		return jdbcTemplate.queryForObject("select * from event where eventId=?", new Object[] { eventId },
				new EventMapper());
	}

	public int createEvent(Event event) {
		return jdbcTemplate.update("insert into event (eventName,address) values(?,?)", event.getEventName(),
				event.getAddress());
	}

	public int deleteEventById(Long eventId) {
		return jdbcTemplate.update("delete from event where eventId=?", eventId);
	}

}
