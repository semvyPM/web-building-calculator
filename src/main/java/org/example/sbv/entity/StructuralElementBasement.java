package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "structural_element_basement", schema = "public", catalog = "building_calculator") // catalog = "db"
public class StructuralElementBasement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "perimeter_of_external_walls", nullable = false, precision = 0)
    private Float perimeterOfExternalWalls;
    @Basic
    @Column(name = "internal_wall_length", nullable = false, precision = 0)
    private Float internalWallLength;
    @Basic
    @Column(name = "concrete_piles", nullable = false, length = 100)
    private String concretePiles;
    @Basic
    @Column(name = "concrete", nullable = false, length = 100)
    private String concrete;
    @ManyToOne
    @JoinColumn(name = "calculation_id", nullable = false)
    private Calculation calculationId;


    public StructuralElementBasement(Integer id, Float perimeterOfExternalWalls, Float internalWallLength, String concretePiles, String concrete, Calculation calculationId) {
        this.id = id;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.internalWallLength = internalWallLength;
        this.concretePiles = concretePiles;
        this.concrete = concrete;
        this.calculationId = calculationId;
    }

    public StructuralElementBasement(Float perimeterOfExternalWalls, Float internalWallLength, String concretePiles, String concrete, Calculation calculationId) {
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.internalWallLength = internalWallLength;
        this.concretePiles = concretePiles;
        this.concrete = concrete;
        this.calculationId = calculationId;
    }

    public StructuralElementBasement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuralElementBasement that = (StructuralElementBasement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (perimeterOfExternalWalls != null ? !perimeterOfExternalWalls.equals(that.perimeterOfExternalWalls) : that.perimeterOfExternalWalls != null)
            return false;
        if (internalWallLength != null ? !internalWallLength.equals(that.internalWallLength) : that.internalWallLength != null)
            return false;
        if (concretePiles != null ? !concretePiles.equals(that.concretePiles) : that.concretePiles != null)
            return false;
        if (concrete != null ? !concrete.equals(that.concrete) : that.concrete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (perimeterOfExternalWalls != null ? perimeterOfExternalWalls.hashCode() : 0);
        result = 31 * result + (internalWallLength != null ? internalWallLength.hashCode() : 0);
        result = 31 * result + (concretePiles != null ? concretePiles.hashCode() : 0);
        result = 31 * result + (concrete != null ? concrete.hashCode() : 0);
        return result;
    }
}
