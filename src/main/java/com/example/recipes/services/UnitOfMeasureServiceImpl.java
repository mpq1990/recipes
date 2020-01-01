package com.example.recipes.services;

import com.example.recipes.commands.UnitOfMeasureCommand;
import com.example.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.recipes.model.UnitOfMeasure;
import com.example.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        Iterable<UnitOfMeasure> uoms = unitOfMeasureRepository.findAll();
        return StreamSupport.stream(uoms.spliterator(), false).
                map(unitOfMeasureToUnitOfMeasureCommand::convert).
                collect(Collectors.toSet());
    }
}
