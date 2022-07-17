package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.BalanceTypeEnum;
import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Balance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    @OneToMany

    private List<Amount> amounts;

    private CreditDebitIndicatorEnum creditDebitIndicator;

    @NotEmpty(message = "Campo obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @NotEmpty(message = "Campo obrigatório")
    private BalanceTypeEnum balanceType;

    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    private String creditLine;

}
