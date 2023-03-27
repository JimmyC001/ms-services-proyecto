//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.03.26 a las 10:06:37 PM COT 
//


package co.com.cattleya.ms.services.service.dto.soap;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Service_QNAME = new QName("soap", "Service");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.cattleya.ms.services.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link Hosting }
     * 
     */
    public Hosting createHosting() {
        return new Hosting();
    }

    /**
     * Create an instance of {@link Transport }
     * 
     */
    public Transport createTransport() {
        return new Transport();
    }

    /**
     * Create an instance of {@link EcoTrip }
     * 
     */
    public EcoTrip createEcoTrip() {
        return new EcoTrip();
    }

    /**
     * Create an instance of {@link Food }
     * 
     */
    public Food createFood() {
        return new Food();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Service }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Service }{@code >}
     */
    @XmlElementDecl(namespace = "soap", name = "Service")
    public JAXBElement<Service> createService(Service value) {
        return new JAXBElement<Service>(_Service_QNAME, Service.class, null, value);
    }

}
