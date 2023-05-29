package co.com.cattleya.ms.services.service.infrastructure.persistence.api;

import co.com.cattleya.ms.services.service.domain.model.MapsInfo;
import co.com.cattleya.ms.services.service.infrastructure.persistence.MapsServiceAPI;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MapsService implements MapsServiceAPI {
    String apiKey = "AIzaSyCnbMyTLpsYE4eVfGhl2lGcnvZsNOZ3y1c";
    @Override
    public MapsInfo getMapsRout( String destination) {
        MapsInfo maps = new MapsInfo();
        try {
            String urlString = "https://maps.googleapis.com/maps/api/staticmap?center=Destino&zoom=13&size=600x300&maptype=roadmap&markers=color:red%7Clabel:D%7C" +  destination + "&key=" + apiKey;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            maps.setLink(urlString);
            return maps;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}