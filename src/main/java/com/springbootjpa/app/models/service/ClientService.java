package com.springbootjpa.app.models.service;


import java.util.List;

import com.springbootjpa.app.models.entity.Client;

public interface ClientService {
  public List<Client> findAll();
  public void save(Client client);
}
