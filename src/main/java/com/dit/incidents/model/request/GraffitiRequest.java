package com.dit.incidents.model.request;

import com.dit.incidents.external_request.request.ExternalGraffitiRequest;

import javax.persistence.*;

@Entity(name = "GRAFFITI_REQUEST")
public class GraffitiRequest {

	@Id
	@Column(name = "GRAFFITI_ID")
	private Long id;

	@Column(name = "SSA")
	private Integer ssa;

	@Column(name = "GRAFFITI_SURFACE")
    private String graffitiSurface;

	@Column(name = "GRAFFITI_LOCATION")
    private String graffitiLocation;

	@OneToOne
	@MapsId
	@JoinColumn(name="REQUEST_ID")
	private Request request;

	public GraffitiRequest() {
	}

	public GraffitiRequest(Long id, Integer ssa, String graffitiSurface, String graffitiLocation, Request request) {
		this.id = id;
		this.ssa = ssa;
		this.graffitiSurface = graffitiSurface;
		this.graffitiLocation = graffitiLocation;
		this.request = request;
	}

	public GraffitiRequest(Integer ssa, String graffitiSurface, String graffitiLocation, Request request) {
		this.ssa = ssa;
		this.graffitiSurface = graffitiSurface;
		this.graffitiLocation = graffitiLocation;
		this.request = request;
	}

	public GraffitiRequest(ExternalGraffitiRequest externalGraffitiRequest) {
		this.graffitiLocation = externalGraffitiRequest.getGraffitiLocation();
		this.graffitiSurface = externalGraffitiRequest.getGraffitiSurface();
		this.ssa = externalGraffitiRequest.getSsa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSsa() {
		return ssa;
	}

	public void setSsa(Integer ssa) {
		this.ssa = ssa;
	}

	public String getGraffitiSurface() {
		return graffitiSurface;
	}

	public void setGraffitiSurface(String graffitiSurface) {
		this.graffitiSurface = graffitiSurface;
	}

	public String getGraffitiLocation() {
		return graffitiLocation;
	}

	public void setGraffitiLocation(String graffitiLocation) {
		this.graffitiLocation = graffitiLocation;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
