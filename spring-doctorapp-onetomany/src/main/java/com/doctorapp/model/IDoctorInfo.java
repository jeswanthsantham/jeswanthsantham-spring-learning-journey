package com.doctorapp.model;

import java.time.LocalTime;
import java.util.List;

public interface IDoctorInfo {

	List<LocalTime> getAvailability();
}
