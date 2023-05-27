package co.com.cattleya.ms.services.service.infrastructure.persistence;

import co.com.cattleya.ms.services.service.domain.model.MapsInfo;

public interface MapsServiceAPI {

    MapsInfo getMapsRout( String destination );
}
