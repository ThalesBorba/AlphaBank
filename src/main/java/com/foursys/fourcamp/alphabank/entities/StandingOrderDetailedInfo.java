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
    private String accountId;
    private StatusEnum status;
    private Date dateCreated;
    private Date dateStart;
    private Date dateStop;
    @OneToOne
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private CreditorAccount creditorAccount;
    private String creditorReason;
    @OneToOne
    private ExecutionPlan executionPlan;
    @OneToOne
    private OrderExecution previousExecution;
    @OneToOne
    private OrderExecution nextExecution;
}
