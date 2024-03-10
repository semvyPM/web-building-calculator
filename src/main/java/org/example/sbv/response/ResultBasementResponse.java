package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.MaterialCharacteristics;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultBasementResponse {
    private Integer id;
    private MaterialCharacteristics materialCharacteristicsId;
    private Float amount;
    private Float price;
    private Float fullPrice;
}
