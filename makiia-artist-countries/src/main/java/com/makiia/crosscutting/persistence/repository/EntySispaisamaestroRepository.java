package com.makiia.crosscutting.persistence.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
public interface EntySispaisamaestroRepository extends JpaRepository<EntySispaisamaestro,Integer>
{
        String FILTER_COUNTRIES_CODCOUNTRIES_QUERY = "select c from EntySispaisamaestro c  where c.recUnikeySipa  = ?1";
        @Query(value = FILTER_COUNTRIES_CODCOUNTRIES_QUERY)
        Page<EntySispaisamaestro> findCodCountry(Integer parameter,Pageable pageable);

        String FILTER_COUNTRIES_NAMECOUNTRY_QUERY = "select c from EntySispaisamaestro c where UPPER(c.sisNombreSipa) like concat('%',upper(?1),'%')";
        @Query(value = FILTER_COUNTRIES_NAMECOUNTRY_QUERY)
        Page<EntySispaisamaestro> findNameCountry(String filter,Pageable pageable);

        Optional<EntySispaisamaestro> findById(Integer id);

}
