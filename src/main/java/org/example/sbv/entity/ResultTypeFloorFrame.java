package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "result_type_floor_frame", schema = "public", catalog = "building_calculator") // catalog = "db"

public class ResultTypeFloorFrame {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "type_name", nullable = false, precision = 0)
    private String typeName;
}
