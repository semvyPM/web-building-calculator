package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.entity.ResultTypeFloorFrame;
import org.example.sbv.entity.ResultsFrame;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultFrameResponse {
    private Integer id;
    private Float amount;
    private Float price;
    private Float fullPrice;
    private MaterialCharacteristics materialCharacteristics;
    private ResultTypeFloorFrame resultTypeFloorFrame;
}
