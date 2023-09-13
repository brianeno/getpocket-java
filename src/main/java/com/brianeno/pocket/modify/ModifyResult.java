package com.brianeno.pocket.modify;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class ModifyResult {

    private final List<Boolean> actionResults;
    private final Integer status;

    public ModifyResult(List<Boolean> actionResults, Integer status) {
        this.actionResults = actionResults;
        this.status = status;
    }
}
