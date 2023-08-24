package com.example.transporttrade.controller;

import com.example.transporttrade.entity.Transport;
import com.example.transporttrade.service.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransportController {


    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/")
    public String transport(Model model) {
        model.addAttribute("transports", transportService.list());
        return "transport";
    }

    /**
     * Create Transport
     */
    @GetMapping("/add")
    public String add(Model model) {
        return "transport-add";
    }

    @PostMapping("/add")
    public String addTransport(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String category,
            @RequestParam String number,
            @RequestParam String type,
            @RequestParam int year,
            @RequestParam String trailer,
            Model modelUi
    ) {
        Transport transport = new Transport(brand, model, category, number, type, year, trailer);
        transportService.create(transport);
        return "redirect:/";
    }

    /**
     * Update Transport
     */
    @GetMapping("{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("transport", transportService.getTransportById(id));
        return "transport-edit";
    }

    @PostMapping("{id}/edit")
    public String editTransport(
            @PathVariable(value = "id") long id,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String category,
            @RequestParam String number,
            @RequestParam String type,
            @RequestParam int year,
            @RequestParam String trailer,
            Model modelUi) {
        Transport transport = transportService.getTransportById(id);
        transport.setBrand(brand);
        transport.setModel(model);
        transport.setCategory(category);
        transport.setNumber(number);
        transport.setType(type);
        transport.setYear(year);
        transport.setTrailer(trailer);
        transportService.update(transport);
        return "redirect:/";
    }

    /**
     * Delete Transport
     */
    @PostMapping("{id}")
    public String deleteTransport(@PathVariable(value = "id") long id, Model model) {
        transportService.delete(id);
        return "redirect:/";
    }

    /**
     * Search Transport
     */
    @GetMapping("/search")
    public String search(
            @RequestParam String keyboard,
            Model model) {
        model.addAttribute("keyboard", keyboard);
        model.addAttribute("transports", transportService.search(keyboard));
        return "transport";
    }

    @GetMapping("/filter")
    public String filter(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String category,
            @RequestParam String number,
            @RequestParam String year,
            Model modelUi){
        modelUi.addAttribute("brand", brand);
        modelUi.addAttribute("model", model);
        modelUi.addAttribute("category", category);
        modelUi.addAttribute("number", number);
        modelUi.addAttribute("year", year);
        modelUi.addAttribute("transports", transportService.filter(brand, model, category, number, year));
        return "transport";
    }


}
