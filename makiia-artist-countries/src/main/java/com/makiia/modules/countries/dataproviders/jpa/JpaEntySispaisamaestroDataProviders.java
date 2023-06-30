package com.makiia.modules.countries.dataproviders.jpa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    public EntySispaisamaestroResponse getAll() throws EBusinessException {
        try {
            List<EntySispaisamaestro> responses = (List<EntySispaisamaestro>) repository.findAll();
            int currentPage=0;
            int totalPageSize=responses.size();
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            //Pageable paginacion
            Page<EntySispaisamaestro> ResponsePage = null;
            ResponsePage = repository.findAll(pageable);

            List<EntySispaisamaestro> ListPage = ResponsePage.getContent();
            List<EntySispaisamaestroDto> content  = ListPage.stream().map(p ->mapToDto(p)).collect(Collectors.toList());

            EntySispaisamaestroResponse response = new EntySispaisamaestroResponse();
            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());

            currentPage = currentPage + 1;
            String nextPageUrl = "LocalHost";
            String previousPageUrl = "LocalHost";
            response.setRspPagination(headResponse(currentPage, totalPageSize, ResponsePage.getTotalElements(), ResponsePage.getTotalPages(), ResponsePage.hasNext(), ResponsePage.hasPrevious(), nextPageUrl, previousPageUrl));
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
    public EntySispaisamaestroResponse getAll(int currentPage , int totalPageSize , String parameter,String filter) throws EBusinessException {
        try {
            currentPage = currentPage - 1;
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            Page<EntySispaisamaestro> ResponsePage = null;
            if (parameter.equals("PKEY")) {
                ResponsePage = repository.findfindByRecUnikeySipa(Integer.parseInt(filter), pageable);
            }else {
                //FKEY
                ResponsePage = repository.findNameCountry(filter,pageable);
            }
            List<EntySispaisamaestro> ListPage = ResponsePage.getContent();
            List<EntySispaisamaestroDto> content = ListPage.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

            EntySispaisamaestroResponse response = new EntySispaisamaestroResponse();
            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());

            currentPage = currentPage + 1;
            String nextPageUrl = "LocalHost";
            String previousPageUrl = "LocalHost";
            response.setRspPagination(headResponse(currentPage, totalPageSize, ResponsePage.getTotalElements(), ResponsePage.getTotalPages(), ResponsePage.hasNext(), ResponsePage.hasPrevious(), nextPageUrl, previousPageUrl));
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
    public EntySispaisamaestroDto get(Integer id) throws EBusinessException {
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
    public EntySispaisamaestroDto update(Integer id, EntySispaisamaestroDto dto) throws EBusinessException {
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
    public void delete(Integer id) throws EBusinessException {
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
        EntySispaisamaestroDto dtos = new EntySispaisamaestroDto();
        dtos.setRecUnikeySipa(entySispaisamaestro.getRecUnikeySipa());
        dtos.setSisCodpaiSipa(entySispaisamaestro.getSisCodpaiSipa());
        dtos.setSisAbreviSipa(entySispaisamaestro.getSisAbreviSipa());
        dtos.setSisNombreSipa(entySispaisamaestro.getSisNombreSipa());
        dtos.setSisCodpaiSipa(entySispaisamaestro.getSisCodpaiSipa());
        dtos.setSisIndicaSipa(entySispaisamaestro.getSisIndicaSipa());
        dtos.setSisNombrelSipa(entySispaisamaestro.getSisNombrelSipa());
        dtos.setSisCodconSico(entySispaisamaestro.getSisCodconSico());
        dtos.setSisTimezoSipa(entySispaisamaestro.getSisTimezoSipa());
        dtos.setSisEaradiSipa(entySispaisamaestro.getSisEaradiSipa());
        dtos.setSisSecdetSipa(entySispaisamaestro.getSisSecdetSipa());
        dtos.setSisEstregSipa(entySispaisamaestro.getSisEstregSipa());
        return  dtos;
    }

    public static PaginationResponse headResponse(int currentPage    , int totalPageSize ,
                                                  long totalResults  , int totalPages,
                                                  boolean hasNextPage, boolean hasPreviousPage,
                                                  String nextpageUrl , String previousPageUrl )
    {
        return PaginationResponse.builder()
                .currentPage(currentPage)
                .totalPageSize(totalPageSize)
                .totalResults(totalResults)
                .totalPages(totalPages)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .nextPageUrl(nextpageUrl)
                .previousPageUrl(previousPageUrl)
                .build();

    }
}
