package com.WpCorp.DsConcorcio.Service.Exception;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ValidErrors extends StandardException {
    private Set<FieldMessage> fieldsErros = new HashSet<>();

    public ValidErrors(Instant timeStamp, String path, Integer status, String message) {
        super(timeStamp, path, status, message);
    }

    public void addFields(String fieldName, String message) {
        fieldsErros.add(new FieldMessage(fieldName, message));
    }
}
