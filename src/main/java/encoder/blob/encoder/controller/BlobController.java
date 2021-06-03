package encoder.blob.encoder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// rotas com informações do estado do servidor.
// útil para orquestrador.
@RestController
@RequestMapping(path = "/blob")
public class BlobController {

    @GetMapping("/findVideo")
    public ResponseEntity<Object> status() {
        return ResponseEntity.ok(new Object() {
            public final boolean success = true;
            public final String status = "UP";
        });
    }
    
}