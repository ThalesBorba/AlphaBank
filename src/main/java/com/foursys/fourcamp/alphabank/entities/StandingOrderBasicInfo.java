package com.foursys.fourcamp.alphabank.entities;

public class StandingOrderBasicInfo {

    private String standingOrderId;
    private String name;
    //todo relacionamento
    private String accountId;
    private Amount amount;
    private CreditorAccount creditorAccount;
}
