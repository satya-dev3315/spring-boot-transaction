package com.aitt.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passenger_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private Integer passengerId;
	
	private String name;
	private String email;
	private String source;
	private String destination;
	private Double fare;
	
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "travel_date")  //in request we need to pass date as string value instead of date along with my given pattern
	private LocalDate travelDate;

}
