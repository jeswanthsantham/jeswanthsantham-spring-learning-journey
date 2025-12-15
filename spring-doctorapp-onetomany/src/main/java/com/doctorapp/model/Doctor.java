package com.doctorapp.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "doctor_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "doctor_gen",sequenceName = "doctor_seq",initialValue = 1,allocationSize = 1)
	private Integer doctorId;
	@Column(name="doctorname", length=20)
	private String doctorName;
	
	@Column(unique = true)
	private String email;
	private double fees;
	private int experience;
	private String speciality;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "doc_availability",
	                 joinColumns = @JoinColumn(name="doctor_id"))
	private List<LocalTime> availability;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "address_id")
	private Address address;
	
	
	
	
	

}
