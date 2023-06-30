package com.makiia.modules.countries.usecase;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.makiia.crosscutting.domain.model.EntyDeleteDto;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroResponse;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.modules.countries.dataproviders.jpa.JpaEntySispaisamaestroDataProviders;
import com.makiia.modules.countries.services.UseCase;
import com.makiia.modules.countries.services.UsecaseServices;

@UseCase
public class EntySispaisamaestroService extends UsecaseServices<EntySispaisamaestroDto, JpaEntySispaisamaestroDataProviders>
{
    @Autowired
    private JpaEntySispaisamaestroDataProviders jpaDataProviders;
    
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }


    public EntySispaisamaestroResponse saveBefore(EntySispaisamaestroResponse dto) throws EBusinessException {
        try{
            List<EntySispaisamaestroDto>  dtoAux = this.ijpaDataProvider.save(dto.getRspData());
            dto.setRspValue("OK");
            dto.setRspMessage("OK");             
            dto.setRspParentKey("NA");             
            dto.setRspAppKey("NA");
            dtoAux = this.ijpaDataProvider.save(dtoAux);
            dto.setRspData(dtoAux);
            return dto;
        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

     public EntySispaisamaestroResponse updateAll(EntySispaisamaestroResponse dto) throws EBusinessException {
        try {
            List<EntySispaisamaestroDto> dtoAux = dto.getRspData();

            for (EntySispaisamaestroDto dtox : dtoAux){
                dtox = this.ijpaDataProvider.update(dtox.getRecUnikeySipa(),dtox);
            }
            dto.setRspValue("OK");
            dto.setRspMessage("OK");             
            dto.setRspParentKey("NA");             
            dto.setRspAppKey("NA");
            dto.setRspData(dtoAux);
            return dto;

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    

     public String deleteAll(List<EntyDeleteDto> dto) throws EBusinessException {
        try {

            for (EntyDeleteDto dtox : dto) {
                this.ijpaDataProvider.delete(dtox.getRecPKey());
            }
            return "Ok";

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }






}
