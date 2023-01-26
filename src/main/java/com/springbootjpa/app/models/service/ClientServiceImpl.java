package com.springbootjpa.app.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootjpa.app.models.entity.Client;
import com.springbootjpa.app.models.dao.ClientDao;

@Service
public class ClientServiceImpl implements ClientService {
  private ClientDao clientRepository;

  public ClientServiceImpl(ClientDao clientRepository) {
    this.clientRepository = clientRepository;
  }

  
  @Override
  @Transactional(readOnly = true)
  public List<Client> findAll() {
    return (List<Client>) clientRepository.findAll();
  }

  @Override
  @Transactional
  public void save(Client client) {
    clientRepository.save(client);
  }
}
