package com.ecomarket.msvc.boleta.msvc_boleta.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class errorDTO {

    private Integer status;
    private Date date;

    private Map<String, String>errors;

    @Override
    public String toString(){
        return "{"+
                "status" + status+
                ", date=" + date +
                ", errors=" + errors +
                "}";
    }
}
