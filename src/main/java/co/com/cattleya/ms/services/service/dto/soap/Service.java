//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.03.26 a las 10:06:37 PM COT 
//


package co.com.cattleya.ms.services.service.dto.soap;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;


/**
 * <p>Clase Java para Service complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Service"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Hosting" type="{soap}Hosting"/&gt;
 *           &lt;element name="Transport" type="{soap}Transport"/&gt;
 *           &lt;element name="EcoTrip" type="{soap}EcoTrip"/&gt;
 *           &lt;element name="Food" type="{soap}Food"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service", propOrder = {
    "id",
    "name",
    "price",
    "description",
    "hosting",
    "transport",
    "ecoTrip",
    "food"
})
public class Service {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected BigDecimal price;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "Hosting")
    protected Hosting hosting;
    @XmlElement(name = "Transport")
    protected Transport transport;
    @XmlElement(name = "EcoTrip")
    protected EcoTrip ecoTrip;
    @XmlElement(name = "Food")
    protected Food food;
    @XmlAttribute(name = "type", required = true)
    protected String type;
}
