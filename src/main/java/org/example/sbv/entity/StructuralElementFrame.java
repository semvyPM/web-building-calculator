package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "structural_element_frame", schema = "public", catalog = "building_calculator") // catalog = "db"
public class StructuralElementFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "amount_floor", nullable = false)
    private Integer amountFloor;
    @ManyToOne
    @JoinColumn(name = "calculation_id", nullable = false)
    private Calculation calculationId;


    public StructuralElementFrame(Integer id, Integer amountFloor, Calculation calculationId) {
        this.id = id;
        this.amountFloor = amountFloor;
        this.calculationId = calculationId;
    }

    public StructuralElementFrame(Integer amountFloor, Calculation calculationId) {
        this.amountFloor = amountFloor;
        this.calculationId = calculationId;
    }

    public StructuralElementFrame() {
    }


}
