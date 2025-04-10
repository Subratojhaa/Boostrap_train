package com.subrat.Project5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.subrat.Project5.model.Ticket;
import com.subrat.Project5.model.Train;
import com.subrat.Project5.service.TicketService;
import com.subrat.Project5.service.TrainService;

@Controller
public class PageControlller {

    @Autowired
    private TicketService ticketService;
    
   @Autowired
   private TrainService trainService;
    
    @GetMapping("/")
    public String home() {
        return "home"; // Points to home.jsp
    }

    @GetMapping("/bookTicketForm")
    public String showBookTicketForm() {
        return "bookTicketForm"; // Points to bookTicketForm.jsp
    }

    @PostMapping("/bookTicketForm")
    public String bookTicket(@RequestParam String fromStation,
                             @RequestParam String toStation,
                             @RequestParam String passengerName,
                             @RequestParam int noOfTickets,
                             @RequestParam String travelDate,
                             Model model) {
        Ticket ticket = ticketService.bookTicket(fromStation, toStation, passengerName, noOfTickets, travelDate);
        model.addAttribute("ticket", ticket);  // Add ticket data to model
        return "ticketConfirmation";  // Redirect to ticketConfirmation.jsp
    }
    
    @GetMapping("/ticketConfirmation")
    public String showTicketConfirmation() {
        return "ticketConfirmation";  // This returns the ticketConfirmation.jsp
    }
    
    
   
    
    @GetMapping("/checkAvailability")
    public String showCheckAvailabilityForm() {
        return "checkAvailability"; // Displays the form
    }

    
    @PostMapping("/checkAvailability")
    public String checkTrainAvailabilityy(@RequestParam String sourceStation,
                                         @RequestParam String destinationStation,
                                         @RequestParam String travelDate,
                                         Model model) {
    	
        // Fetch available trains
        List<Train> availableTrains = trainService.checkTrainAvailability(sourceStation, destinationStation, travelDate);
     
        // Add the available trains to the model to be displayed in JSP
        model.addAttribute("availableTrains", availableTrains);
        return "availabilityResult";  // This will display the results on the next JSP page
    }
    
    
    @PostMapping("/checkTicket")
    public String viewTicket(@RequestParam String bookingReferenceNumber, Model model) {
        // Fetch ticket by bookingReferenceNumber
        Ticket ticket = ticketService.getTicketByReferenceNumber(bookingReferenceNumber);

        if (ticket != null) {
            // If ticket is found, add to the model
            model.addAttribute("ticket", ticket);
        } else {
            // If no ticket is found, add a message to the model
            model.addAttribute("message", "Ticket not found.");
        }

        return "viewTicket";  // Return the view ticket page
    }
    
    @GetMapping("/viewTicket")
    public String checkTick() {
    	return "viewTicket";
    }


}
