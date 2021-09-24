package com.mea.ex.cs.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private String comment;

    private String email;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

}
