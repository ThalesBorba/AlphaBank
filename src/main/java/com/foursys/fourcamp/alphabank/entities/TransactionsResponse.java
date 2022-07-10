package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class TransactionsResponse implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    List<Transaction> transactions;
}
