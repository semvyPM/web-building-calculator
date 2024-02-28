package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.CalculationState;
import org.example.sbv.entity.Customers;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculationRequest {
    private Customers customerId;
    private String addressObjectConstractions;
    private Integer number;
    private Date createdDate;
    private CalculationState сalculationStateId;

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "customerId=" + customerId +
                ", addressObjectConstractions='" + addressObjectConstractions + '\'' +
                ", number='" + number + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", сalculationStateId=" + сalculationStateId +
                '}';
    }
}
