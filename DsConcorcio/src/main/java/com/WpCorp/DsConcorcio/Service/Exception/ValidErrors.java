package com.WpCorp.DsConcorcio.Service.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidErrors extends StandardException {
    private Set<FieldMessage> fieldsErros = new HashSet<>();




    public void addFields(String fieldName, String message) {
        fieldsErros.add(new FieldMessage(fieldName, message));
    }
}
