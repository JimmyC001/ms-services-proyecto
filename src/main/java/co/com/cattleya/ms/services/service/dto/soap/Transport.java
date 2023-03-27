//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.03.26 a las 10:06:37 PM COT 
//


package co.com.cattleya.ms.services.service.dto.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Transport complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Transport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="vehicle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idVehicle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="endDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transport", propOrder = {
    "company",
    "vehicle",
    "idVehicle",
    "origin",
    "destination",
    "startDateTime",
    "endDateTime"
})
public class Transport {
    @XmlElement(required = true)
    protected String company;
    @XmlElement(required = true)
    protected String vehicle;
    @XmlElement(required = true)
    protected String idVehicle;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected String destination;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDateTime;
}
