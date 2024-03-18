package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
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
    private CalculationState calculationStateId;

    public Calculation() {
    }

    public Calculation(Customers customerId, String addressObjectConstractions, Integer number, Date createdDate, CalculationState calculationStateId) {
        this.customerId = customerId;
        this.addressObjectConstractions = addressObjectConstractions;
        this.number = number;
        this.createdDate = createdDate;
        this.calculationStateId = calculationStateId;
    }

    public Calculation(Integer id, Customers customerId, String addressObjectConstractions, Integer number, Date createdDate, CalculationState calculationStateId) {
        this.id = id;
        this.customerId = customerId;
        this.addressObjectConstractions = addressObjectConstractions;
        this.number = number;
        this.createdDate = createdDate;
        this.calculationStateId = calculationStateId;
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
        if (calculationStateId != null ? !calculationStateId.equals(that.calculationStateId) : that.calculationStateId != null)
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
        result = 31 * result + (calculationStateId != null ? calculationStateId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "customerId=" + customerId +
                ", addressObjectConstractions='" + addressObjectConstractions + '\'' +
                ", number=" + number +
                ", createdDate=" + createdDate +
                ", calculationStateId=" + calculationStateId +
                '}';
    }
}
