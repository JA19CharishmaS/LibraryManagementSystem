package com.hexaware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
