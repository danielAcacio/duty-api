package br.com.duty.repositories;

import br.com.duty.models.Addres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Addres, Integer> {
}
