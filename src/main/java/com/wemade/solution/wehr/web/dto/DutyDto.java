package com.wemade.solution.wehr.web.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="wehr.DutyDto")
@DiscriminatorValue("1")
public class DutyDto extends CodeDto {

}
