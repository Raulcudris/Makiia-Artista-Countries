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
        Optional<EntySispaisamaestro> findById(String id);
        @Query("select b from EntySispaisamaestro b where b.sisNombreSipa = : Filter")

        Page<EntySispaisamaestro> findNameCountry(Pageable pageable, @Param("Filter") String Filter);
}
