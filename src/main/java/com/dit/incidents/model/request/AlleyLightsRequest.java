package com.dit.incidents.model.request;

import javax.persistence.*;

@Entity
@Table(name = "ALLEY_LIGHTS_REQUEST")
public class AlleyLightsRequest {

	@Id
	@Column(name = "ALLEY_LIGHTS_ID")
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "REQUEST_ID")
	private Request request;

	public AlleyLightsRequest() {
	}

	public AlleyLightsRequest(Request request) {
		this.request = request;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
