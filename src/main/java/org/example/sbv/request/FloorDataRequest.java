package org.example.sbv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.FloorDataAdd;
import org.example.sbv.entity.Openings;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorDataRequest {
    private FloorData floorData;
    private List<OpeningsRequest> openingsList;
    private List<ResultFrameRequest> resultsFrames;
    private List<FloorDataAddRequest> floorDataAdds;
}
