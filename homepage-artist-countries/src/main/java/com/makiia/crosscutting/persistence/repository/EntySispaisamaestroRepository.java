package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EntySispaisamaestroRepository extends JpaRepository<EntySispaisamaestro,String>
{
        Optional<EntySispaisamaestro> findById(String id);

}
