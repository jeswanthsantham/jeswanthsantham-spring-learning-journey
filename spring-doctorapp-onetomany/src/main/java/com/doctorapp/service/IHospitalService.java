package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import com.doctorapp.model.HospitalDetailsDto;
import com.doctorapp.model.HospitalDto;

public interface IHospitalService {

	void addHospital(HospitalDto hospitalDto);
	void updateHospital(HospitalDto hospitalDto);
	void deleteHospital(int hospitalId);
	HospitalDto getById(int hospitalId);
	List<HospitalDto> getAll();
	
	//derived query
	List<HospitalDto> getByCity(String city);
	List<HospitalDto> getBySpecialityType(String type);
	
	//custom query - 2 entities
	List<HospitalDto> getByDoctorSpeciality(String speciality);
	List<HospitalDto> getBySpecialityExp(String speciality, int experience);
	List<HospitalDto> getBySpecialityFees(String speciality, double fees);
	
	//custom query - 3 entities
	List<HospitalDto> getByDoctorLocation(String location);
	List<HospitalDto> getByDoctorAvailability( LocalTime availability);
	
	//projections
	List<HospitalDetailsDto> getAllHospitals();
	
}
