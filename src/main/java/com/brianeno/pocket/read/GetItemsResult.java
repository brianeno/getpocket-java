package com.brianeno.pocket.read;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public class GetItemsResult {

    private final int status;
    private final int complete;
    private final Map<String, PocketEntry> list;
    private final long since;

    public GetItemsResult(int status, int complete, Map<String, PocketEntry> list, long since) {
        this.status = status;
        this.complete = complete;
        this.list = list;
        this.since = since;
    }

    public List<PocketEntry> getList() {
        return Collections.unmodifiableList(new ArrayList<>(list.values()));
    }
}
