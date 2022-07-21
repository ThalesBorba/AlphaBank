package com.foursys.fourcamp.alphabank.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Akps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String name;

    private String city;

    private String andress;
    @Length(max = 6)
    private String zipCode;

    private Boolean isInBranch;

    private Double lat;

    private Double lon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Akps akps = (Akps) o;
        return id != null && Objects.equals(id, akps.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
