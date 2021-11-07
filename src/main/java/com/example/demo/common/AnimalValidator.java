package com.example.demo.common;

import com.example.demo.AnimalForm;
import com.example.demo.AnimalRepository;
import com.example.demo.common.exceptions.AlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AnimalValidator{
    private final AnimalRepository repository;

    public void validate(Object target) {
        AnimalForm form = (AnimalForm) target;
        String name = form.getName();
        if (repository.existsByName(name)) {
            throw new AlreadyExistException(ErrorCode.ANIMAL_ALREADY_EXIST.getErrorMessage(),ErrorCode.ANIMAL_ALREADY_EXIST.getErrorCode());
        }
        return;
    }
}
