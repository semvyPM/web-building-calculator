package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "materials", schema = "public", catalog = "building_calculator") // catalog = "db"
public class Materials {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "material_type", nullable = false, length = 100)
    private String materialType;
    @Basic
    @Column(name = "structural_element_type", nullable = false, length = 100)
    private String structuralElementType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getStructuralElementType() {
        return structuralElementType;
    }

    public void setStructuralElementType(String structuralElementType) {
        this.structuralElementType = structuralElementType;
    }

    public Materials() {
    }

    public Materials(String name, String materialType, String structuralElementType) {
        this.name = name;
        this.materialType = materialType;
        this.structuralElementType = structuralElementType;
    }

    public Materials(Integer id, String name, String materialType, String structuralElementType) {
        this.id = id;
        this.name = name;
        this.materialType = materialType;
        this.structuralElementType = structuralElementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materials materials = (Materials) o;

        if (id != null ? !id.equals(materials.id) : materials.id != null) return false;
        if (name != null ? !name.equals(materials.name) : materials.name != null) return false;
        if (materialType != null ? !materialType.equals(materials.materialType) : materials.materialType != null)
            return false;
        if (structuralElementType != null ? !structuralElementType.equals(materials.structuralElementType) : materials.structuralElementType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (materialType != null ? materialType.hashCode() : 0);
        result = 31 * result + (structuralElementType != null ? structuralElementType.hashCode() : 0);
        return result;
    }
}
