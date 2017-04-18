package com.customer.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class GatewayRequest implements Serializable {

    private static final long serialVersionUID = -1422960010381239807L;

    @Getter
    private Gateway gateway;
}