package com.example.txconcurency.service;


import com.example.txconcurency.controller.CreateInvoiceRequest;
import com.example.txconcurency.entity.Invoice;
import com.example.txconcurency.repository.InvoiceRepository;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void upsert(CreateInvoiceRequest request) {
        Invoice invoice = this.invoiceRepository.findInvoiceByUuid(request.getUuid())
                .orElseGet(()->Invoice.builder().amount(request.getAmount()).uuid(request.getUuid()).build());
        this.invoiceRepository.save(invoice);
    }
}