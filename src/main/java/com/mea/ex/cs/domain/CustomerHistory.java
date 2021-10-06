package com.mea.ex.cs.domain;

import com.mea.ex.listener.CustomerEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(value = CustomerEntityListener.class)
public class CustomerHistory {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private String comment;

    //    @Enumerated(EnumType.STRING)
    private Enum<Role> role;

    private String email;
}
