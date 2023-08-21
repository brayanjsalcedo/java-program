package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.Ticket;
import com.example.java.epam.brayan.data.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketUserRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findByUser(User user, Pageable pageable);
}