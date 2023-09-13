package com.brianeno.pocket.read;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class DomainMeta {
    private final String name;
    private final String logo;
    private final String greyscaleLogo;

    public DomainMeta(String name, String logo, String greyscaleLogo) {
        this.name = name;
        this.logo = logo;
        this.greyscaleLogo = greyscaleLogo;
    }
}
