package com.brianeno.pocket.modify;

public class UnarchiveAction extends ModifyAction {

    protected UnarchiveAction(String itemId) {
        super("readd");
        addAttribute("item_id", itemId);
    }
}
