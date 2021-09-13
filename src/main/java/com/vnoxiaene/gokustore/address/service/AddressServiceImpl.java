package com.vnoxiaene.gokustore.address.service;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import com.vnoxiaene.gokustore.address.exception.IdNotFoundException;
import com.vnoxiaene.gokustore.address.mapper.AddressMapper;
import com.vnoxiaene.gokustore.address.model.Address;
import com.vnoxiaene.gokustore.address.repository.AddressRepository;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Tentando salvar o endereço: {}", addressDTO);
        Address address = AddressMapper.ADDRESS_MAPPER.dtoToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return AddressMapper.ADDRESS_MAPPER.entityToDTO(savedAddress);
    }

    @Override
    public void update(UUID id,AddressDTO addressDTO) {
        if(addressDTO.getId() == null){
            throw new IdNotFoundException("Para atualizar o endereco é necessário o id");
        }else{
            Optional<Address> optionalAddress = addressRepository.findById(id);
            if(optionalAddress.isPresent()){
                var address = AddressMapper.ADDRESS_MAPPER.dtoToEntity(addressDTO);
                addressRepository.save(address);
            }
        }
    }

    @Override
    public void delete(UUID id) {
        log.debug("Tentando apagar o endereco com id, {}", id);
        if(id == null){
            throw new IdNotFoundException("Para deletar o endereco é necessário o id");
        }else{
            Optional<Address> optionalAddress = addressRepository.findById(id);
            optionalAddress.ifPresent(addressRepository::delete);
        }
    }

    @Override
    public List<AddressDTO> findAllAddressesByCEP(String cep) {
        List<Address> addressesByCEP = addressRepository.findAllAddressesByCEP(cep);
        List<AddressDTO> addressDTOS = addressesByCEP.stream().map(AddressMapper.ADDRESS_MAPPER::entityToDTO).collect(Collectors.toUnmodifiableList());
        return addressDTOS;
    }

    @Override
    public List<AddressDTO> findAddressesWithPaginationByCEP(String cep, Pageable pageable) {
        Page<Address> addressPage = addressRepository.findByCep(cep, pageable);
        List<AddressDTO> collect = addressPage.getContent().stream().map(AddressMapper.ADDRESS_MAPPER::entityToDTO).collect(Collectors.toList());
        return collect;
    }
}
