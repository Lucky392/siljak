/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findByIdCar", query = "SELECT i FROM Images i WHERE i.imagesPK.idCar = :idCar"),
    @NamedQuery(name = "Images.findById", query = "SELECT i FROM Images i WHERE i.imagesPK.id = :id")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImagesPK imagesPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "id_car", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;

    public Images() {
    }

    public Images(ImagesPK imagesPK) {
        this.imagesPK = imagesPK;
    }

    public Images(ImagesPK imagesPK, String image) {
        this.imagesPK = imagesPK;
        this.image = image;
    }

    public Images(long idCar, long id) {
        this.imagesPK = new ImagesPK(idCar, id);
    }

    public ImagesPK getImagesPK() {
        return imagesPK;
    }

    public void setImagesPK(ImagesPK imagesPK) {
        this.imagesPK = imagesPK;
    }

    @JsonIgnore
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    @JsonIgnore
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagesPK != null ? imagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.imagesPK == null && other.imagesPK != null) || (this.imagesPK != null && !this.imagesPK.equals(other.imagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Images[ imagesPK=" + imagesPK + " ]";
    }
    
}
