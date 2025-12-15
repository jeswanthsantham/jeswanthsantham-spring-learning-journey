package com.doctorapp.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.DoctorDetailsDto;
import com.doctorapp.model.IDoctorInfo;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query("""
			FROM Doctor d JOIN d.availability a where 
			d.speciality = ?1 and a =?2
			""")
	List<Doctor> findAllDoctors(String speciality, LocalTime availabilty);

	List<Doctor> findBySpeciality(String speciality);
	
	//projection
	@Query("""
			select d.availability as availability from Doctor d
			 where d.doctorName=?1 
			"""
			)
	List<IDoctorInfo> findByAvailability(String doctorname);
	
	//projection
	List<DoctorDetailsDto> findBySpecialityAndExperienceGreaterThan(String speciality, int experience);	
}
