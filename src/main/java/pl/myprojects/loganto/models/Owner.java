package pl.myprojects.loganto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    @OneToOne
    private Address address;

    @ManyToMany
    private Set<Apartment> apartments;
}
