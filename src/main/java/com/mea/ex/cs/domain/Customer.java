package com.mea.ex.cs.domain;

import com.mea.ex.listener.BaseEntity;
import com.mea.ex.listener.CustomerEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(value = {CustomerEntityListener.class})
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long id;

    @NonNull
    private String name;

    private String comment;

    @Enumerated(EnumType.STRING)
    private CustomerRole role;

    private String email;

    @OneToMany
//    @ToString.Exclude
    @JoinColumn(name = "customerId",insertable = false,updatable = false)
    private List<CustomerHistory> customerHistoryList = new ArrayList<>();

//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    //@Column(insertable = false)
//    private LocalDateTime updatedAt;

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
