package pruebatecnicabaz.cajeroautomatico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebatecnicabaz.cajeroautomatico.Model.Cajero;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Integer> {
}
