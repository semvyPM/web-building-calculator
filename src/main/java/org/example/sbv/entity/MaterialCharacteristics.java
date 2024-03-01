package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "material_characteristics", schema = "public", catalog = "building_calculator") // catalog = "db"
public class MaterialCharacteristics {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @ManyToOne
    @JoinColumn(name = "materials_id", nullable = false)
    private Materials materialsId;
    @ManyToOne
    @JoinColumn(name = "measurement_unit_id", nullable = false)
    private MeasurementUnits measurementUnitId;
    @Basic
    @Column(name = "length", precision = 0)
    private Float length;
    @Basic
    @Column(name = "wedth", precision = 0)
    private Float wedth;
    @Basic
    @Column(name = "thickness", precision = 0)
    private Float thickness;
    @Column(name = "volume", precision = 0)
    private Float volume;

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

    public Materials getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Materials materialsId) {
        this.materialsId = materialsId;
    }

    public MeasurementUnits getMeasurementUnitId() {
        return measurementUnitId;
    }

    public void setMeasurementUnitId(MeasurementUnits measurementUnitId) {
        this.measurementUnitId = measurementUnitId;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWedth() {
        return wedth;
    }

    public void setWedth(Float wedth) {
        this.wedth = wedth;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public MaterialCharacteristics() {
    }

    public MaterialCharacteristics(String name, Materials materialsId, MeasurementUnits measurementUnitId, Float length, Float wedth, Float thickness, Float volume) {
        this.name = name;
        this.materialsId = materialsId;
        this.measurementUnitId = measurementUnitId;
        this.length = length;
        this.wedth = wedth;
        this.thickness = thickness;
        this.volume = volume;
    }

    public MaterialCharacteristics(Integer id, String name, Materials materialsId, MeasurementUnits measurementUnitId, Float length, Float wedth, Float thickness, Float volume) {
        this.id = id;
        this.name = name;
        this.materialsId = materialsId;
        this.measurementUnitId = measurementUnitId;
        this.length = length;
        this.wedth = wedth;
        this.thickness = thickness;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialCharacteristics that = (MaterialCharacteristics) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (materialsId != null ? !materialsId.equals(that.materialsId) : that.materialsId != null) return false;
        if (measurementUnitId != null ? !measurementUnitId.equals(that.measurementUnitId) : that.measurementUnitId != null)
            return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (wedth != null ? !wedth.equals(that.wedth) : that.wedth != null) return false;
        if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (materialsId != null ? materialsId.hashCode() : 0);
        result = 31 * result + (measurementUnitId != null ? measurementUnitId.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (wedth != null ? wedth.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        return result;
    }
}
