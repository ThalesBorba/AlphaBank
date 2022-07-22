package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AccountProfile implements Serializable {

    @Id
    @Size(min = 1, max = 40)
    private String accountId;
    @Size(min = 1, max = 40)
    private String accountCode;
    private ProductIdentifierEnum productIdentifier;
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
