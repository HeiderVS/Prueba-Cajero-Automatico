package pruebatecnicabaz.cajeroautomatico.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebatecnicabaz.cajeroautomatico.Model.Cajero;
import pruebatecnicabaz.cajeroautomatico.Model.Denominacion;
import pruebatecnicabaz.cajeroautomatico.Repository.CajeroRepository;
import pruebatecnicabaz.cajeroautomatico.Repository.DenominacionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class TransaccionServiceImpl implements TransaccionService{


    @Autowired
    private DenominacionRepository denominacionRepository;
    @Autowired
    private CajeroRepository cajeroRepository;

    @Override
    public String Retiro(double monto) {

        Optional<Cajero> cajero = cajeroRepository.findById(1);
        if (cajero.isEmpty()) {
            return "Cajero fuera de servicio";
        }

        Cajero c = cajero.get();

        if (monto <= 0 || monto > c.getSaldoCajero()) {
            return "Monto inválido o superior al saldo disponible.";
        }

        Map<Double, Integer> resultado = new HashMap<>();
        double montoRestante = monto;
        //Ordenamos de manera descendente los valores de las denominaciones
        List<Denominacion> denominaciones = denominacionRepository.findAll()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getValor(), d1.getValor()))
                .toList();

        for (Denominacion denominacion : denominaciones) {
            if (montoRestante <= 0) break;

            int cantidadDisponible = denominacion.getCantidad();
            double valorDenominacion = denominacion.getValor();

            int cantidadUsar = (int) Math.min(montoRestante / valorDenominacion, cantidadDisponible);
            resultado.put(valorDenominacion, cantidadUsar);
            denominacion.restarCantidad(cantidadUsar);
            montoRestante -= cantidadUsar * valorDenominacion;
        }

        if (montoRestante > 0) {
            return "No se puede dispensar el monto solicitado con las denominaciones disponibles.";
        }

        //Actualizamos el saldo del cajero

        c.setSaldoCajero(c.getSaldoCajero() - monto);
        cajeroRepository.save(c);
        denominacionRepository.saveAll(denominaciones);

        return generarSalida(resultado, c.getSaldoCajero(),monto);
    }


    private String generarSalida(Map<Double, Integer> resultado, double saldoActual, double monto) {
        //Creamos un nuevo string builder
        StringBuilder sb = new StringBuilder("Monto a retirar:\n" + monto + "\n");
        sb.append("Se dispensaran:\n");

        //Con un Stream filtramos los valores del map
        resultado.entrySet().stream()
                .filter(entry -> entry.getValue() > 0) // Filtrar los valores donde la cantidad es mayor que 0
                .sorted((e1, e2) -> Double.compare(e2.getKey(), e1.getKey())) // Ordenar por clave de mayor a menor
                .forEach(entry -> sb.append(entry.getValue())
                        .append(" x $")
                        .append(entry.getKey())
                        .append("\n"));

        sb.append("Saldo actual: $").append(saldoActual);
        return sb.toString();
    }

//    private String generarSalida(Map<Double, Integer> resultado, double saldoActual) {
//        StringBuilder sb = new StringBuilder("Se dispensarán:\n");
//        for (Map.Entry<Double, Integer> entry : resultado.entrySet()) {
//            sb.append(entry.getValue()).append(" x $").append(entry.getKey()).append("\n");
//        }
//        sb.append("Saldo actual: $").append(saldoActual);
//        return sb.toString();
//    }
}
