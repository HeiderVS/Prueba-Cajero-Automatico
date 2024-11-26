package pruebatecnicabaz.cajeroautomatico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pruebatecnicabaz.cajeroautomatico.Service.TransaccionService;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public ResponseEntity<String> retiro (@RequestParam double monto) {
        try {
            String result = transaccionService.Retiro(monto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
