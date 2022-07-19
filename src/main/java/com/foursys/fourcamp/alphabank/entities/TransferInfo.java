package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransferInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    private LocalDate dateSubmitted;
    private TransferScopeEnum transferScope;
    private OurShareEnum ourShare;
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private Amount instructedAmount;
    @NotEmpty(message = "Campo obrigatório")
    private String debtorAccount;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private CreditorAccount creditorAccount;
    private String debtorInformation;
    @OneToOne
    private RemittanceInformation remittanceInformation;

}
