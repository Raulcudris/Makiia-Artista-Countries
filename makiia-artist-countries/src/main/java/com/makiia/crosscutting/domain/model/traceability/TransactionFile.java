package com.makiia.crosscutting.domain.model.traceability;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionFile {
    private String storageId;
    private String fileName;
}
