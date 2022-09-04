package com.blz.techstackservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeckStackResponse {
    private int errorcode;
    private String message;
    private Object token;
}
