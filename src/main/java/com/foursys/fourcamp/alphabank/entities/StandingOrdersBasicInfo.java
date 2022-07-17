package com.foursys.fourcamp.alphabank.entities;

import java.io.Serializable;
import java.util.List;

import com.foursys.fourcamp.alphabank.dto.StandingOrderBasicInfo;

import javax.persistence.OneToMany;

public class StandingOrdersBasicInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@OneToMany
	List<StandingOrderBasicInfo> standingOrderBasicInfos;
}
