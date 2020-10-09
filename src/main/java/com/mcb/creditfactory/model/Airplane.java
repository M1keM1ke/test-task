package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "AIRPLANE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String brand;
    private String model;
    private String manufacturer;
    @Column(name = "year_of_issue")
    private Short year;
    @Column(name = "fuelcapacity")
    private Integer fuel;
    private Integer seats;
    private BigDecimal value;

    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Valuation> valuations;
}
