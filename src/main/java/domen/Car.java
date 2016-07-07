/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author blanusal
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByManufacturer", query = "SELECT c FROM Car c WHERE c.manufacturer = :manufacturer"),
    @NamedQuery(name = "Car.findByPrice", query = "SELECT c FROM Car c WHERE c.price = :price"),
    @NamedQuery(name = "Car.findByColor", query = "SELECT c FROM Car c WHERE c.color = :color"),
    @NamedQuery(name = "Car.findByDoor", query = "SELECT c FROM Car c WHERE c.door = :door"),
    @NamedQuery(name = "Car.findByFuel", query = "SELECT c FROM Car c WHERE c.fuel = :fuel"),
    @NamedQuery(name = "Car.findByTransmission", query = "SELECT c FROM Car c WHERE c.transmission = :transmission"),
    @NamedQuery(name = "Car.findByAirCondition", query = "SELECT c FROM Car c WHERE c.airCondition = :airCondition"),
    @NamedQuery(name = "Car.findByRegistration", query = "SELECT c FROM Car c WHERE c.registration = :registration"),
    @NamedQuery(name = "Car.findByInterior", query = "SELECT c FROM Car c WHERE c.interior = :interior"),
    @NamedQuery(name = "Car.findByWheel", query = "SELECT c FROM Car c WHERE c.wheel = :wheel"),
    @NamedQuery(name = "Car.findByCountry", query = "SELECT c FROM Car c WHERE c.country = :country"),
    @NamedQuery(name = "Car.findByInteriorColor", query = "SELECT c FROM Car c WHERE c.interiorColor = :interiorColor"),
    @NamedQuery(name = "Car.findByDamage", query = "SELECT c FROM Car c WHERE c.damage = :damage"),
    @NamedQuery(name = "Car.findByPropulsion", query = "SELECT c FROM Car c WHERE c.propulsion = :propulsion")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "door")
    private int door;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fuel")
    private String fuel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "transmission")
    private String transmission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "airCondition")
    private boolean airCondition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration")
    private boolean registration;
    @Size(max = 100)
    @Column(name = "interior")
    private String interior;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "wheel")
    private String wheel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "country")
    private String country;
    @Size(max = 100)
    @Column(name = "interiorColor")
    private String interiorColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "damage")
    private String damage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "propulsion")
    private String propulsion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Images> imagesList;

    public Car() {
    }

    public Car(Long id) {
        this.id = id;
    }

    public Car(Long id, String model, String manufacturer, double price, String color, int door, String fuel, String transmission, boolean airCondition, boolean registration, String wheel, String country, String damage, String propulsion) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.color = color;
        this.door = door;
        this.fuel = fuel;
        this.transmission = transmission;
        this.airCondition = airCondition;
        this.registration = registration;
        this.wheel = wheel;
        this.country = country;
        this.damage = damage;
        this.propulsion = propulsion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean getRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Car[ id=" + id + " ]";
    }
    
}
