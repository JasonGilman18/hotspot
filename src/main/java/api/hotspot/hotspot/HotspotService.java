package api.hotspot.hotspot;

import org.springframework.beans.factory.annotation.Autowired;

public class HotspotService {

    @Autowired
    HotspotRepository repo;

    public boolean createHotspot(Hotspot hotspot) {
        try {
            repo.save(hotspot);
            return true;
        }
        catch(IllegalArgumentException e) {
            return false;
        }
    }
}
