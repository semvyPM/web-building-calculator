package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "floor_data_add", schema = "public", catalog = "building_calculator") // catalog = "db"
public class FloorDataAdd {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "type_add_id", nullable = false)
    private TypeAdd typeAdd;
    @ManyToOne
    @JoinColumn(name = "floor_data_id", nullable = false)
    private FloorData floorDataId;
    @ManyToOne
    @JoinColumn(name = "material_characteristics_id", nullable = false)
    private MaterialCharacteristics materialCharacteristicsId;


    public FloorDataAdd(TypeAdd typeAdd, FloorData floorDataId, MaterialCharacteristics materialCharacteristicsId) {
        this.typeAdd = typeAdd;
        this.floorDataId = floorDataId;
        this.materialCharacteristicsId = materialCharacteristicsId;
    }

    public FloorDataAdd(Integer id, TypeAdd typeAdd, FloorData floorDataId, MaterialCharacteristics materialCharacteristicsId) {
        this.id = id;
        this.typeAdd = typeAdd;
        this.floorDataId = floorDataId;
        this.materialCharacteristicsId = materialCharacteristicsId;
    }

    public FloorDataAdd() {
    }

}
