package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransferRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tranferRequestId;
    private StatusEnum status;
    private LocalDate creationTimeStamp = LocalDate.now();
    @OneToOne
    private InternationalTransferInitiation transferInitiation;
    @OneToOne
    private Risk risk;


}
