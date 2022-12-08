package com.techgeeknext.model;

import com.techgeeknext.enums.MaritalStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "excel")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    @Id
    String personal_nr;

    String firstName;
    String lastName;
    String bankName;
    String iban;
    String bic;
    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    BigInteger fixedTime;
    BigInteger projectHours;
    BigInteger kfz;
    BigInteger jGehaltsverzicht;
    BigInteger jSteuer;
    BigInteger tGehaltsverzicht;
    BigInteger ticket;
    BigInteger sales;
    BigInteger otherIndividual;
    BigInteger otherPremium;
    BigInteger travelCosts;
    BigInteger travelAward;
    BigInteger bav;
    BigInteger cfPerformance;
}
