package co.com.cattleya.ms.services.service.domain.model;

import lombok.Data;

@Data
public class MapsInfo {
    private String link;

    public void setLink(String link) {
        this.link = link;
    }
}