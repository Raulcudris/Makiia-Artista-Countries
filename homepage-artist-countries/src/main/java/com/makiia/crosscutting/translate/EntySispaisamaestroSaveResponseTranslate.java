package com.makiia.crosscutting.translate;

import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import com.makiia.crosscutting.utils.GsonUtil;
import org.springframework.stereotype.Component;
@Component
public class EntySispaisamaestroSaveResponseTranslate implements Translator<EntySispaisamaestro, EntySispaisamaestroDto> {
    @Override
    public EntySispaisamaestroDto translate(EntySispaisamaestro input) throws EBusinessException {
        return GsonUtil.getGson().fromJson(GsonUtil.getGson().toJson(input), EntySispaisamaestroDto.class);
    }
}
