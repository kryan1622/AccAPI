package com.bae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
