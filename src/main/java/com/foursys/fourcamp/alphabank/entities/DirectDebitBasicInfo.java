package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectDebitBasicInfo implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    private String productName;
    private String directDebitId;
    private StatusEnum status;
}
