package com.ies.blueberry.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //An entity represents a table stored in a database
@Table(name = "location") 
public class Location {
    @Id //The ID will be auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unitloss", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=UnitLoss.class)
    private List<UnitLoss> unitloss;

    @Column(name = "netharvest", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=NetHarvest.class)
    private List<NetHarvest> netharvest;

    @Column(name = "plantationtemperature", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=PlantationTemperature.class)
    private List<PlantationTemperature> plantationtemperature;

    @Column(name = "soilph", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=SoilPH.class)
    private List<SoilPH> soilph;

    @Column(name = "soilwatertension", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=SoilWaterTension.class)
    private List<SoilWaterTension> soilwatertension;

    @Column(name = "storagehumidity", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=StorageHumidity.class)
    private List<StorageHumidity> storagehumidity;

    @Column(name = "storagetemperature", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    //@ElementCollection(targetClass=StorageTemperature.class)
    private List<StorageTemperature> storagetemperature;

    @Column(name = "timestamp", nullable = false)
    private Long timestamp;

    public Location() {}

    public Location(String name,Long timestamp)
    {
        this.name = name;
        this.unitloss = new ArrayList<UnitLoss>();
        this.netharvest = new ArrayList<NetHarvest>();
        this.plantationtemperature = new ArrayList<PlantationTemperature>();
        this.soilph = new ArrayList<SoilPH>();
        this.soilwatertension = new ArrayList<SoilWaterTension>();
        this.storagehumidity = new ArrayList<StorageHumidity>();
        this.storagetemperature = new ArrayList<StorageTemperature>();
        this.timestamp = timestamp;
    }

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitLoss> getUnitLosses() {
        return this.unitloss;
    }

    public void setUnitLoss(UnitLoss ul) {
        this.unitloss.add(ul);
    }

    
    public List<NetHarvest> getNetHarvests() {
        return this.netharvest;
    }

    public void setNetHarvest(NetHarvest nh) {
        this.netharvest.add(nh);
    }

    public List<PlantationTemperature> getPlantationTemperatures() {
        return this.plantationtemperature;
    }

    public void setPlantationTemperature(PlantationTemperature pt) {
        this.plantationtemperature.add(pt);
    }

    public List<SoilPH> getSoilPHs() {
        return this.soilph;
    }

    public void setSoilPH(SoilPH sp) {
        this.soilph.add(sp);
    }

    public List<SoilWaterTension> getSoilWaterTensions() {
        return this.soilwatertension;
    }

    public void setSoilWaterTension(SoilWaterTension swt) {
        this.soilwatertension.add(swt);
    }

    public List<StorageHumidity> getStorageHumidities() {
        return this.storagehumidity;
    }

    public void setStorageHumidity(StorageHumidity sh) {
        this.storagehumidity.add(sh);
    }

    public List<StorageTemperature> getStorageTemperatures() {
        return this.storagetemperature;
    }

    public void setStorageTemperature(StorageTemperature st) {
        this.storagetemperature.add(st);
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", unitloss='" + getUnitLosses() + "'" +
           // ", netharvest='" + getNetHarvests() + "'" +
            ", plantationtemperature='" + getPlantationTemperatures() + "'" +
            ", soilph='" + getSoilPHs() + "'" +
            ", soilwatertension='" + getSoilWaterTensions() + "'" +
            ", storagehumidity='" + getStorageHumidities() + "'" +
            ", storagetemperature='" + getStorageTemperatures() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }

}