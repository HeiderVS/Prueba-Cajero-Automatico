package pruebatecnicabaz.cajeroautomatico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebatecnicabaz.cajeroautomatico.Model.Denominacion;


@Repository
public interface DenominacionRepository extends JpaRepository<Denominacion, Integer> {

}
