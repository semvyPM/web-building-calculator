package org.example.sbv.entity;

import jakarta.persistence.*;

import java.sql.Date;
// изменено
@Entity
@Table(name = "calculation", schema = "public", catalog = "building_calculator") // catalog = "db"
public class Calculation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;
    @Basic
    @Column(name = "address_object_constractions", nullable = false, length = 100)
    private String addressObjectConstractions;
    @Basic
    @Column(name = "number", nullable = false)
    private Integer number;
    @Basic
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "сalculation_state_id", nullable = false)
    private CalculationState сalculationStateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public String getAddressObjectConstractions() {
        return addressObjectConstractions;
    }

    public void setAddressObjectConstractions(String addressObjectConstractions) {
        this.addressObjectConstractions = addressObjectConstractions;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public CalculationState getСalculationStateId() {
        return сalculationStateId;
    }

    public void setСalculationStateId(CalculationState сalculationStateId) {
        this.сalculationStateId = сalculationStateId;
    }

    public Calculation() {
    }

    public Calculation(Customers customerId, String addressObjectConstractions, Integer number, Date createdDate, CalculationState сalculationStateId) {
        this.customerId = customerId;
        this.addressObjectConstractions = addressObjectConstractions;
        this.number = number;
        this.createdDate = createdDate;
        this.сalculationStateId = сalculationStateId;
    }

    public Calculation(Integer id, Customers customerId, String addressObjectConstractions, Integer number, Date createdDate, CalculationState сalculationStateId) {
        this.id = id;
        this.customerId = customerId;
        this.addressObjectConstractions = addressObjectConstractions;
        this.number = number;
        this.createdDate = createdDate;
        this.сalculationStateId = сalculationStateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculation that = (Calculation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (addressObjectConstractions != null ? !addressObjectConstractions.equals(that.addressObjectConstractions) : that.addressObjectConstractions != null)
            return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (сalculationStateId != null ? !сalculationStateId.equals(that.сalculationStateId) : that.сalculationStateId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (addressObjectConstractions != null ? addressObjectConstractions.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (сalculationStateId != null ? сalculationStateId.hashCode() : 0);
        return result;
    }
}
