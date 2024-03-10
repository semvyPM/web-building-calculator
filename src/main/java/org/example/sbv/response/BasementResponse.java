package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.MaterialCharacteristics;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasementResponse {
    private Integer id;
    private Float perimetr;
    private Float length;
    private MaterialCharacteristics piles;
    private MaterialCharacteristics concrete;
    private List<ResultBasementResponse> resultBasementResponses;
}
