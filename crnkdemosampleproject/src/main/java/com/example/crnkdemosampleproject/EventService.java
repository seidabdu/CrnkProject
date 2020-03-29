package com.example.crnkdemosampleproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventDao eventDao;

	public List<Event> getEvents() {
		return eventDao.getEvents();
	}

	public Event getEventByEventId(Long eventId) {
		return eventDao.findEventyEventId(eventId);
	}

	public int createEvent(Event event) {
		return eventDao.createEvent(event);
	}

}
