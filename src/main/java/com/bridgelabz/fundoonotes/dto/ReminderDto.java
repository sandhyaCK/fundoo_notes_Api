package com.bridgelabz.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ReminderDto {

	private LocalDateTime remainder;

	public LocalDateTime getRemainder() {
		return remainder;
	}

	public void setRemainder(LocalDateTime remainder) {
		this.remainder = remainder;
	}
}
