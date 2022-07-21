package com.foursys.fourcamp.alphabank.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_account")
@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private AccountProfile accountProfile;
    
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private Servicer servicer;

    public Account(Long id, AccountProfile accountProfile, Servicer servicer) {
        this.id = id;
        this.accountProfile = accountProfile;
        this.servicer = servicer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
