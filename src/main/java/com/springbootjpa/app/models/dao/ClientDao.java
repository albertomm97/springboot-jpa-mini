package com.springbootjpa.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springbootjpa.app.models.entity.Client;

public interface ClientDao extends CrudRepository<Client, Long> {
  @Query("select kdfjskadfjksadfjklsdaf")
  Client findClientByEmailAndName(String email, String name);
}