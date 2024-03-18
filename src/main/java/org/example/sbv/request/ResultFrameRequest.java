package org.example.sbv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultFrameRequest {
    private Float amount;
    private Float price;
    private Float fullPrice;
    private MaterialCharacteristics materialCharacteristics;
    private ResultTypeFloorFrame resultTypeFloorFrame;
}
