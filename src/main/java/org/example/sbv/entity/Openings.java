package org.example.sbv.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "openings", schema = "public", catalog = "db")
public class Openings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "type", nullable = false, length = 100)
    private String type;
    @Basic
    @Column(name = "height", nullable = false, precision = 0)
    private Float height;
    @Basic
    @Column(name = "width", nullable = false, precision = 0)
    private Float width;
    @Basic
    @Column(name = "amount", nullable = false)
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Openings() {
    }

    public Openings(String type, Float height, Float width, Integer amount) {
        this.type = type;
        this.height = height;
        this.width = width;
        this.amount = amount;
    }

    public Openings(Integer id, String type, Float height, Float width, Integer amount) {
        this.id = id;
        this.type = type;
        this.height = height;
        this.width = width;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Openings openings = (Openings) o;

        if (id != null ? !id.equals(openings.id) : openings.id != null) return false;
        if (type != null ? !type.equals(openings.type) : openings.type != null) return false;
        if (height != null ? !height.equals(openings.height) : openings.height != null) return false;
        if (width != null ? !width.equals(openings.width) : openings.width != null) return false;
        if (amount != null ? !amount.equals(openings.amount) : openings.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
