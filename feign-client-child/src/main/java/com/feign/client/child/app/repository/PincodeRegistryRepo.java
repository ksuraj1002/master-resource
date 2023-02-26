package com.feign.client.child.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feign.client.child.app.entity.PincodeRegistry;

@Repository
public interface PincodeRegistryRepo extends JpaRepository<PincodeRegistry, Integer> {

}
