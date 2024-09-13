package com.WpCorp.DsConcorcio.Service.Exception;

import lombok.*;

import java.time.Instant;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardException {
    private Instant timeStamp;
    private String path;
    private Integer status;
    private String message;
}
