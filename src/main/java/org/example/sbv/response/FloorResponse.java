package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.ResultsFrame;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorResponse {
    private Integer id;
    private FloorData floorData;
    private List<ResultFrameResponse> resultFrameResponses;
}
