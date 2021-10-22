package api.hotspot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class ProducerService {

    @Autowired
    ProducerRepository repo;

    public boolean createProducer(Producer producer) {
        try {
            repo.save(producer);
            return true;
        }
        catch(IllegalArgumentException e) {
            return false;
        }
    }
}
