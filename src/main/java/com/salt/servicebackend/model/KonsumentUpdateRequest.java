package com.salt.servicebackend.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KonsumentUpdateRequest {

    private Integer id;

    @Size(max = 100)
    private String status;
    
}
