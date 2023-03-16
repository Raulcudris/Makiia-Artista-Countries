package com.makiia.modules.prices.usecase;

import com.makiia.crosscutting.domain.model.EntyRecmaetarivalorDto;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.prices.dataproviders.jpa.JpaEntyRecmaetarivalorDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
@Log4j2
@UseCase
public class EntyRecmaetarivalorService extends UsecaseServices<EntyRecmaetarivalorDto, JpaEntyRecmaetarivalorDataProviders> {
    @Autowired
    private JpaEntyRecmaetarivalorDataProviders jpaDataProviders;
    @PostConstruct
    public void init() {

        this.ijpaDataProvider = jpaDataProviders;
    }


}

