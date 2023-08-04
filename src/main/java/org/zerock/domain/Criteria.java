package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	public Criteria() {//초기값
		this(1,10);
	}
	
	public Criteria(int pageNum , int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	
	
}
