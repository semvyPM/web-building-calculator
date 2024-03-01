package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// изменено
@Getter
@Setter
@Entity
@Table(name = "state", schema = "public", catalog = "building_calculator") // catalog = "db"
public class State {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "state_name", nullable = false, length = 16)
    private String stateName;

    public State(Integer id, String stateName) {
        this.id = id;
        this.stateName = stateName;
    }

    public State(String stateName) {
        this.stateName = stateName;
    }

    public State() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (id != null ? !id.equals(state.id) : state.id != null) return false;
        if (stateName != null ? !stateName.equals(state.stateName) : state.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        return result;
    }
}
