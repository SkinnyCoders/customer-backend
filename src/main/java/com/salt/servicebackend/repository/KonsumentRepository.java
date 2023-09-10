package com.salt.servicebackend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.salt.servicebackend.entity.Konsument;

public interface KonsumentRepository extends CrudRepository<Konsument, Integer> {
    
    @Query("SELECT * FROM konsument k WHERE k.nama LIKE CONCAT('%',:data,'%') ORDER BY k.tgl_registrasi DESC")
    List<Konsument> searchKonsumentByName(@Param("data") String data);

    @Query("SELECT * FROM konsument k WHERE k.status = :status ORDER BY k.tgl_registrasi DESC")
    List<Konsument> getKonsumnetByStatus(@Param("status") String status);
}
