package com.ies.blueberry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.blueberry.exception.ResourceNotFoundException;
import com.ies.blueberry.model.NetHarvest;
import com.ies.blueberry.model.Alert;
import com.ies.blueberry.model.Location;
import com.ies.blueberry.model.PlantationTemperature;
import com.ies.blueberry.model.SoilPH;
import com.ies.blueberry.model.SoilWaterTension;
import com.ies.blueberry.model.StorageHumidity;
import com.ies.blueberry.model.StorageTemperature;
import com.ies.blueberry.model.UnitLoss;
import com.ies.blueberry.service.AllDataService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private AllDataService dataServ;


    @GetMapping("/locations")
    public List<Location> getLocations() {
        return dataServ.getLocations();
    }

    @PostMapping("/locations")
    public Location saveLocation(@Valid @RequestBody Location l) {
        return dataServ.saveLocation(l);
    }

    @GetMapping("/locations/{location}") 
    public ResponseEntity<Location> getLocationByName(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        Location l = dataServ.getLocationByName(location);
        if(l==null) {
            throw new ResourceNotFoundException("Location not found for this name :: " + location);
        }
        return ResponseEntity.ok().body(l);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAllAlerts() throws ResourceNotFoundException {
        List<Alert> alerts = dataServ.getAlerts();
        if(alerts == null) { throw new ResourceNotFoundException("Alerts not found"); }
        return ResponseEntity.ok().body(alerts);
    }

    @PostMapping("/alerts")
    public Alert createAlert(@Valid @RequestBody Alert a) {
        return dataServ.saveAlert(a);
    }

    @DeleteMapping("/alerts/{id}")
    public void deleteAlert(@PathVariable(value = "id") String s_id) {
        try {
            long id = Long.parseLong(s_id);
            dataServ.deleteAlert(id);
        } 
        catch(NumberFormatException e) { System.out.println("Oh naur");}
    }

    @DeleteMapping("/alerts")
    public void clearAlerts() {
        dataServ.deleteAllAlerts();
    }

    @GetMapping("/{location}/{sensor}/alert")
    public ResponseEntity<List<Alert>> getAlertByLocationAndSensor(
        @PathVariable(value = "location") String location, @PathVariable(value = "sensor") String sensor) 
    throws ResourceNotFoundException {
        List<Alert> alerts = dataServ.getAlertByLocationAndSensor(location, sensor);
        if(alerts==null){
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(alerts);
    }

    @PostMapping("/{location}/{sensor}/alert")
    public Alert createAlert(@Valid @RequestBody Alert a, @PathVariable(value = "location") String location, @PathVariable(value = "sensor") String sensor) {
        return dataServ.saveAlert(a);
    }

    //Plantation Temperature

    @GetMapping("/{location}/plantation_temperature") 
    public ResponseEntity<List<PlantationTemperature>> getPlantationTemperatureByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<PlantationTemperature> plantationtemperature = dataServ.getPlantationTemperatureByLocation(location);
        System.out.println("AQUI");
        System.out.println(plantationtemperature);
        if(plantationtemperature==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(plantationtemperature);
    }

    @PostMapping("/{location}/plantation_temperature")
    public PlantationTemperature createPlantationTemperature(@Valid @RequestBody PlantationTemperature temp,@PathVariable(value = "location") String location) {
        return dataServ.savePlantationTemperature(temp,location);
    }

    //Net Harvest    

    @GetMapping("/{location}/net_harvest")
    public ResponseEntity<List<NetHarvest>> getNetHarvestByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<NetHarvest> netharvest = dataServ.getNetHarvestByLocation(location);
        if(netharvest==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(netharvest);
    }

    @PostMapping("/{location}/net_harvest")
    public NetHarvest createNetHarvest(@Valid @RequestBody NetHarvest netHarv,@PathVariable(value = "location") String location) {
        return dataServ.saveNetHarvest(netHarv,location);
    }

    //Soil pH
    @GetMapping("/{location}/soil_ph")
    public ResponseEntity<List<SoilPH>> getSoilPHByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<SoilPH> soilPH = dataServ.getSoilPHByLocation(location);
        if(soilPH==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(soilPH);
    }

    @PostMapping("/{location}/soil_ph")
    public SoilPH createSoilPH(@Valid @RequestBody SoilPH soilph,@PathVariable(value = "location") String location) {
        return dataServ.saveSoilPH(soilph,location);
    }

    //Soil Water Tension

    @GetMapping("/{location}/soil_water_tension")
    public ResponseEntity<List<SoilWaterTension>> getSoilWaterTensionByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<SoilWaterTension> soilwt = dataServ.getSoilWaterTensionByLocation(location);
        if(soilwt==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(soilwt);
    }

    @PostMapping("/{location}/soil_water_tension")
    public SoilWaterTension createSoilWaterTension(@Valid @RequestBody SoilWaterTension soilwt,@PathVariable(value = "location") String location) {
        return dataServ.saveSoilWaterTensions(soilwt,location);
    }

    //Unit Loss
    @GetMapping("/{location}/unit_loss")
    public ResponseEntity<List<UnitLoss>> getUnitLossByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<UnitLoss> unitloss = dataServ.getUnitLossByLocation(location);
        if(unitloss==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(unitloss);
    }

    @PostMapping("/{location}/unit_loss")
    public UnitLoss createUnitLoss(@Valid @RequestBody UnitLoss ul,@PathVariable(value = "location") String location) {
        return dataServ.saveUnitLoss(ul,location);
    }

    //Storage Temperature

    @GetMapping("/{location}/storage_temperature")
    public ResponseEntity<List<StorageTemperature>> getStorageTemperatureByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<StorageTemperature> storageTemperature = dataServ.getStorageTemperatureByLocation(location);
        if(storageTemperature==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(storageTemperature);
    }

    @PostMapping("/{location}/storage_temperature")
    public StorageTemperature createSTemperature(@Valid @RequestBody StorageTemperature st,@PathVariable(value = "location") String location) {
        return dataServ.saveStorageTemperature(st,location);
    }

    //Storage Humidity

    @GetMapping("/{location}/storage_humidity")
    public ResponseEntity<List<StorageHumidity>> getStorageHumidityByLocation(@PathVariable(value = "location") String location)
        throws ResourceNotFoundException {
        List<StorageHumidity> storageHumidity = dataServ.getStorageHumidityByLocation(location);
        if(storageHumidity==null)
        {
            throw new ResourceNotFoundException("Location not found for this id :: " + location);
        }
        return ResponseEntity.ok().body(storageHumidity);
    }

    @PostMapping("/{location}/storage_humidity")
    public StorageHumidity createSHumidity(@Valid @RequestBody StorageHumidity sh,@PathVariable(value = "location") String location) {
        return dataServ.saveStorageHumidity(sh, location);
    }
}
