package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AccountProfile implements Serializable {

    @Id
    @Size(min = 1, max = 40)
    private String accountId;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 40)
    private String accountCode;
    @NotEmpty(message = "Campo obrigatório")
    private ProductIdentifierEnum productIdentifier;
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;
    @Size(min = 1, max = 50)
    private String alias;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 10)
    private String productTypeCode;
    @Size(min = 1, max = 100)
    private String productTypeName;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 10)
    private String categoryCode;
    @Size(min = 1, max = 70)
    private String categoryName;
    @NotEmpty(message = "Campo obrigatório")
    private Boolean allowDebit;
    @NotEmpty(message = "Campo obrigatório")
    private Boolean allowCredit;
    @NotEmpty(message = "Campo obrigatório")
    private Boolean allowPayment;
    @NotEmpty(message = "Campo obrigatório")
    private Boolean allowPartialPayment;
    @NotEmpty(message = "Campo obrigatório")
    private Boolean allowQuery;

}
