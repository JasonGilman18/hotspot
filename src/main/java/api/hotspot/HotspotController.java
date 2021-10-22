package api.hotspot;

import api.hotspot.consumer.Consumer;
import api.hotspot.hotspot.Hotspot;
import api.hotspot.hotspot.HotspotService;
import api.hotspot.producer.Producer;
import api.hotspot.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HotspotController {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private HotspotService hotspotService;

    @GetMapping("/hotspot")
    public Mono<String> getHotspot() {
        return Mono.just("Hotspot");
    }

    @PostMapping("/producer")
    public ResponseEntity<String> createProducer(@RequestBody Producer producer) {
        if(producerService.createProducer(producer))
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not create Producer", HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/hotspot")
    public ResponseEntity<String> createHotspot(@RequestBody Hotspot hotspot) {
        if(hotspotService.createHotspot(hotspot))
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Could not create Hotspot", HttpStatus.EXPECTATION_FAILED);
    }

    /*
    @PostMapping("/consumer")
    public ResponseEntity<String> createConsumer(@RequestBody Consumer consumer) {

    }
     */
}
