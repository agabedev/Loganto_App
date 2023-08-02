package pl.myprojects.loganto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;

    @OneToOne
    private Account account;

    @ManyToMany
    private Set<Owner> owners;

    private Double apartmentAreaInSquareMeters;

    private Double commonPropertyArea;

    private Integer tenantsNumber;


}
