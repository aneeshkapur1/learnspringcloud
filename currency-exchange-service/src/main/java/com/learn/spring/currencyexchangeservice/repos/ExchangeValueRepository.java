package com.learn.spring.currencyexchangeservice.repos;

import com.learn.spring.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>


{

  ExchangeValue findByFromAndTo(String from, String to);

}
