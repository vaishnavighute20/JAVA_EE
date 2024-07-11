package com.blogs.repository;

import java.time.LocalDate;

import com.blogs.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespDTO extends BaseDTO {
 private String firstName;
 private String lastName;
 private LocalDate dob;
 private String phoneNo;
 

}
