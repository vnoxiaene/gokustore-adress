package com.vnoxiaene.gokustore.address.repository;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import com.vnoxiaene.gokustore.address.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    @Query("select a from Address a where a.cep =:cep")
    List<Address> findAllAddressesByCEP(@RequestParam("cep") String cep);

    Page<Address> findByCep(String cep, Pageable pageable);




}
