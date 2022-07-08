package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountProfile {

    @Size(min = 1, max = 40)
    private String accountId;
    @Size(min = 1, max = 40)
    private String accountCode;
    private ProductIdentifierEnum productIdentifier;
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;
    @Size(min = 1, max = 50)
    private String alias;
    @Size(min = 1, max = 10)
    private String productTypeCode;
    @Size(min = 1, max = 100)
    private String productTypeName;
    @Size(min = 1, max = 10)
    private String categoryCode;
    @Size(min = 1, max = 70)
    private String categoryName;
    private Boolean allowDebit;
    private Boolean allowCredit;
    private Boolean allowPayment;
    private Boolean allowPartialPayment;
    private Boolean allowQuery;

}
