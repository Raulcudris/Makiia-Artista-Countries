package com.makiia.modules.prices.dataproviders;

import com.makiia.crosscutting.domain.model.EntyRecmaetarivalorDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.modules.bus.contracts.IjpaDataProviders;

public interface IjpaEntyRecmaetarivalorDataProviders extends IjpaDataProviders<EntyRecmaetarivalorDto>
{
    EntyRecmaetarivalorDto update(String id, EntyRecmaetarivalorDto dto) throws EBusinessException;

    void delete(String id) throws EBusinessException;
}
