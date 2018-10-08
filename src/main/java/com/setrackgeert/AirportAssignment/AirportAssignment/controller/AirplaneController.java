package com.setrackgeert.AirportAssignment.AirportAssignment.controller;

import com.setrackgeert.AirportAssignment.AirportAssignment.models.Airplane;
import com.setrackgeert.AirportAssignment.AirportAssignment.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airplane/")
public class AirplaneController
{
    @Autowired
    private AirplaneRepository airplaneRepository;

    //    @ManyToMany
//    @NotNull
//    private List <Airport> airportList;

    // POST method to create new Airplanes
    @RequestMapping(method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane newAirplane)
    {
        this.airplaneRepository.save(newAirplane);
        return newAirplane;
    }
    // GET method to retrieve ALL Airplanes
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airplane> getAllAirplanes()
    {
        return this.airplaneRepository.findAll();
    }

    // GET method to retrieve individual Airplanes by ID
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Airplane> getAirplanesById(@PathVariable long id)
    {
        Optional<Airplane> result = airplaneRepository.findById(id);
        return result;
    }

    // PUT method to update individual Airplanes by ID
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Airplane updateById(@PathVariable long id, @RequestBody Airplane update)
    {
        if(airplaneRepository.existsById(id))
        {
            update.setId(id);
            return airplaneRepository.save(update);
        }
        else
        {
            throw new RuntimeException();
        }
    }

    // DELETE method to delete individual Airplanes by ID
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable long id)
    {
        this.airplaneRepository.deleteById(id);
    }
}
