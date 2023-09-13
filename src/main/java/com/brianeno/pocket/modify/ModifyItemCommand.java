package com.brianeno.pocket.modify;

import com.brianeno.pocket.AuthorizedCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModifyItemCommand extends AuthorizedCommand {

    private final List<Map<String, Object>> actions;

    private ModifyItemCommand(List<Map<String, Object>> actions) {
        this.actions = actions;
    }

    public static class Builder {
        private final List<Map<String, Object>> actions = new ArrayList<>();

        public Builder() {
        }

        public Builder action(ModifyAction action) {
            actions.add(action.toMap());
            return this;
        }

        public ModifyItemCommand build() {
            return new ModifyItemCommand(actions);
        }
    }
}
