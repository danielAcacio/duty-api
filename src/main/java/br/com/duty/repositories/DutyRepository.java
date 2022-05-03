package br.com.duty.repositories;

import br.com.duty.models.Duty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutyRepository extends JpaRepository<Duty, Integer> {
}
