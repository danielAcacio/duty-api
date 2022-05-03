package br.com.duty.repositories;

import br.com.duty.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
