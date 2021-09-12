package com.vnoxiaene.gokustore.address.mapper;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import com.vnoxiaene.gokustore.address.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressDTO entityToDTO(Address address);
    Address dtoToEntity(AddressDTO addressDTO);
}
