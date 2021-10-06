package com.mea.ex.cs.domain;

import com.mea.ex.listener.Auditable;
import com.mea.ex.listener.BaseEntity;
import com.mea.ex.listener.CustomerEntityListener;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
//@EntityListeners(value = CustomerEntityListener.class)
public class CustomerHistory extends BaseEntity implements Auditable {
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
