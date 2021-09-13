package com.vnoxiaene.gokustore.address.service;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import com.vnoxiaene.gokustore.address.model.Address;
import com.vnoxiaene.gokustore.address.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


class AddressServiceImplTest {

    @Mock
    private AddressRepository repository;
    private AddressServiceImpl addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressService = new AddressServiceImpl(repository);

    }

    @Test
    void shouldReturnSameObjectWhenSaved() {
        AddressDTO addressDTO = AddressDTO.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .build();
        Address address = Address.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .build();
        Address address2 = Address.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        given(repository.save(address)).willReturn(address2);
        AddressDTO addressDTO2 = AddressDTO.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        assertThat(addressDTO2).isEqualTo(addressService.save(addressDTO));
    }

    @Test
    void update() {
        Address address2 = Address.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        given(repository.findById(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))).willReturn(java.util.Optional.ofNullable(address2));
        Address address3 = Address.builder()
                .cep("45839000")
                .bairro("vila nova 2")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        AddressDTO addressDTO2 = AddressDTO.builder()
                .cep("45839000")
                .bairro("vila nova 2")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();

        addressService.update(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"), addressDTO2);
        verify(repository, atLeastOnce()).save(address3);
    }

    @Test
    void delete() {
        Address addressToBeDeleted = Address.builder()
                .cep("45839000")
                .bairro("vila nova 2")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        given(repository.findById(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))).willReturn(java.util.Optional.ofNullable(addressToBeDeleted));
        addressService.delete(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"));
        verify(repository, atLeastOnce()).delete(addressToBeDeleted);
    }

    @Test
    void findAllAddressesByCEP() {
        List<Address> addressList = new ArrayList<>();
        Address address1 = Address.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        Address address2 = Address.builder()
                .cep("45839000")
                .bairro("alegria")
                .cidade("são paulo")
                .numero(304)
                .id(UUID.fromString("95458b57-d1cc-4d60-99ad-c9022389a3c0"))
                .build();
        addressList.add(address1);
        addressList.add(address2);
        List<AddressDTO> addressDTOList = new ArrayList<>();
        AddressDTO addressDTO1 = AddressDTO.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        AddressDTO addressDTO2 = AddressDTO.builder()
                .cep("45839000")
                .bairro("alegria")
                .cidade("são paulo")
                .numero(304)
                .id(UUID.fromString("95458b57-d1cc-4d60-99ad-c9022389a3c0"))
                .build();
        addressDTOList.addAll(Arrays.asList(addressDTO1, addressDTO2));
        given(repository.findAllAddressesByCEP("45839000")).willReturn(addressList);
        assertThat(addressDTOList).isEqualTo(addressService.findAllAddressesByCEP("45839000"));
    }

    @Test
    void findAddressesWithPaginationByCEP() {
        List<Address> addressList = new ArrayList<>();
        Address address1 = Address.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        Address address2 = Address.builder()
                .cep("45839000")
                .bairro("alegria")
                .cidade("são paulo")
                .numero(304)
                .id(UUID.fromString("95458b57-d1cc-4d60-99ad-c9022389a3c0"))
                .build();
        addressList.add(address1);
        addressList.add(address2);
        List<AddressDTO> addressDTOList = new ArrayList<>();
        AddressDTO addressDTO1 = AddressDTO.builder()
                .cep("45839000")
                .bairro("vila nova")
                .cidade("são paulo")
                .numero(444)
                .id(UUID.fromString("fe18f464-40fb-40e3-b9cf-dc5851d1e2d9"))
                .build();
        AddressDTO addressDTO2 = AddressDTO.builder()
                .cep("45839000")
                .bairro("alegria")
                .cidade("são paulo")
                .numero(304)
                .id(UUID.fromString("95458b57-d1cc-4d60-99ad-c9022389a3c0"))
                .build();
        addressDTOList.addAll(Arrays.asList(addressDTO1, addressDTO2));
        Pageable pageable = PageRequest.of(0, 2);
        Page<Address> addressPage = new PageImpl<>(addressList , pageable, 2);
        given(repository.findByCep("45839000",pageable)).willReturn(addressPage);
        assertThat(addressDTOList).isEqualTo(addressService.findAddressesWithPaginationByCEP("45839000", pageable));


    }
}
