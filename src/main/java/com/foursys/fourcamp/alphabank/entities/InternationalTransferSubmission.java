package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InternationalTransferSubmission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferRequestId;

    @OneToMany
    private List<Risk> risks = new ArrayList<>();

    @OneToMany
    private List<InternationalTransferInitiation> internationalTransferInitiation = new ArrayList<>();

}
