package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PersonalIdentity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private IdTypeEnum idType;
    private String publisher;
    private String publisherCountry;

}
