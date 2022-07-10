package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.IdTypeEnum;

import java.io.Serializable;

public class PersonalIdentity implements Serializable {

    private String id;
    private IdTypeEnum idType;
    private String publisher;
    private String publisherCountry;

}
