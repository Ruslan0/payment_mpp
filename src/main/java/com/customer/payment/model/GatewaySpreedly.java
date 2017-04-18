package com.customer.payment.model;

public class GatewaySpreedly <Gate>
{
    private Gate gateway;

    public Gate getGateway ()
    {
        return gateway;
    }

    public void setGateway (Gate gateway)
    {
        this.gateway = gateway;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gateway = "+gateway+"]";
    }
}