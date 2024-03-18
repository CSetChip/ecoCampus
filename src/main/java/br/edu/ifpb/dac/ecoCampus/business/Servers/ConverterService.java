package br.edu.ifpb.dac.ecoCampus.business.Servers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private static final ModelMapper modelMapper = new ModelMapper();

    public <E, D> D convertToDTO(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
