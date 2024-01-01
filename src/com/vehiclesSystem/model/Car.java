package com.vehiclesSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@Scope("prototype")
public class Car implements Vehicle{

    private String id;
    private String brand;
    private Type type;


}
