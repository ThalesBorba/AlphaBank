package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.util.GenerateCardNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number = generateNumber("VISA");
    private String customerCardName;
    private String password;
    private Date expireDate;
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
