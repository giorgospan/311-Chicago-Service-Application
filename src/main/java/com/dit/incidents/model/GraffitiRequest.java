package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class GraffitiRequest{

	@Id
	private Long requestId;

	private Integer ssa;
    private String graffitiSurface;
    private String graffitiLocation;

	@OneToOne
	@MapsId
	@JoinColumn(name="request_id")
	private Request request;

}
