package org.example.sbv.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.Openings;
import org.example.sbv.entity.ResultsFrame;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpeningsRequest {
    private String type;
    private Float height;
    private Float width;
    private Integer amount;
}
