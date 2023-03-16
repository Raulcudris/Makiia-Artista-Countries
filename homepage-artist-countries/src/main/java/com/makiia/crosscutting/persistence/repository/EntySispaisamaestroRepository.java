package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EntySispaisamaestroRepository extends JpaRepository<EntySispaisamaestro,String>
{
        String FILTER_COUNTRIES_ON_COUNTRYS_QUERY = "select b from Customer b where UPPER(b.firstName) like CONCAT('%',UPPER(?1),'%') and UPPER(b.lastName) like CONCAT('%',UPPER(?2),'%')";
        Optional<EntySispaisamaestro> findById(String id);
        String filtro ="";
        String Filter_NameCountries_Query = "select * from dbmysqlartistas.sispaisamaestro where upper(sis_nombre_sipa) like upper('%"+filtro+"%');";

        @Query(Filter_NameCountries_Query)
        List<EntySispaisamaestro> findNameCountry(String id);
}
