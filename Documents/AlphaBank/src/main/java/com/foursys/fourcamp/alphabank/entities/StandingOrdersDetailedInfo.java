package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

public class StandingOrdersDetailedInfo implements Serializable {
    @OneToMany
    List<StandingOrderDetailedInfo> standingOrderDetailedInfos;
}
