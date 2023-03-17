package com.makiia.modules.countries.dataproviders.jpa;

import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroResponse;
import com.makiia.crosscutting.domain.model.PaginationResponse;
import com.makiia.crosscutting.exceptions.DataProvider;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import com.makiia.crosscutting.persistence.repository.EntySispaisamaestroRepository;
import com.makiia.modules.countries.dataproviders.IjpaEntySispaisamaestroDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@DataProvider
public class JpaEntySispaisamaestroDataProviders implements IjpaEntySispaisamaestroDataProviders {

    @Autowired
    private EntySispaisamaestroRepository repository;
    @Autowired
    @Qualifier("entySispaisamaestroSaveResponseTranslate")
    private Translator<EntySispaisamaestro, EntySispaisamaestroDto>saveResponseTranslate;

    @Autowired
    @Qualifier("entySispaisamaestroDtoToEntityTranslate")
    private Translator<EntySispaisamaestroDto, EntySispaisamaestro>dtoToEntityTranslate;

    @Override
    public List<EntySispaisamaestroDto> getAll() throws EBusinessException {
        List<EntySispaisamaestroDto> dtos = new ArrayList<>();
        try {
            List<EntySispaisamaestro> responses = (List<EntySispaisamaestro>) repository.findAll();

            if (!responses.isEmpty()) {
                for (EntySispaisamaestro response : responses) {
                    dtos.add(saveResponseTranslate.translate(response));
                }
            }

            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntySispaisamaestroResponse getAll(int currentPage , int totalPageSize ,String filter) throws EBusinessException {
        try {
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            Page<EntySispaisamaestro>ResponsePage = repository.findNameCountry(filter,pageable);
            List<EntySispaisamaestro> ListPage = ResponsePage.getContent();
            List<EntySispaisamaestroDto> content  = ListPage.stream().map(p ->mapToDto(p)).collect(Collectors.toList());

            EntySispaisamaestroResponse response = new EntySispaisamaestroResponse();

            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());
            response.setRspPagination(headResponse(ResponsePage.getNumber(),ResponsePage.getSize() , ResponsePage.getTotalElements(),ResponsePage.getTotalPages() , ResponsePage.hasNext(), ResponsePage.hasPrevious()));
            response.setRspData(content);
            return response;


        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntySispaisamaestroDto get(String id) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntySispaisamaestroDto save(EntySispaisamaestroDto dto) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.save(dtoToEntityTranslate.translate(dto)));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public List<EntySispaisamaestroDto> save(List<EntySispaisamaestroDto> dtos) throws EBusinessException {
        try {
            List<EntySispaisamaestro> entities = new ArrayList<>();

            for (EntySispaisamaestroDto dto : dtos) {
                entities.add(dtoToEntityTranslate.translate(dto));
            }
            dtos = new ArrayList<>();
            for (EntySispaisamaestro entity : repository.saveAll(entities)) {
                dtos.add(saveResponseTranslate.translate(entity));
            }
            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntySispaisamaestroDto update(String id, EntySispaisamaestroDto dto) throws EBusinessException {
        try {
            EntySispaisamaestro entity = dtoToEntityTranslate.translate(dto);
            EntySispaisamaestro old = repository.findById(id).get();


            old.setSisCodpaiSipa(
                    Objects.nonNull(dto.getSisCodpaiSipa())&& !entity.getSisCodpaiSipa().isEmpty()
                            ? entity.getSisCodpaiSipa()
                            :old.getSisCodpaiSipa());
            old.setSisAbreviSipa(
                    Objects.nonNull(dto.getSisAbreviSipa())&& !entity.getSisAbreviSipa().isEmpty()
                            ? entity.getSisAbreviSipa()
                            :old.getSisAbreviSipa());
            old.setSisNombreSipa(
                    Objects.nonNull(dto.getSisNombreSipa())&& !entity.getSisNombreSipa().isEmpty()
                            ? entity.getSisNombreSipa()
                            :old.getSisNombreSipa());
            old.setSisIndicaSipa(
                    Objects.nonNull(dto.getSisIndicaSipa())&& !entity.getSisIndicaSipa().isEmpty()
                            ?entity.getSisIndicaSipa()
                            :old.getSisIndicaSipa());
            old.setSisNombrelSipa(
                    Objects.nonNull(dto.getSisNombrelSipa())&& !entity.getSisNombrelSipa().isEmpty()
                            ?entity.getSisNombrelSipa()
                            :old.getSisNombrelSipa());
            old.setSisCodconSico(
                    Objects.nonNull(dto.getSisCodconSico()) && !entity.getSisCodconSico().isEmpty()
                            ?entity.getSisCodconSico()
                            :old.getSisCodconSico());
            old.setSisTimezoSipa(
                    Objects.nonNull(dto.getSisTimezoSipa()) && !entity.getSisTimezoSipa().isEmpty()
                            ? entity.getSisTimezoSipa()
                            : old.getSisTimezoSipa());

            old.setSisEaradiSipa(
                    Objects.nonNull(dto.getSisEaradiSipa()) && !entity.getSisEaradiSipa().equals(0)
                            ?entity.getSisEaradiSipa()
                            :old.getSisEaradiSipa());

            old.setSisSecdetSipa(
                    Objects.nonNull(dto.getSisSecdetSipa()) && !entity.getSisSecdetSipa().equals(0)
                            ?entity.getSisSecdetSipa()
                            :old.getSisSecdetSipa());

            return saveResponseTranslate.translate(repository.save(old));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();

        }
    }

    @Override
    public void delete(String id) throws EBusinessException {
        try {
            repository.delete(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    private EntySispaisamaestroDto mapToDto(EntySispaisamaestro entySispaisamaestro){
        EntySispaisamaestroDto entity = new EntySispaisamaestroDto();

        entity.setSisCodpaiSipa(entySispaisamaestro.getSisCodpaiSipa());
        entity.setSisAbreviSipa(entySispaisamaestro.getSisAbreviSipa());
        entity.setSisNombreSipa(entySispaisamaestro.getSisNombreSipa());
        entity.setSisCodpaiSipa(entySispaisamaestro.getSisCodpaiSipa());
        entity.setSisIndicaSipa(entySispaisamaestro.getSisIndicaSipa());
        entity.setSisNombrelSipa(entySispaisamaestro.getSisNombrelSipa());
        entity.setSisCodconSico(entySispaisamaestro.getSisCodconSico());
        entity.setSisTimezoSipa(entySispaisamaestro.getSisTimezoSipa());
        entity.setSisEaradiSipa(entySispaisamaestro.getSisEaradiSipa());
        entity.setSisSecdetSipa(entySispaisamaestro.getSisSecdetSipa());
        return  entity;
    }

    public static PaginationResponse headResponse(int currentPage    , int totalPageSize ,
                                                  long totalResults  , int totalPages,
                                                  boolean hasNextPage, boolean hasPreviousPage)
    {
        return PaginationResponse.builder()
                .currentPage(currentPage)
                .totalPageSize(totalPageSize)
                .totalResults(totalResults)
                .totalPages(totalPages)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .build();

    }
}
