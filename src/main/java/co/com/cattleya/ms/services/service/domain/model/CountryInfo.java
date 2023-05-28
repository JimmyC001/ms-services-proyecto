package co.com.cattleya.ms.services.service.domain.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class CountryInfo {
    private List<String> capital;
    private List<Double> latlng;
    private Map<String, Map<String, String>> currencies;
    private Map<String, String> maps;

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }
}

