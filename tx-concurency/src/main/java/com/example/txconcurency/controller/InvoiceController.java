package com.example.txconcurency.controller;

import com.example.txconcurency.service.InvoiceService;
import lombok.RequiredArgsConstructor;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvoiceController {


    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InvoiceController.class);

    private final InvoiceService invoiceService;

    @PostMapping("/invoice")
    public void upsert(@RequestBody CreateInvoiceRequest request)
    {
        log.info(request.getUuid()+"-"+request.getAmount());

        this.invoiceService.upsert(request);

    }
}
