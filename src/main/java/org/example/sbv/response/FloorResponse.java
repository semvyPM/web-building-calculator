package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.FloorDataAdd;
import org.example.sbv.entity.ResultsFrame;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorResponse {
    private Integer id;
    private FloorData floorData;
    private List<FloorAddResponse> floorDataAdd;
    private List<ResultFrameResponse> resultForInnerWalls;
    private Float resultForInnerWallsSum;
    private List<ResultFrameResponse> resultForOuterWalls;
    private Float resultForOuterWallsSum;
    private List<ResultFrameResponse> resultForOverlaps;
    private Float resultForOverlapsSum;
    private Float resultSum;
}
