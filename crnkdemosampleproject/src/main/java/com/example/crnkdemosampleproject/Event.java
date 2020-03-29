package com.example.crnkdemosampleproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;

@JsonApiResource(type = "events")
public class Event {

	@JsonApiId
	private Long id;

	@JsonProperty
	private String eventName;

	@JsonProperty
	private String address;

	public Event() {

	}

	public Event(Long id, String name, String address) {
		this.id = id;
		this.eventName = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return eventName;
	}

	public void setName(String name) {
		this.eventName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
