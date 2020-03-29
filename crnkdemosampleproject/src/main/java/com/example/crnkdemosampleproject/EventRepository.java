package com.example.crnkdemosampleproject;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class EventRepository extends ResourceRepositoryBase<Event, Long> {

	@Autowired
	private EventService eventService;

	private static final AtomicLong ID_GENERATOR = new AtomicLong(3);

	public EventRepository() {
		super(Event.class);

	}

	@Override
	public synchronized void delete(Long id) {
//		events.remove(id);
	}

	@Override
	public synchronized <S extends Event> S save(S event) {
		if (event.getId() == null) {
			event.setId(ID_GENERATOR.getAndIncrement());
		}
//		events.put(event.getId(), event);
		eventService.createEvent(event);

		return event;
	}

	@Override
	public synchronized ResourceList<Event> findAll(QuerySpec querySpec) {
//		return querySpec.apply(events.values());

		return querySpec.apply(eventService.getEvents());
	}
}