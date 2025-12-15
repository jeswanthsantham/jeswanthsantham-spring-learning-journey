package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDetailsDto;
import com.doctorapp.model.HospitalDto;
import com.doctorapp.model.HospitalType;
import com.doctorapp.model.Speciality;
import com.doctorapp.repository.IHospitalRepository;
@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	private IHospitalRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public void addHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		repository.save(hospital);
	}

	@Override
	public void updateHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		repository.save(hospital);
	}

	@Override
	public void deleteHospital(int hospitalId) {
		repository.deleteById(hospitalId);

	}

	@Override
	public HospitalDto getById(int hospitalId) {
		Optional<Hospital> opt =  repository.findById(hospitalId);
		if(opt.isEmpty()) {
			throw new RuntimeException("invalid id");
		}
		Hospital hospital = opt.get();
		return mapper.map(hospital, HospitalDto.class);
	}

	@Override
	public List<HospitalDto> getAll() {
		List<Hospital> hospitals = repository.findAll();
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getByCity(String city) {
		List<Hospital> hospitals = repository.findByCity(city);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getBySpecialityType(String type) {
		List<Hospital> hospitals = repository.findByHospitalType(type);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getByDoctorSpeciality(String speciality) {
		List<Hospital> hospitals = repository.findByDoctorSpeciality(speciality);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getBySpecialityExp(String speciality, int experience) {
		List<Hospital> hospitals = repository.findBySpecialityExp(speciality, experience);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getBySpecialityFees(String speciality, double fees) {
		List<Hospital> hospitals = repository.findBySpecialityFees(speciality, fees);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getByDoctorLocation(String location) {
		List<Hospital> hospitals = repository.findByDoctorLocation(location);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDto> getByDoctorAvailability(LocalTime availability) {
		List<Hospital> hospitals = repository.findByDoctorAvailability(availability);
		return hospitals.stream()
					.map(hospital->mapper.map(hospital,HospitalDto.class))
					.toList();
	}

	@Override
	public List<HospitalDetailsDto> getAllHospitals() {
		List<HospitalDetailsDto> hospitals = repository.findAllHospitals();
		return hospitals;
	}

}
