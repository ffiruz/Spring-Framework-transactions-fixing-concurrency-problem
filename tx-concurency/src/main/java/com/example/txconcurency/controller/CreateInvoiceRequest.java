package com.example.txconcurency.controller;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateInvoiceRequest {

    private  String uuid;

    private Integer amount;
}
