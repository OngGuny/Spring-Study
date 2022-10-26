package kr.kwangan2.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommSearcher implements Serializable{
	private static final long serialVersionUID = 13234656L;

	int fkblogId;
	String searchKey;
	String searchValue;
}
