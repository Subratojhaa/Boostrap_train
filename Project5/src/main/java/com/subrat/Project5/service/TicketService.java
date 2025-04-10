package com.subrat.Project5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.Project5.model.Ticket;
import com.subrat.Project5.model.Train;
import com.subrat.Project5.repository.TicketRepository;
import com.subrat.Project5.repository.TrainRepository;

@Service
public class TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;
    
    public Ticket bookTicket(String fromStation, String toStation, String passengerName, int noOfTickets, String travelDate) {
        // Generate a booking reference number (this could be more complex)
        String bookingReferenceNumber = "TICKET-" + System.currentTimeMillis();

        Ticket ticket = new Ticket();
        ticket.setFromStation(fromStation);
        ticket.setToStation(toStation);
        ticket.setPassengerName(passengerName);
        ticket.setNoOfTickets(noOfTickets);
        ticket.setTravelDate(travelDate);
        ticket.setBookingReferenceNumber(bookingReferenceNumber);
        
        //ticket booking logic
        // Fetch the train for the given route and travel date
        List<Train> trains = trainRepository.findBySourceStationAndDestinationStationAndTravelDate(fromStation, toStation, travelDate);
        
       Optional<Train> train= trains.stream().findFirst();
        
       Train trainNew=null;;
       if(train.isPresent()) {
    	   trainNew=train.get();
    	   
    	   if(trainNew.getAvailableSeats()>noOfTickets) {
    	         trainNew.setAvailableSeats(trainNew.getAvailableSeats()-noOfTickets);
    	         trainRepository.save(trainNew);
    	   }
       }
       
        
        // Save ticket in database
        return ticketRepository.save(ticket);
    }
    
    // Logic for checking availability
    public String checkAvailability(String fromStation, String toStation, String travelDate) {
        // Here you should ideally query your database to get available tickets
        List<Ticket> tickets = ticketRepository.findByFromStationAndToStationAndTravelDate(fromStation, toStation, travelDate);

        if (tickets.isEmpty()) {
            return "No available tickets for this route on the given date.";
        } else {
            return "Tickets are available for this route.";
        }
    }
    
    
    public Ticket getTicketByReferenceNumber(String bookingReferenceNumber) {
        return ticketRepository.findByBookingReferenceNumber(bookingReferenceNumber);
    }
}