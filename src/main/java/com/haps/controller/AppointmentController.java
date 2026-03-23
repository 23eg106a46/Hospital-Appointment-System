package com.haps.controller;

import com.haps.entity.Appointment;
import com.haps.entity.Patient;
import com.haps.repository.AppointmentRepository;
import com.haps.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Create appointment for a patient
    @PostMapping("/{patientId}")
    public Appointment createAppointment(@PathVariable Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setAppointmentTime(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // Get priority appointments (sorted by severityLevel DESC)
    @GetMapping("/priority")
    public List<Appointment> getPriorityAppointments() {

        return appointmentRepository
                .findAll()
                .stream()
                .sorted((a1, a2) ->
                        Integer.compare(
                                a2.getPatient().getSeverityLevel(),
                                a1.getPatient().getSeverityLevel()
                        )
                )
                .toList();
    }
}