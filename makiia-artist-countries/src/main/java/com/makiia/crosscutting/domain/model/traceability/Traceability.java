package com.makiia.crosscutting.domain.model.traceability;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Traceability {
    private String parentId;
    private String transactionId;
    private String country;
    private String product;
    private String companyIssuer;
    private String companyReceiver;
    private String account;
    private String documentId;
    private String documentType;
    private String inputChannel;
    private String outputChannel;
    private String status;
    private boolean finished;
    private long createdDate;
    private long modificationDate;
    private List<String> tag;
    private List<Map<String, String>> properties;
}
