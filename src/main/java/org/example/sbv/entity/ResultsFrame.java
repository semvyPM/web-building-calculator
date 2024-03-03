package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "results_frame", schema = "public", catalog = "building_calculator") // catalog = "db"
public class ResultsFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "material_characteristics_id", nullable = false)
    private MaterialCharacteristics material_characteristics_id;
    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    private Float amount;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private Float price;
    @Basic
    @Column(name = "full_price", nullable = false, length = 100)
    private Float fullPrice;
    @ManyToOne
    @JoinColumn(name = "structural_element_frame_id", nullable = false)
    private StructuralElementFrame structuralElementFrameId;

    public ResultsFrame() {
    }

    public ResultsFrame(MaterialCharacteristics material_characteristics_id, Float amount, Float price, Float fullPrice, StructuralElementFrame structuralElementFrameId) {
        this.material_characteristics_id = material_characteristics_id;
        this.amount = amount;
        this.price = price;
        this.fullPrice = fullPrice;
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public ResultsFrame(Integer id, MaterialCharacteristics material_characteristics_id, Float amount, Float price, Float fullPrice, StructuralElementFrame structuralElementFrameId) {
        this.id = id;
        this.material_characteristics_id = material_characteristics_id;
        this.amount = amount;
        this.price = price;
        this.fullPrice = fullPrice;
        this.structuralElementFrameId = structuralElementFrameId;
    }
}
