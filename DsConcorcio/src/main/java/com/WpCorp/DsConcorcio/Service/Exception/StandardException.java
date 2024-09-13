package com.WpCorp.DsConcorcio.Service.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
@AllArgsConstructor
@Builder
public class StandardException {
    private Instant timeStamp;
    private String path;
    private Integer status;
    private String message;
}
