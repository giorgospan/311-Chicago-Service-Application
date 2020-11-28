package com.dit.incidents.model.request;

import javax.persistence.*;

@Entity(name = "LIGHTS_ALL_REQUEST")
public class LightsAllRequest {

	@Id
	@Column(name = "LIGHTS_ALL_ID")
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name="REQUEST_ID")
	private Request request;

	public LightsAllRequest() {
	}

	public LightsAllRequest(Long id, Request request) {
		this.id = id;
		this.request = request;
	}

	public LightsAllRequest(Request request) {
		this.request = request;
	}

	public Long getRequestId() {
		return id;
	}

	public void setRequestId(Long requestId) {
		this.id = requestId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
