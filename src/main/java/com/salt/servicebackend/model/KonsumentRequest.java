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
public class KonsumentRequest {

    @Size(max = 100)
    private String nama;

    private String alamat;

    @Size(max = 100)
    private String kota;

    @Size(max = 100)
    private String provinsi;
}
