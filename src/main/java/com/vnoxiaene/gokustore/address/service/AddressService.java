package com.vnoxiaene.gokustore.address.service;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);
    void update(UUID id, AddressDTO addressDTO);
    void delete(UUID id);
    List<AddressDTO> findAllAddressesByCEP(String cep);
    List<AddressDTO> findAddressesWithPaginationByCEP(String cep, Pageable pageable);


}
