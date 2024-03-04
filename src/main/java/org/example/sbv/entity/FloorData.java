package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "floor_data", schema = "public", catalog = "building_calculator") // catalog = "db"
public class FloorData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;
    @Basic
    @Column(name = "floor_height", nullable = false)
    private Float floorHeight;
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
    @ManyToOne
    @JoinColumn(name = "osb_external_wall", nullable = false)
    private MaterialCharacteristics osbExternalWall;
    @ManyToOne
    @JoinColumn(name = "steam_waterproofing_external _wall", nullable = false)
    private MaterialCharacteristics steamWaterproofingExternalWall;
    @ManyToOne
    @JoinColumn(name = "windscreen_external_wall", nullable = false)
    private MaterialCharacteristics windscreenExternalWall;
    @ManyToOne
    @JoinColumn(name = "insulation_external_wall", nullable = false)
    private MaterialCharacteristics insulationExternalWall;
    @Basic
    @Column(name = "overlap_thickness", nullable = false)
    private Integer overlapThickness;
    @ManyToOne
    @JoinColumn(name = "osb_thickness", nullable = false)
    private MaterialCharacteristics osbThickness;
    @ManyToOne
    @JoinColumn(name = "steam_waterproofing_thickness", nullable = false)
    private MaterialCharacteristics steamWaterproofingThickness;
    @ManyToOne
    @JoinColumn(name = "windscreen_thickness", nullable = false)
    private MaterialCharacteristics windscreenThickness;
    @ManyToOne
    @JoinColumn(name = "insulation_thickness", nullable = false)
    private MaterialCharacteristics insulationThickness;
    @ManyToOne
    @JoinColumn(name = "osb_internal_wall", nullable = false)
    private MaterialCharacteristics osbInternalWall;
    @ManyToOne
    @JoinColumn(name = "structural_element_frame_id", nullable = false)
    private StructuralElementFrame structuralElementFrameId;

    public FloorData(Integer floorNumber, Float floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, MaterialCharacteristics osbExternalWall, MaterialCharacteristics steamWaterproofingExternalWall, MaterialCharacteristics windscreenExternalWall, MaterialCharacteristics insulationExternalWall, Integer overlapThickness, MaterialCharacteristics osbThickness, MaterialCharacteristics steamWaterproofingThickness, MaterialCharacteristics windscreenThickness, MaterialCharacteristics insulationThickness, MaterialCharacteristics osbInternalWall, StructuralElementFrame structuralElementFrameId) {
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

    public FloorData(Integer id, Integer floorNumber, Float floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, MaterialCharacteristics osbExternalWall, MaterialCharacteristics steamWaterproofingExternalWall, MaterialCharacteristics windscreenExternalWall, MaterialCharacteristics insulationExternalWall, Integer overlapThickness, MaterialCharacteristics osbThickness, MaterialCharacteristics steamWaterproofingThickness, MaterialCharacteristics windscreenThickness, MaterialCharacteristics insulationThickness, MaterialCharacteristics osbInternalWall, StructuralElementFrame structuralElementFrameId) {
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

    public FloorData() {
    }

}
