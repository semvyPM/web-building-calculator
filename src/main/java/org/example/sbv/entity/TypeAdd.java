package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "type_add", schema = "public", catalog = "building_calculator") // catalog = "db"
public class TypeAdd {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    public TypeAdd(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public TypeAdd(String title) {
        this.title = title;
    }

    public TypeAdd() {
    }

}
