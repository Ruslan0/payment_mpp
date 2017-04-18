package com.customer.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Gateway implements Serializable {

    private static final long serialVersionUID = -4449256781832949284L;

    @Getter
    @JsonProperty("gateway_type")
    private String type;

    @Getter
    @JsonProperty("retain_on_success")
    private boolean retainOnSuccess;
}
