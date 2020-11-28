package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class LightsAllRequest{

	@Id
	private Long requestId;


	@OneToOne
	@MapsId
	@JoinColumn(name="request_id")
	private Request request;

}
