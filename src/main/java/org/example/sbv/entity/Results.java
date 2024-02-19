package org.example.sbv.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results", schema = "public", catalog = "db")
public class Results {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "material_characteristics_id", nullable = false)
    private MaterialCharacteristics materialCharacteristicsId;
    @Basic
    @Column(name = "material", nullable = false, length = 100)
    private String material;
    @Basic
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private Float price;
    @Basic
    @Column(name = "measurement_unit", nullable = false, length = 30)
    private String measurementUnit;
    @Basic
    @Column(name = "full_price", nullable = false, precision = 0)
    private Float fullPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MaterialCharacteristics getMaterialCharacteristicsId() {
        return materialCharacteristicsId;
    }

    public void setMaterialCharacteristicsId(MaterialCharacteristics materialCharacteristicsId) {
        this.materialCharacteristicsId = materialCharacteristicsId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Results() {
    }

    public Results(MaterialCharacteristics materialCharacteristicsId, String material, Integer amount, Float price, String measurementUnit, Float fullPrice) {
        this.materialCharacteristicsId = materialCharacteristicsId;
        this.material = material;
        this.amount = amount;
        this.price = price;
        this.measurementUnit = measurementUnit;
        this.fullPrice = fullPrice;
    }

    public Results(Integer id, MaterialCharacteristics materialCharacteristicsId, String material, Integer amount, Float price, String measurementUnit, Float fullPrice) {
        this.id = id;
        this.materialCharacteristicsId = materialCharacteristicsId;
        this.material = material;
        this.amount = amount;
        this.price = price;
        this.measurementUnit = measurementUnit;
        this.fullPrice = fullPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results = (Results) o;

        if (id != null ? !id.equals(results.id) : results.id != null) return false;
        if (materialCharacteristicsId != null ? !materialCharacteristicsId.equals(results.materialCharacteristicsId) : results.materialCharacteristicsId != null)
            return false;
        if (material != null ? !material.equals(results.material) : results.material != null) return false;
        if (amount != null ? !amount.equals(results.amount) : results.amount != null) return false;
        if (price != null ? !price.equals(results.price) : results.price != null) return false;
        if (measurementUnit != null ? !measurementUnit.equals(results.measurementUnit) : results.measurementUnit != null)
            return false;
        if (fullPrice != null ? !fullPrice.equals(results.fullPrice) : results.fullPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialCharacteristicsId != null ? materialCharacteristicsId.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        result = 31 * result + (fullPrice != null ? fullPrice.hashCode() : 0);
        return result;
    }
}
