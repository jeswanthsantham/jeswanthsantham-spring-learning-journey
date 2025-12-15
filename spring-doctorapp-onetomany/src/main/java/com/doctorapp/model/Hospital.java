package com.doctorapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(generator = "hospital_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hospital_gen",sequenceName = "hospital_seq",initialValue = 50,allocationSize = 1)
	private Integer hospitalId;
	
	@Column(length=30)
	private String hospitalName;
//	@Enumerated(EnumType.STRING)
	private String hospitalType;
	private String city;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="hospital_id")
	private Set<Doctor> doctors;
	

}
