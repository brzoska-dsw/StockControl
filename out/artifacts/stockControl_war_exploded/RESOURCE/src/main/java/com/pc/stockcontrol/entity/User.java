package com.pc.stockcontrol.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length=50, nullable=false, unique=true)
    private String name;

    @Column(length=50, nullable=false)
    private String surname;

    @Column(length=200, nullable=false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(length=50, nullable=false)
    private String role;
}
