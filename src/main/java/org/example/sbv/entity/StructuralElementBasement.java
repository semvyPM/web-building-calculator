package org.example.sbv.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "structuralElementBasement", schema = "public", catalog = "db")
public class StructuralElementBasement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "results_id", nullable = false)
    private Results resultsId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Results getResultsId() {
        return resultsId;
    }

    public void setResultsId(Results resultsId) {
        this.resultsId = resultsId;
    }

    public Float getPerimeterOfExternalWalls() {
        return perimeterOfExternalWalls;
    }

    public void setPerimeterOfExternalWalls(Float perimeterOfExternalWalls) {
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
    }

    public Float getInternalWallLength() {
        return internalWallLength;
    }

    public void setInternalWallLength(Float internalWallLength) {
        this.internalWallLength = internalWallLength;
    }

    public String getConcretePiles() {
        return concretePiles;
    }

    public void setConcretePiles(String concretePiles) {
        this.concretePiles = concretePiles;
    }

    public String getConcrete() {
        return concrete;
    }

    public void setConcrete(String concrete) {
        this.concrete = concrete;
    }

    public StructuralElementBasement(Integer id, Results resultsId, Float perimeterOfExternalWalls, Float internalWallLength, String concretePiles, String concrete) {
        this.id = id;
        this.resultsId = resultsId;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.internalWallLength = internalWallLength;
        this.concretePiles = concretePiles;
        this.concrete = concrete;
    }

    public StructuralElementBasement(Results resultsId, Float perimeterOfExternalWalls, Float internalWallLength, String concretePiles, String concrete) {
        this.resultsId = resultsId;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.internalWallLength = internalWallLength;
        this.concretePiles = concretePiles;
        this.concrete = concrete;
    }

    public StructuralElementBasement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuralElementBasement that = (StructuralElementBasement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resultsId != null ? !resultsId.equals(that.resultsId) : that.resultsId != null) return false;
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
        result = 31 * result + (resultsId != null ? resultsId.hashCode() : 0);
        result = 31 * result + (perimeterOfExternalWalls != null ? perimeterOfExternalWalls.hashCode() : 0);
        result = 31 * result + (internalWallLength != null ? internalWallLength.hashCode() : 0);
        result = 31 * result + (concretePiles != null ? concretePiles.hashCode() : 0);
        result = 31 * result + (concrete != null ? concrete.hashCode() : 0);
        return result;
    }
}
