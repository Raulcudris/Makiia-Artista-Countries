package com.makiia.modules.countries.usecase;

import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.countries.dataproviders.jpa.JpaEntySispaisamaestroDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Log4j2
@UseCase
public class EntySispaisamaestroService extends UsecaseServices<EntySispaisamaestroDto, JpaEntySispaisamaestroDataProviders>
{
    @Autowired
    private JpaEntySispaisamaestroDataProviders jpaDataProviders;
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }

}
