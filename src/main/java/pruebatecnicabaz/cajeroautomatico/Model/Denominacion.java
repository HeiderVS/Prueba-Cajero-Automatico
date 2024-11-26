package pruebatecnicabaz.cajeroautomatico.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Denominacion {
    @Id
    private double valor;
    private String tipo;
    private int cantidad;

    public void restarCantidad(int cantidadARestar) {
        cantidad -= cantidadARestar;
    }
}
