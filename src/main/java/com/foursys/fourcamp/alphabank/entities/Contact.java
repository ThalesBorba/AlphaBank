package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ContactTypeEnum;

import java.io.Serializable;

public class Contact implements Serializable {

    private ContactTypeEnum contactType;
    private String contactValue;
}
