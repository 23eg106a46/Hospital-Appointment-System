package com.haps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haps.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}