package com.app.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="railway")

public class Railway {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20,name="name")
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length=20,name="category")
	private Category category;
	

	//@JsonFormat(pattern="HH:mm")
	@Column(length=20,name="startTime")
	private LocalTime startTime;
	
//	@JsonFormat(pattern="HH:mm")
	@Column(length = 20,name="endTime")
	private LocalTime endTime;
	
	
	
	@Column(length=20,name="source")
	private String source;
	@Column(length=20,name="destination")
	private String destination;
	@Column(length=20,name="stationcode")
	private String stationCode;
	@Column(length=20,name="distance")
	private String distance;
	@Column(length=20,name="frequnecy")
	private String frequency;
	@Override
	public String toString() {
		return "Railway [id=" + id + ", name=" + name + ", category=" + category + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", source=" + source + ", destination=" + destination + ", stationCode="
				+ stationCode + ", distance=" + distance + ", frequency=" + frequency + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Railway(Long id, String name, Category category, LocalTime startTime, LocalTime endTime, String source,
			String destination, String stationCode, String distance, String frequency) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
		this.source = source;
		this.destination = destination;
		this.stationCode = stationCode;
		this.distance = distance;
		this.frequency = frequency;
	}
	public Railway() {
		super();
	}

	
	
	

}
