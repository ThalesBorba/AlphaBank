package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.util.GenerateCardNumber;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Entity
@Table(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number = generateNumber("VISA");
    private String customerCardName;
    private String password;
    private String expireDate;
    private String label;
    private Integer cvv;
    private boolean isActive = false;
    private String accountId;

    public String generateNumber(String label) {
        GenerateCardNumber.LABEL = GenerateCardNumber.Label.getLabel(label);
        String[] creditcardnumbers = GenerateCardNumber.generateCardNumbers();
        return this.number = creditcardnumbers[0];
    }
}
