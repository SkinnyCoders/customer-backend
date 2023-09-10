package com.salt.servicebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salt.servicebackend.entity.Konsument;
import com.salt.servicebackend.model.KonsumentRequest;
import com.salt.servicebackend.model.KonsumentUpdateRequest;
import com.salt.servicebackend.model.WebResponse;
import com.salt.servicebackend.service.KonsumentService;

import static com.salt.servicebackend.utils.GlobalValues.SUCCESS_MESSAGE_VARIABLE;

@RestController
@RequestMapping("/api/v1/konsumen")
public class KonsumentController {

    @Autowired
    private KonsumentService konsumentService;

    @GetMapping(
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Iterable<Konsument>> getAllKonsument() {
        return WebResponse.<Iterable<Konsument>>builder().data(konsumentService.getAll()).message(SUCCESS_MESSAGE_VARIABLE).build();
    }

    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody KonsumentRequest request) {
        konsumentService.register(request);
        return WebResponse.<String>builder().data(null).message(SUCCESS_MESSAGE_VARIABLE).build();
    }

    @GetMapping(
            path = "/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Konsument>> searchKonsument(
        @RequestParam(value = "name", required = true) String name) {
        return WebResponse.<List<Konsument>>builder().data(konsumentService.searchByName(name)).message(SUCCESS_MESSAGE_VARIABLE).build();
    }

    @GetMapping(
            path = "/status/{status}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Konsument>> getByStatus(
        @PathVariable(value = "status", required = true) String status) {
        return WebResponse.<List<Konsument>>builder().data(konsumentService.getByStatus(status)).message(SUCCESS_MESSAGE_VARIABLE).build();
    }

    @PatchMapping(
            path = "/status",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> updateStatus(@RequestBody KonsumentUpdateRequest request) {
        konsumentService.updateKonsumentStatus(request.getId(), request.getStatus());
        return WebResponse.<String>builder().data(null).message(SUCCESS_MESSAGE_VARIABLE).build();
    }

    @DeleteMapping(
            path = "/deleted/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> remove(@PathVariable("id") Integer id) {
        konsumentService.deleteById(id);;
        return WebResponse.<String>builder().data(null).message(SUCCESS_MESSAGE_VARIABLE).build();
    }
    
}
