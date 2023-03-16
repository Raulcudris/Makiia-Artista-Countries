package com.makiia.modules.prices.api;

import com.makiia.crosscutting.domain.constants.ApiConstants;
import com.makiia.crosscutting.domain.constants.Constants;
import com.makiia.crosscutting.domain.model.EntyRecmaetarivalorDto;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroResponse;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.exceptions.MicroEventException;
import com.makiia.modules.prices.usecase.EntyRecmaetarivalorService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/Prices", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EntyRecmaetarivalorWebApi {
    @Autowired
    private EntyRecmaetarivalorService service;
    @GetMapping("getall")
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_DESC, notes = "")
    public ResponseEntity<List<EntyRecmaetarivalorDto>> getAll()
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_ALL_DESC, notes = "")
    public ResponseEntity<EntySispaisamaestroResponse> getAll(@RequestParam(value = "CurrentPage", required = false) int CurrentPage,
                                                              @RequestParam(value = "PageSize",  required = false) int PageSize)
                                                        throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.getAll(CurrentPage, PageSize), HttpStatus.OK);
    }

    @GetMapping(Constants.ID_PRICES_PARAM)
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_DESC, notes = "")
    public ResponseEntity<EntyRecmaetarivalorDto>get(@PathVariable(Constants.ID_REST) String id)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping("create")
    @ApiOperation(httpMethod = ApiConstants.POST_HTTP, value = ApiConstants.POST_DESC, notes = "")
    public ResponseEntity<EntyRecmaetarivalorDto> create(@RequestBody EntyRecmaetarivalorDto dto)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

   //@PutMapping(Constants.ID_PRICES_PARAM)
    @PutMapping(Constants.ID_PRICES_PARAM)
    @ApiOperation(httpMethod = ApiConstants.PUT_HTTP, value = ApiConstants.PUT_DESC, notes = "")
    public ResponseEntity<EntyRecmaetarivalorDto> update(@PathVariable(Constants.ID_REST) String id, @RequestBody EntyRecmaetarivalorDto dto)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.CREATED);
    }

    @DeleteMapping(Constants.ID_PRICES_PARAM)
    @ApiOperation(httpMethod = ApiConstants.DELETE_HTTP, value = ApiConstants.DELETE_DESC, notes = "")
    public void delete(@PathVariable(Constants.ID_REST) String id) throws EBusinessException, MicroEventException {
        service.delete(id);
    }

}
