package com.doctorapp.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDetailsDto;
import com.doctorapp.model.HospitalDto;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer>{

	List<Hospital> findByCity(String city);
	List<Hospital> findByHospitalType(String type);
	
	@Query("from Hospital h inner join h.doctors d where d.speciality=?1")
	List<Hospital> findByDoctorSpeciality(String speciality);
	
	@Query("from Hospital h inner join h.doctors d where d.speciality=?1 and d.experience>?2")
	List<Hospital> findBySpecialityExp(String speciality, int experience);
	@Query("""
			from Hospital h inner join h.doctors d where d.speciality=?1
			and d.fees<?2
			""")
	List<Hospital> findBySpecialityFees(String speciality, double fees);
	// 3 entities
	@Query("""
			from Hospital h  
			join h.doctors d 
			join d.address a 
			where a.location=?1
			""")
	List<Hospital> findByDoctorLocation(String location);

	@Query("""
			from Hospital h 
			join h.doctors d 
			join d.availability a
			where  a=?1
			""")
	List<Hospital> findByDoctorAvailability( LocalTime availability);
	
	//projection
	@Query("""
			select new com.doctorapp.model.HospitalDetailsDto(h.hospitalName,h.city,h.hospitalType)
			from Hospital h 
			""")
	List<HospitalDetailsDto> findAllHospitals();
	
	
	
}
