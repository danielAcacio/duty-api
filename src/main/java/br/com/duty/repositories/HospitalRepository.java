package br.com.duty.repositories;

import br.com.duty.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
