package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.FloorDataAdd;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.entity.TypeAdd;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorAddResponse {
    private Integer id;
    private TypeAdd typeAdd;
    private MaterialCharacteristics materialCharacteristics;
}
