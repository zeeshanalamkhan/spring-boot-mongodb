package com.zeeshan.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookError {

	private Integer errCode;
	private String desc;
	private Date date;

}
