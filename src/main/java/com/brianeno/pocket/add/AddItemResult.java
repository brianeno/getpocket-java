package com.brianeno.pocket.add;

import com.brianeno.pocket.read.PocketEntry;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class AddItemResult {

    private final int status;
    private final PocketEntry item;

    public AddItemResult(int status, PocketEntry item) {
        this.status = status;
        this.item = item;
    }
}
