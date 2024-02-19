package org.example.sbv.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "priceLists", schema = "public", catalog = "db")
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public PriceLists() {
    }

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
