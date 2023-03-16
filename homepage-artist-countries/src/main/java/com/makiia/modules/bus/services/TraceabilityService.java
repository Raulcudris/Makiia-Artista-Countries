package com.makiia.modules.bus.services;

import com.makiia.crosscutting.domain.model.traceability.Traceability;
import com.makiia.crosscutting.domain.model.traceability.TraceabilityEvent;
import com.makiia.crosscutting.domain.model.traceability.TransactionFile;
import com.makiia.crosscutting.exceptions.MicroEventException;
import com.makiia.crosscutting.utils.GsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class TraceabilityService {

    private static final String SENDER_NIT = "SENDER_NIT";

    private static final String RECEIVER_NIT = "RECEIVER_NIT";

    private static final String DOCUMENT_TYPE = "DOCUMENT_TYPE";

    private static final String TRANSACTION_ID = "transactionId";

    private static final String COMPONENT = "ApprovalServices";

    private static final String SERVICE = "RADIAN";

    private static final Locale LOCALE = new Locale("es", "CO");




    public void createTraceabilityEventDocument(
            final String transactionId,
            final String status,
            final TransactionFile transactionFile,
            final String dataType,
            final String name,
            final String message,
            Map<String, String> properties)
            throws MicroEventException {

            log.info("createTraceabilityEventDocument-> " + status + ", " + name);

            List<Map<String, String>> propertiesList = new ArrayList<>();
            properties.put("component", COMPONENT);
            properties.put("service", SERVICE);

            propertiesList.add(properties);

            List<TransactionFile> files = new ArrayList<>();
            files.add(transactionFile);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", LOCALE);
            String strDate = formatter.format(new Date());

            sendToTraceability(
                    null,
                    TraceabilityEvent.builder()
                            .transactionId(transactionId)
                            .eventId(UUID.randomUUID().toString())
                            .name(name)
                            .status(status)
                            .message(message)
                            .dataType(dataType)
                            .creationDate(strDate.replace(" ", "T"))
                            .files(files)
                            .properties(propertiesList)
                            .build());
        }


    /**
     * @param traceability
     * @param event
     * @throws MicroEventException
     */
    public void sendToTraceability(final Traceability traceability, final TraceabilityEvent event)
            throws MicroEventException {

        try {

                String generatedSend;

                if (traceability != null) {
                    generatedSend = GsonUtil.getGson().toJson(traceability);
                    log.info("Se envia  objeto al servicio de trazabilidad " + generatedSend);
                } else {
                    generatedSend = GsonUtil.getGson().toJson(event);
                    log.info("Se envia  objeto al servicio de trazabilidad para el evento " + generatedSend);
                }


                log.info("Se envia exitosamente. " + generatedSend);

        } catch (JmsException ex) {
            log.info("Error consumiendo Jms. " + ex.getMessage());
            throw new MicroEventException(ex.getMessage());
        }
    }

}
