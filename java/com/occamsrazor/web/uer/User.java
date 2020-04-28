package com.occamsrazor.web.uer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	public String name, userId, password, ssn, addr;
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", name, userId, password, ssn, addr);
	}
}
