package com.example.crnkdemosampleproject;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EventMapper implements RowMapper<Event> {
	@Override
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event event = new Event();
		event.setId(Long.valueOf(rs.getInt("id")));
		event.setName(rs.getString("eventName"));
		event.setAddress(rs.getString("address"));
		return event;
	}
}
