package com.app.dto;

import java.time.LocalTime;

import com.app.entity.Category;

public class RailwayDTO {
	private String name;
	private Category category;
	private LocalTime startTime;
	private LocalTime endTime;
	private String frequency;
	
	@Override
	public String toString() {
		return "RailwayDTO [name=" + name + ", category=" + category + ", startTime=" + startTime + ", endTime="
				+ endTime + ", frequency=" + frequency + "]";
	}

	public RailwayDTO(String name, Category category, LocalTime startTime, LocalTime endTime, String frequency) {
		super();
		this.name = name;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
	}

	public RailwayDTO() {
		super();
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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	
	
	
}
