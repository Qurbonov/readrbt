package uz.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class PROPERTIES {
	private int numb;
	private String prop_name;
	private int val_numb;
	private String val_name;
}