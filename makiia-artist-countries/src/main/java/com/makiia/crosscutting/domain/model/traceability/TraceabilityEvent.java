package com.makiia.crosscutting.domain.model.traceability;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class TraceabilityEvent {
    private String transactionId;
    private String eventId;
    private String name;
    private String status;
    private String message;
    private String dataType;
    private String creationDate;
    private List<TransactionFile> files;
    private List<String> tag;
    private List<Map<String, String>> properties;
}
