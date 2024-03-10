package org.example.sbv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialsRequest {
    private Integer id;
    private String name;
    private String materialType;
    private String structuralElementType;

    @Override
    public String toString(){
        return "MaterialsRequset{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", materialType=" + materialType + '\'' +
                ", structuralElementType=" + structuralElementType +
                "}";
    }
}
