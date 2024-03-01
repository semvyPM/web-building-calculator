package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "openings_in_a_structural_element_frame", schema = "public", catalog = "building_calculator") // catalog = "db"
public class OpeningsInAStructuralElementFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "structural_element_frame_id", nullable = false)
    private StructuralElementFrame structuralElementFrameId;
    @ManyToOne
    @JoinColumn(name = "openings_id", nullable = false)
    private Openings openingsId;
    @Basic
    @Column(name = "amount", nullable = false)
    private Integer amount;

    public OpeningsInAStructuralElementFrame() {
    }

    public OpeningsInAStructuralElementFrame(StructuralElementFrame structuralElementFrameId, Openings openingsId, Integer amount) {
        this.structuralElementFrameId = structuralElementFrameId;
        this.openingsId = openingsId;
        this.amount = amount;
    }

    public OpeningsInAStructuralElementFrame(Integer id, StructuralElementFrame structuralElementFrameId, Openings openingsId, Integer amount) {
        this.id = id;
        this.structuralElementFrameId = structuralElementFrameId;
        this.openingsId = openingsId;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpeningsInAStructuralElementFrame that = (OpeningsInAStructuralElementFrame) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (structuralElementFrameId != null ? !structuralElementFrameId.equals(that.structuralElementFrameId) : that.structuralElementFrameId != null)
            return false;
        if (openingsId != null ? !openingsId.equals(that.openingsId) : that.openingsId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (structuralElementFrameId != null ? structuralElementFrameId.hashCode() : 0);
        result = 31 * result + (openingsId != null ? openingsId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
