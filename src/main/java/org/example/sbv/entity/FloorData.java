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
    @JoinColumn(name = "windscreen_external_wall", nullable = false)
    private MaterialCharacteristics windscreenExternalWall;
    @ManyToOne
    @JoinColumn(name = "insulation_external_wall", nullable = false)
    private MaterialCharacteristics insulationExternalWall;
    @ManyToOne
    @JoinColumn(name = "structural_element_frame_id", nullable = false)
    private StructuralElementFrame structuralElementFrameId;

    public FloorData(Integer floorNumber, Float floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, MaterialCharacteristics osbExternalWall, MaterialCharacteristics windscreenExternalWall, MaterialCharacteristics insulationExternalWall, StructuralElementFrame structuralElementFrameId) {
        this.floorNumber = floorNumber;
        this.floorHeight = floorHeight;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.baseArea = baseArea;
        this.externalWallThickness = externalWallThickness;
        this.internalWallLength = internalWallLength;
        this.internalWallThickness = internalWallThickness;
        this.osbExternalWall = osbExternalWall;
        this.windscreenExternalWall = windscreenExternalWall;
        this.insulationExternalWall = insulationExternalWall;
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public FloorData(Integer id, Integer floorNumber, Float floorHeight, Float perimeterOfExternalWalls, Float baseArea, Float externalWallThickness, Float internalWallLength, Float internalWallThickness, MaterialCharacteristics osbExternalWall, MaterialCharacteristics windscreenExternalWall, MaterialCharacteristics insulationExternalWall, StructuralElementFrame structuralElementFrameId) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.floorHeight = floorHeight;
        this.perimeterOfExternalWalls = perimeterOfExternalWalls;
        this.baseArea = baseArea;
        this.externalWallThickness = externalWallThickness;
        this.internalWallLength = internalWallLength;
        this.internalWallThickness = internalWallThickness;
        this.osbExternalWall = osbExternalWall;
        this.windscreenExternalWall = windscreenExternalWall;
        this.insulationExternalWall = insulationExternalWall;
        this.structuralElementFrameId = structuralElementFrameId;
    }

    public FloorData() {
    }

}
