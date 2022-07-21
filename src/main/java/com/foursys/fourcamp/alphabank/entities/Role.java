package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameRole;

    @ManyToMany(mappedBy ="roles" , fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Role(String nameRole){
        this.nameRole = nameRole;
    }

    @Override
    public String getAuthority() {
        return nameRole;
    }

}
