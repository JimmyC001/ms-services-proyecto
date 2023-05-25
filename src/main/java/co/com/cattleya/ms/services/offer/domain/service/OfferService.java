package co.com.cattleya.ms.services.offer.domain.service;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OfferService {
    private final OfferRepository repository;
    @Autowired
    public OfferService(OfferRepository repository){
        this.repository = repository;
    }
    public Offer saveOffer(Offer offer){
        Offer dbOffer = repository.findByName(offer.getName()).orElse(null);
        if(dbOffer != null)
            return dbOffer;
        return repository.save(offer);
    }
    public List<Offer> getAllOffers(){
        return repository.findAll();
    }
    public Offer addService(String name, co.com.cattleya.ms.services.service.domain.model.Service service){
        Offer dbOffer = repository.findByName(name).orElse(null);
        if(dbOffer == null)
            return null;
        dbOffer.getServices().add(service);
        return repository.save(dbOffer);
    }
    public Offer updateOffer(Offer offer){
        if(offer == null)
            return null;
        Offer dbOffer = repository.findById(offer.getId()).orElse(null);
        if(dbOffer == null)
            return null;
        // repeated name
        if(offer.getName() != null){
            Offer dbWithName = repository.findByName(offer.getName()).orElse(null);
            if(dbWithName == null)
                dbOffer.setName(offer.getName());
        }
        if(offer.getDescription() != null)
            dbOffer.setDescription(offer.getDescription());
        if(offer.getPrice() != null)
            dbOffer.setPrice(offer.getPrice());
        if(offer.getServices() != null && !offer.getServices().isEmpty()){
            dbOffer.getServices().clear();
            dbOffer.getServices().addAll(offer.getServices().stream()
                    .filter(service ->
                            service.getProviderId().equals(dbOffer.getProviderId())
                    ).toList()
            );
        }
        return repository.save(dbOffer);
    }
    public Offer deleteOffer(Long id){
        Offer dbOffer = repository.findById(id).orElse(null);
        if(dbOffer == null)
            return null;
        repository.delete(dbOffer);
        return dbOffer;
    }
}
