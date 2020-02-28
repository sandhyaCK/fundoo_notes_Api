package com.bridgelabz.fundoonotes.dto;

/*
 *  author : Sandhya
 */

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
/*Dto class for adding reminder*/
public class ReminderDto {

	private LocalDateTime remainder;

	public LocalDateTime getRemainder() {
		return remainder;
	}

	public void setRemainder(LocalDateTime remainder) {
		this.remainder = remainder;
	}
}
