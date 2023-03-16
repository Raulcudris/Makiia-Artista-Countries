package com.makiia.crosscutting.patterns;

import com.makiia.crosscutting.exceptions.Main.EBusinessException;

@FunctionalInterface
public interface Translator<I, O> {
    O translate(final I input) throws EBusinessException;
}
