package com.kyd3snik.travel.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private boolean gender;
    private boolean hasInternationalPassport;
    private String city;
    private String password;
    private String confirmPassword;
}
