package com.example.txconcurency.repository;

import com.example.txconcurency.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {


    Optional<Invoice> findInvoiceByUuid(String uuid);

}
