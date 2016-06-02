/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blanusal
 */
@Entity
@Table(name = "automobil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automobil.findAll", query = "SELECT a FROM Automobil a"),
    @NamedQuery(name = "Automobil.findById", query = "SELECT a FROM Automobil a WHERE a.id = :id"),
    @NamedQuery(name = "Automobil.findByModel", query = "SELECT a FROM Automobil a WHERE a.model = :model"),
    @NamedQuery(name = "Automobil.findByProizvodjac", query = "SELECT a FROM Automobil a WHERE a.proizvodjac = :proizvodjac"),
    @NamedQuery(name = "Automobil.findByCena", query = "SELECT a FROM Automobil a WHERE a.cena = :cena"),
    @NamedQuery(name = "Automobil.findByBoja", query = "SELECT a FROM Automobil a WHERE a.boja = :boja"),
    @NamedQuery(name = "Automobil.findByBrojVrata", query = "SELECT a FROM Automobil a WHERE a.brojVrata = :brojVrata"),
    @NamedQuery(name = "Automobil.findByGorivo", query = "SELECT a FROM Automobil a WHERE a.gorivo = :gorivo"),
    @NamedQuery(name = "Automobil.findByMenjac", query = "SELECT a FROM Automobil a WHERE a.menjac = :menjac"),
    @NamedQuery(name = "Automobil.findByKlima", query = "SELECT a FROM Automobil a WHERE a.klima = :klima"),
    @NamedQuery(name = "Automobil.findByRegistrovanDo", query = "SELECT a FROM Automobil a WHERE a.registrovanDo = :registrovanDo"),
    @NamedQuery(name = "Automobil.findByMaterijalEnterijera", query = "SELECT a FROM Automobil a WHERE a.materijalEnterijera = :materijalEnterijera"),
    @NamedQuery(name = "Automobil.findByStranaVolana", query = "SELECT a FROM Automobil a WHERE a.stranaVolana = :stranaVolana"),
    @NamedQuery(name = "Automobil.findByPorekloVozila", query = "SELECT a FROM Automobil a WHERE a.porekloVozila = :porekloVozila"),
    @NamedQuery(name = "Automobil.findByBojaEnterijera", query = "SELECT a FROM Automobil a WHERE a.bojaEnterijera = :bojaEnterijera"),
    @NamedQuery(name = "Automobil.findByOstecenje", query = "SELECT a FROM Automobil a WHERE a.ostecenje = :ostecenje"),
    @NamedQuery(name = "Automobil.findByPogon", query = "SELECT a FROM Automobil a WHERE a.pogon = :pogon")})
public class Automobil implements Serializable {

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
    @Column(name = "proizvodjac")
    private String proizvodjac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private double cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "boja")
    private String boja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "broj_vrata")
    private int brojVrata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "gorivo")
    private String gorivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "menjac")
    private String menjac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "klima")
    private boolean klima;
    @Column(name = "registrovan_do")
    @Temporal(TemporalType.DATE)
    private Date registrovanDo;
    @Size(max = 100)
    @Column(name = "materijal_enterijera")
    private String materijalEnterijera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "strana_volana")
    private String stranaVolana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "poreklo_vozila")
    private String porekloVozila;
    @Size(max = 100)
    @Column(name = "boja_enterijera")
    private String bojaEnterijera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ostecenje")
    private String ostecenje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pogon")
    private String pogon;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "automobil")
    private Slike slike;

    public Automobil() {
    }

    public Automobil(Long id) {
        this.id = id;
    }

    public Automobil(Long id, String model, String proizvodjac, double cena, String boja, int brojVrata, String gorivo, String menjac, boolean klima, String stranaVolana, String porekloVozila, String ostecenje, String pogon) {
        this.id = id;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.boja = boja;
        this.brojVrata = brojVrata;
        this.gorivo = gorivo;
        this.menjac = menjac;
        this.klima = klima;
        this.stranaVolana = stranaVolana;
        this.porekloVozila = porekloVozila;
        this.ostecenje = ostecenje;
        this.pogon = pogon;
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

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    public String getGorivo() {
        return gorivo;
    }

    public void setGorivo(String gorivo) {
        this.gorivo = gorivo;
    }

    public String getMenjac() {
        return menjac;
    }

    public void setMenjac(String menjac) {
        this.menjac = menjac;
    }

    public boolean getKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public Date getRegistrovanDo() {
        return registrovanDo;
    }

    public void setRegistrovanDo(Date registrovanDo) {
        this.registrovanDo = registrovanDo;
    }

    public String getMaterijalEnterijera() {
        return materijalEnterijera;
    }

    public void setMaterijalEnterijera(String materijalEnterijera) {
        this.materijalEnterijera = materijalEnterijera;
    }

    public String getStranaVolana() {
        return stranaVolana;
    }

    public void setStranaVolana(String stranaVolana) {
        this.stranaVolana = stranaVolana;
    }

    public String getPorekloVozila() {
        return porekloVozila;
    }

    public void setPorekloVozila(String porekloVozila) {
        this.porekloVozila = porekloVozila;
    }

    public String getBojaEnterijera() {
        return bojaEnterijera;
    }

    public void setBojaEnterijera(String bojaEnterijera) {
        this.bojaEnterijera = bojaEnterijera;
    }

    public String getOstecenje() {
        return ostecenje;
    }

    public void setOstecenje(String ostecenje) {
        this.ostecenje = ostecenje;
    }

    public String getPogon() {
        return pogon;
    }

    public void setPogon(String pogon) {
        this.pogon = pogon;
    }

    public Slike getSlike() {
        return slike;
    }

    public void setSlike(Slike slike) {
        this.slike = slike;
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
        if (!(object instanceof Automobil)) {
            return false;
        }
        Automobil other = (Automobil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prodaja.automobila.Automobil[ id=" + id + " ]";
    }
    
}
