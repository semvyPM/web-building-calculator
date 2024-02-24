package org.example.sbv.entity;

import jakarta.persistence.*;
// создано
@Entity
@Table(name = "structuralElementFrame", schema = "public", catalog = "building_calculator") // catalog = "db"
public class FloorFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;
    @Basic
    @Column(name = "floor_height", nullable = false)
    private Integer floorHeight;
    @Basic
    @Column(name = "perimeter_of_external_walls", nullable = false, precision = 0)
    private Float perimeterOfExternalWalls;
    @Basic
    @Column(name = "base_area", nullable = false, precision = 0)
    private Float baseArea;
    @Basic
    @Column(name = "external_wall_thickness", nullable = false, precision = 0)
    private Float externalWallThickness;
    @Basic
    @Column(name = "internal_wall_length", nullable = false, precision = 0)
    private Float internalWallLength;
    @Basic
    @Column(name = "internal_wall_thickness", nullable = false, precision = 0)
    private Float internalWallThickness;
    @Basic
    @Column(name = "OSB_external_wall", nullable = false, length = 100)
    private String osbExternalWall;
    @Basic
    @Column(name = "steam_waterproofing_external _wall", nullable = false, length = 100)
    private String steamWaterproofingExternalWall;
    @Basic
    @Column(name = "windscreen_external_wall", nullable = false, length = 100)
    private String windscreenExternalWall;
    @Basic
    @Column(name = "insulation_external_wall", nullable = false, length = 100)
    private String insulationExternalWall;
    @Basic
    @Column(name = "overlap_thickness", nullable = false, length = 100)
    private String overlapThickness;
    @Basic
    @Column(name = "OSB_thickness", nullable = false, length = 100)
    private String osbThickness;
    @Basic
    @Column(name = "steam_waterproofing_thickness", nullable = false, length = 100)
    private String steamWaterproofingThickness;
    @Basic
    @Column(name = "windscreen_thickness", nullable = false, length = 100)
    private String windscreenThickness;
    @Basic
    @Column(name = "insulation_thickness", nullable = false, length = 100)
    private String insulationThickness;
    @Basic
    @Column(name = "OSB_internal_wall", nullable = false, length = 100)
    private String osbInternalWall;
    @ManyToOne
    @JoinColumn(name = "structuralElementFrame_id", nullable = false)
    private StructuralElementFrame structuralElementFrameId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public Float getPerimeterOfExternalWalls() {
        return perimeterOfExternalWalls;
    }

    public void setPerimeterOfExternalWalls(Float perimeterOfExternalWalls) {
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
    }

    public Float getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(Float baseArea) {
        this.baseArea = baseArea;
    }

    public Float getExternalWallThickness() {
        return externalWallThickness;
    }

    public void setExternalWallThickness(Float externalWallThickness) {
        this.externalWallThickness = externalWallThickness;
    }

    public Float getInternalWallLength() {
        return internalWallLength;
    }

    public void setInternalWallLength(Float internalWallLength) {
        this.internalWallLength = internalWallLength;
    }

    public Float getInternalWallThickness() {
        return internalWallThickness;
    }

    public void setInternalWallThickness(Float internalWallThickness) {
        this.internalWallThickness = internalWallThickness;
    }

    public String getOsbExternalWall() {
        return osbExternalWall;
    }

    public void setOsbExternalWall(String osbExternalWall) {
        this.osbExternalWall = osbExternalWall;
    }

    public String getSteamWaterproofingExternalWall() {
        return steamWaterproofingExternalWall;
    }

    public void setSteamWaterproofingExternalWall(String steamWaterproofingExternalWall) {
        this.steamWaterproofingExternalWall = steamWaterproofingExternalWall;
    }

    public String getWindscreenExternalWall() {
        return windscreenExternalWall;
    }

    public void setWindscreenExternalWall(String windscreenExternalWall) {
        this.windscreenExternalWall = windscreenExternalWall;
    }

    public String getInsulationExternalWall() {
        return insulationExternalWall;
    }

    public void setInsulationExternalWall(String insulationExternalWall) {
        this.insulationExternalWall = insulationExternalWall;
    }

    public String getOverlapThickness() {
        return overlapThickness;
    }

    public void setOverlapThickness(String overlapThickness) {
        this.overlapThickness = overlapThickness;
    }

    public String getOsbThickness() {
        return osbThickness;
    }

    public void setOsbThickness(String osbThickness) {
        this.osbThickness = osbThickness;
    }

    public String getSteamWaterproofingThickness() {
        return steamWaterproofingThickness;
    }

    public void setSteamWaterproofingThickness(String steamWaterproofingThickness) {
        this.steamWaterproofingThickness = steamWaterproofingThickness;
    }

    public String getWindscreenThickness() {
        return windscreenThickness;
    }

    public void setWindscreenThickness(String windscreenThickness) {
        this.windscreenThickness = windscreenThickness;
    }

    public String getInsulationThickness() {
        return insulationThickness;
    }

    public void setInsulationThickness(String insulationThickness) {
        this.insulationThickness = insulationThickness;
    }

    public String getOsbInternalWall() {
        return osbInternalWall;
    }

    public void setOsbInternalWall(String osbInternalWall) {
        this.osbInternalWall = osbInternalWall;
    }

    public StructuralElementFrame getStructuralElementFrameId() {return structuralElementFrameId;}

    public void setStructuralElementFrameId(StructuralElementFrame structuralElementFrameId) {
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public FloorFrame(Integer id, Integer floorNumber, Integer floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, String osbExternalWall, String steamWaterproofingExternalWall, String windscreenExternalWall, String insulationExternalWall, String overlapThickness, String osbThickness, String steamWaterproofingThickness, String windscreenThickness, String insulationThickness, String osbInternalWall, StructuralElementFrame structuralElementFrameId) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.floorHeight = floorHeight;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.baseArea = baseArea;
        this.externalWallThickness = externalWallThickness;
        this.internalWallLength = internalWallLength;
        this.internalWallThickness = internalWallThickness;
        this.osbExternalWall = osbExternalWall;
        this.steamWaterproofingExternalWall = steamWaterproofingExternalWall;
        this.windscreenExternalWall = windscreenExternalWall;
        this.insulationExternalWall = insulationExternalWall;
        this.overlapThickness = overlapThickness;
        this.osbThickness = osbThickness;
        this.steamWaterproofingThickness = steamWaterproofingThickness;
        this.windscreenThickness = windscreenThickness;
        this.insulationThickness = insulationThickness;
        this.osbInternalWall = osbInternalWall;
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public FloorFrame(Integer floorNumber, Integer floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, String osbExternalWall, String steamWaterproofingExternalWall, String windscreenExternalWall, String insulationExternalWall, String overlapThickness, String osbThickness, String steamWaterproofingThickness, String windscreenThickness, String insulationThickness, String osbInternalWall, StructuralElementFrame structuralElementFrameId) {
        this.floorNumber = floorNumber;
        this.floorHeight = floorHeight;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.baseArea = baseArea;
        this.externalWallThickness = externalWallThickness;
        this.internalWallLength = internalWallLength;
        this.internalWallThickness = internalWallThickness;
        this.osbExternalWall = osbExternalWall;
        this.steamWaterproofingExternalWall = steamWaterproofingExternalWall;
        this.windscreenExternalWall = windscreenExternalWall;
        this.insulationExternalWall = insulationExternalWall;
        this.overlapThickness = overlapThickness;
        this.osbThickness = osbThickness;
        this.steamWaterproofingThickness = steamWaterproofingThickness;
        this.windscreenThickness = windscreenThickness;
        this.insulationThickness = insulationThickness;
        this.osbInternalWall = osbInternalWall;
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public FloorFrame() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FloorFrame that = (FloorFrame) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (floorNumber != null ? !floorNumber.equals(that.floorNumber) : that.floorNumber != null) return false;
        if (floorHeight != null ? !floorHeight.equals(that.floorHeight) : that.floorHeight != null) return false;
        if (perimeterOfExternalWalls != null ? !perimeterOfExternalWalls.equals(that.perimeterOfExternalWalls) : that.perimeterOfExternalWalls != null)
            return false;
        if (baseArea != null ? !baseArea.equals(that.baseArea) : that.baseArea != null) return false;
        if (externalWallThickness != null ? !externalWallThickness.equals(that.externalWallThickness) : that.externalWallThickness != null)
            return false;
        if (internalWallLength != null ? !internalWallLength.equals(that.internalWallLength) : that.internalWallLength != null)
            return false;
        if (internalWallThickness != null ? !internalWallThickness.equals(that.internalWallThickness) : that.internalWallThickness != null)
            return false;
        if (osbExternalWall != null ? !osbExternalWall.equals(that.osbExternalWall) : that.osbExternalWall != null)
            return false;
        if (steamWaterproofingExternalWall != null ? !steamWaterproofingExternalWall.equals(that.steamWaterproofingExternalWall) : that.steamWaterproofingExternalWall != null)
            return false;
        if (windscreenExternalWall != null ? !windscreenExternalWall.equals(that.windscreenExternalWall) : that.windscreenExternalWall != null)
            return false;
        if (insulationExternalWall != null ? !insulationExternalWall.equals(that.insulationExternalWall) : that.insulationExternalWall != null)
            return false;
        if (overlapThickness != null ? !overlapThickness.equals(that.overlapThickness) : that.overlapThickness != null)
            return false;
        if (osbThickness != null ? !osbThickness.equals(that.osbThickness) : that.osbThickness != null) return false;
        if (steamWaterproofingThickness != null ? !steamWaterproofingThickness.equals(that.steamWaterproofingThickness) : that.steamWaterproofingThickness != null)
            return false;
        if (windscreenThickness != null ? !windscreenThickness.equals(that.windscreenThickness) : that.windscreenThickness != null)
            return false;
        if (insulationThickness != null ? !insulationThickness.equals(that.insulationThickness) : that.insulationThickness != null)
            return false;
        if (osbInternalWall != null ? !osbInternalWall.equals(that.osbInternalWall) : that.osbInternalWall != null)
            return false;
        if (structuralElementFrameId != null ? !structuralElementFrameId.equals(that.structuralElementFrameId) : that.structuralElementFrameId != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (floorNumber != null ? floorNumber.hashCode() : 0);
        result = 31 * result + (floorHeight != null ? floorHeight.hashCode() : 0);
        result = 31 * result + (perimeterOfExternalWalls != null ? perimeterOfExternalWalls.hashCode() : 0);
        result = 31 * result + (baseArea != null ? baseArea.hashCode() : 0);
        result = 31 * result + (externalWallThickness != null ? externalWallThickness.hashCode() : 0);
        result = 31 * result + (internalWallLength != null ? internalWallLength.hashCode() : 0);
        result = 31 * result + (internalWallThickness != null ? internalWallThickness.hashCode() : 0);
        result = 31 * result + (osbExternalWall != null ? osbExternalWall.hashCode() : 0);
        result = 31 * result + (steamWaterproofingExternalWall != null ? steamWaterproofingExternalWall.hashCode() : 0);
        result = 31 * result + (windscreenExternalWall != null ? windscreenExternalWall.hashCode() : 0);
        result = 31 * result + (insulationExternalWall != null ? insulationExternalWall.hashCode() : 0);
        result = 31 * result + (overlapThickness != null ? overlapThickness.hashCode() : 0);
        result = 31 * result + (osbThickness != null ? osbThickness.hashCode() : 0);
        result = 31 * result + (steamWaterproofingThickness != null ? steamWaterproofingThickness.hashCode() : 0);
        result = 31 * result + (windscreenThickness != null ? windscreenThickness.hashCode() : 0);
        result = 31 * result + (insulationThickness != null ? insulationThickness.hashCode() : 0);
        result = 31 * result + (osbInternalWall != null ? osbInternalWall.hashCode() : 0);
        result = 31 * result + (structuralElementFrameId != null ? structuralElementFrameId.hashCode() : 0);
        return result;
    }
}
