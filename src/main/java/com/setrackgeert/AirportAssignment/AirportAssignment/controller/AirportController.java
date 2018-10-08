package com.setrackgeert.AirportAssignment.AirportAssignment.controller;

import com.setrackgeert.AirportAssignment.AirportAssignment.models.Airport;
import com.setrackgeert.AirportAssignment.AirportAssignment.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airport/")
public class AirportController
{
    @Autowired
    private AirportRepository airportRepository;

        // POST method to create new Airport
        @RequestMapping(method = RequestMethod.POST)
        public Airport create(@RequestBody Airport newAirport)
        {
            this.airportRepository.save(newAirport);
            return newAirport;
        }

        // GET method to retrieve ALL Airports
        @RequestMapping(method = RequestMethod.GET)
        public Iterable<Airport> getAllAirports()
        {
            return this.airportRepository.findAll();
        }

        // GET method to retrieve individual Airports by ID
        @RequestMapping(value = "{id}", method = RequestMethod.GET)
        public Optional<Airport> getAirportsById(@PathVariable long id)
        {
            Optional<Airport> result = airportRepository.findById(id);
            return result;
        }

        // PUT method to update individual Airport by ID
        @RequestMapping(value = "{id}", method = RequestMethod.PUT)
        public Airport updateById(@PathVariable long id, @RequestBody Airport update)
        {
            if(airportRepository.existsById(id))
            {
                update.setId(id);
                return airportRepository.save(update);
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
            this.airportRepository.deleteById(id);
        }
}
