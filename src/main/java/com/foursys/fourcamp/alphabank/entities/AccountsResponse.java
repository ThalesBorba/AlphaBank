package com.foursys.fourcamp.alphabank.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountsResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private AccountProfile accountProfile;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private Servicer servicer;

    public AccountsResponse(Long id, AccountProfile accountProfile, Servicer servicer) {
        this.id = id;
        this.accountProfile = accountProfile;
        this.servicer = servicer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountsResponse that = (AccountsResponse) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
