package com.mea.ex.cs.domain;

import lombok.*;

import javax.persistence.*;
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

//    @Enumerated(EnumType.STRING)
    private Enum<Role> role;

    private String email;

    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column(insertable = false)
    private LocalDateTime updateAt;

}
