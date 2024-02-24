package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "measurement_units", schema = "public", catalog = "building_calculator") // catalog = "db"
public class MeasurementUnits {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "measurement_units_name", nullable = false, length = 20)
    private String measurementUnitsName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasurementUnitsName() {
        return measurementUnitsName;
    }

    public void setMeasurementUnitsName(String measurementUnitsName) {
        this.measurementUnitsName = measurementUnitsName;
    }

    public MeasurementUnits() {
    }

    public MeasurementUnits(String measurementUnitsName) {
        this.measurementUnitsName = measurementUnitsName;
    }

    public MeasurementUnits(Integer id, String measurementUnitsName) {
        this.id = id;
        this.measurementUnitsName = measurementUnitsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementUnits that = (MeasurementUnits) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (measurementUnitsName != null ? !measurementUnitsName.equals(that.measurementUnitsName) : that.measurementUnitsName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (measurementUnitsName != null ? measurementUnitsName.hashCode() : 0);
        return result;
    }
}
