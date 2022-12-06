package com.techgeeknext.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

	@Id
	int personal_nr;

	String email;
	String firstName;
	String lastName;
	String roles;
	String team;
	String chief;
	LocalDateTime creationTime;
	LocalDateTime modification_time;
	LocalDateTime closeTime;
	int target_working_hours;
	String career_stage;
	int vacation_days;
	int min_bonus_limit_percent;
	int overtime_percent;
	int overtime_leftover;
}
