package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DirectDebitDetailedInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String directDebitId;
    
    private String name;
    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    private String productType;
    private String productName;
    private StatusEnum status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "amount_id")
    private Amount amount;
}
