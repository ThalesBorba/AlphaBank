package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class    AccountBalance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    @NotEmpty(message = "Campo obrigatório")
    @ManyToMany

    @JoinTable(name = "balances",
                joinColumns = @JoinColumn(name = "accountbalance_id"),
                inverseJoinColumns = @JoinColumn(name = "balances_id"))
    private List<BalancesResponse> balances;
}
