/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author blanusal
 */
@Embeddable
public class ImagesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_car")
    private long idCar;
    @Basic(optional = false)
    @Column(name = "id")
    private long id;

    public ImagesPK() {
    }

    public ImagesPK(long idCar, long id) {
        this.idCar = idCar;
        this.id = id;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCar;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagesPK)) {
            return false;
        }
        ImagesPK other = (ImagesPK) object;
        if (this.idCar != other.idCar) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.ImagesPK[ idCar=" + idCar + ", id=" + id + " ]";
    }
    
}
