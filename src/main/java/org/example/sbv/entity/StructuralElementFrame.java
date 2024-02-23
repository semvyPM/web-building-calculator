package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "structuralElementFrame", schema = "public", catalog = "building_calculator") // catalog = "db"
public class StructuralElementFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "amount_floor", nullable = false)
    private Integer amountFloor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAmountFloor() {
        return amountFloor;
    }

    public void setAmountFloor(Integer amountFloor) {
        this.amountFloor = amountFloor;
    }

    public StructuralElementFrame(Integer id, Integer amountFloor) {
        this.id = id;
        this.amountFloor = amountFloor;
    }

    public StructuralElementFrame(Integer amountFloor) {
        this.amountFloor = amountFloor;
    }

    public StructuralElementFrame() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuralElementFrame that = (StructuralElementFrame) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amountFloor != null ? !amountFloor.equals(that.amountFloor) : that.amountFloor != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amountFloor != null ? amountFloor.hashCode() : 0);
        return result;
    }
}
