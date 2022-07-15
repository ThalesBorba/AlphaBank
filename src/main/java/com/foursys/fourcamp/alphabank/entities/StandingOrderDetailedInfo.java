package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandingOrderDetailedInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String standingOrderId;

    @NotEmpty(message = "Campo obrigatório")
    private String name;
    //todo relacionamento
    private String accountId;
    private StatusEnum status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStop;
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditorAccount creditorAccount;
    private String creditorReason;
    private ExecutionPlan executionPlan;
    private OrderExecution previousExecution;
    private OrderExecution nextExecution;
}
