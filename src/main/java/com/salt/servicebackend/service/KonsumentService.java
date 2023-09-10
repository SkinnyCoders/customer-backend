package com.salt.servicebackend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.salt.servicebackend.entity.Konsument;
import com.salt.servicebackend.model.KonsumentRequest;
import com.salt.servicebackend.repository.KonsumentRepository;
import com.salt.servicebackend.utils.GlobalValues;

import static com.salt.servicebackend.utils.GlobalValues.DATA_NOT_FOUND_MESSAGE_VARIABLE;
import static com.salt.servicebackend.utils.GlobalValues.ID_NOT_FOUND_MESSAGE_VARIABLE;

@Service
public class KonsumentService {

    @Autowired
    private KonsumentRepository konsumentRepository;

    @Autowired
    private ValidationService validationService;
    

    @Transactional
    public void register(KonsumentRequest request){
        validationService.validate(request);

        Konsument konsument = new Konsument();
        konsument.setAlamat(request.getAlamat());
        konsument.setNama(request.getNama());
        konsument.setKota(request.getKota());
        konsument.setProvinsi(request.getProvinsi());
        konsument.setTgl_registrasi(new Date());
        konsument.setStatus(GlobalValues.STATUS_AKTIF_VARIABLE);
        
        konsumentRepository.save(konsument);
    }

    public Iterable<Konsument> getAll(){

        if(IterableUtils.isEmpty(konsumentRepository.findAll())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DATA_NOT_FOUND_MESSAGE_VARIABLE);
        }

        return konsumentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Konsument> searchByName(String name){
        List<Konsument> datas = konsumentRepository.searchKonsumentByName(name);
        
        if(datas.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DATA_NOT_FOUND_MESSAGE_VARIABLE);
        }

        return datas;
    }

    @Transactional
    public List<Konsument> getByStatus(String status){
        List<Konsument> datas = konsumentRepository.getKonsumnetByStatus(status);

        if(datas.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DATA_NOT_FOUND_MESSAGE_VARIABLE);
        }

        return datas;
    }

    @Transactional
    public void updateKonsumentStatus(Integer id, String status){
        Optional<Konsument> konsument = konsumentRepository.findById(id);

        if(konsumentRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DATA_NOT_FOUND_MESSAGE_VARIABLE);
        }

        konsument.get().setStatus(status);
        konsumentRepository.save(konsument.get());
    }

    @Transactional
    public void deleteById(Integer id){

        if(konsumentRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND_MESSAGE_VARIABLE);
        }

        konsumentRepository.deleteById(id);
    }

}
