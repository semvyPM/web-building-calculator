package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// изменено
@Setter
@Getter
@Entity
@Table(name = "calculation_state", schema = "public", catalog = "building_calculator") // catalog = "db"
public class CalculationState {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "title", nullable = false, length = 16)
    private String stateName;

    public CalculationState() {
    }

    public CalculationState(String stateName) {
        this.stateName = stateName;
    }

    public CalculationState(Integer id, String stateName) {
        this.id = id;
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculationState that = (CalculationState) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stateName != null ? !stateName.equals(that.stateName) : that.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        return result;
    }
}
