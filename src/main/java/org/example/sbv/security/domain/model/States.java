package org.example.sbv.security.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// изменено
@Getter
@Setter
@Entity
@Table(name = "state", schema = "public", catalog = "building_calculator") // catalog = "db"
public class States {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "state_name", nullable = false, length = 16)
    private String stateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public States(Integer id, String stateName) {
        this.id = id;
        this.stateName = stateName;
    }

    public States(String stateName) {
        this.stateName = stateName;
    }

    public States() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        States states = (States) o;

        if (id != null ? !id.equals(states.id) : states.id != null) return false;
        if (stateName != null ? !stateName.equals(states.stateName) : states.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        return result;
    }
}
