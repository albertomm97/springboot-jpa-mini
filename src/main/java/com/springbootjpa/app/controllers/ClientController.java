package com.springbootjpa.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootjpa.app.models.entity.Client;
import com.springbootjpa.app.models.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
  
  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping({"", "/all"}) 
  public String listClients(Model model) {

    List<Client> clients = clientService.findAll();

    model.addAttribute("title", "Client List");
    model.addAttribute("clients", clients);

    return "listClients";
  }

  @PostMapping("/create")
  public String create(@RequestParam(value = "name") String name, 
                       @RequestParam(value = "surname") String surname, 
                       @RequestParam(value = "email") String email, 
                       Model model) {


    clientService.save(new Client(name, surname, email));
    
    return "listClients";
  }
}
