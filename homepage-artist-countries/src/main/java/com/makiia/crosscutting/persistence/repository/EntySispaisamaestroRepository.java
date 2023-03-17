package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EntySispaisamaestroRepository extends JpaRepository<EntySispaisamaestro,String>
{
        String FILTER_COUNTRIES_QUERY = "select c from EntySispaisamaestro c where UPPER(c.sisNombreSipa) like concat('%',upper(?1),'%')";
        @Query(value = FILTER_COUNTRIES_QUERY)
        Page<EntySispaisamaestro> findNameCountry(String filter , Pageable pageable);
        Optional<EntySispaisamaestro> findById(String id);

}
