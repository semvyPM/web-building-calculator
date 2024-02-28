package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
@Getter
@Setter
@Entity
@Table(name = "price_lists", schema = "public", catalog = "building_calculator") // catalog = "db"
public class PriceLists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "material_characteristics_id", nullable = false)
    private MaterialCharacteristics materialCharacteristicsId;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "purchase_price", nullable = false, precision = 2)
    private BigDecimal purchasePrice;
    @Basic
    @Column(name = "selling_price", nullable = false, precision = 2)
    private BigDecimal sellingPrice;

    public PriceLists(MaterialCharacteristics materialCharacteristicsId, Date date, BigDecimal purchasePrice, BigDecimal sellingPrice) {
        this.materialCharacteristicsId = materialCharacteristicsId;
        this.date = date;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public PriceLists(Integer id, MaterialCharacteristics materialCharacteristicsId, Date date, BigDecimal purchasePrice, BigDecimal sellingPrice) {
        this.id = id;
        this.materialCharacteristicsId = materialCharacteristicsId;
        this.date = date;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceLists that = (PriceLists) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialCharacteristicsId != null ? !materialCharacteristicsId.equals(that.materialCharacteristicsId) : that.materialCharacteristicsId != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (purchasePrice != null ? !purchasePrice.equals(that.purchasePrice) : that.purchasePrice != null)
            return false;
        if (sellingPrice != null ? !sellingPrice.equals(that.sellingPrice) : that.sellingPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialCharacteristicsId != null ? materialCharacteristicsId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
        result = 31 * result + (sellingPrice != null ? sellingPrice.hashCode() : 0);
        return result;
    }
}
