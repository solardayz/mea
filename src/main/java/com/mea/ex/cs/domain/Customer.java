package com.mea.ex.cs.domain;

import com.mea.ex.listener.Auditable;
import com.mea.ex.listener.BaseEntity;
import com.mea.ex.listener.CustomerEntityListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(value = {CustomerEntityListener.class})
public class Customer extends BaseEntity implements Auditable {

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

    //@Column(insertable = false)
    private LocalDateTime updateAt;

//    @PrePersist
//    public void prePersist(){
//        this.createAt = LocalDateTime.now();
//        this.updateAt = LocalDateTime.now();
//        System.out.println("====================> prePersist"+this.updateAt);     //가장 많이 씀
//    }
//
//    @PostPersist
//    public void postPersist(){
//        System.out.println("====================> postPersist");
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updateAt = LocalDateTime.now();
//        System.out.println("====================> PreUpdate"+this.updateAt);
//    }
//
//    @PreRemove
//    public void preRemove(){
//        System.out.println("====================> preRemove");
//    }
//
//    @PostRemove
//    public void postRemove(){
//        System.out.println("====================> postRemove");
//    }

//    @PrePersist
//    @PreUpdate
//    @PreRemove
//    @PostPersist
//    @PostRemove
//    @PostUpdate
//    @PostLoad

}
