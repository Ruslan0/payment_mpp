package com.customer.payment.model;

public class GatewayRequest
{
    private String gateway_type;

    public String getGateway_type ()
    {
        return gateway_type;
    }

    public void setGateway_type (String gateway_type)
    {
        this.gateway_type = gateway_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gateway_type = "+gateway_type+"]";
    }
}