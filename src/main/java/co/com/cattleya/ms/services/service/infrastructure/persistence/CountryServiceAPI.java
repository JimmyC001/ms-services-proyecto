package co.com.cattleya.ms.services.service.infrastructure.persistence;

import co.com.cattleya.ms.services.service.domain.model.CountryInfo;

import java.util.List;

public interface CountryServiceAPI {

    CountryInfo getCountryInfo( String countryName )throws Exception ;
}
