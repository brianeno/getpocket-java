package com.brianeno.pocket;

import com.brianeno.pocket.read.DetailType;
import com.brianeno.pocket.read.GetItemsCmd;
import com.brianeno.pocket.read.GetItemsResult;
import com.brianeno.pocket.read.PocketItem;
import com.brianeno.pocket.read.Sort;

import java.io.IOException;
import java.util.List;

public class TestConnect {

    public static void main(String[] args) throws IOException {
        // given
        String consumerKey = "<<>>>>";
        PocketAuthFactory factory = PocketAuthFactory.create(consumerKey, "https://getpocket.com/");
        String authCode = factory.getCode();
        String authorizationUrl = factory.getAuthUrl();
        System.out.println(authorizationUrl);
        // click on URL and proceed
        // set breakpoint after so can accept before the following line
        PocketAuth pocketAuth = PocketAuthFactory.createForCode(consumerKey, authCode);
        Pocket pocket = new Pocket(pocketAuth);
        int total = 100;
        int offset = 0;
        int loops = 0;
        while (true) {
            GetItemsCmd cmd = new GetItemsCmd.Builder()
                    .count(total)
                    .detailType(DetailType.complete)
                    .sort(Sort.newest)
                    .offset(offset)
                    .build();
            GetItemsResult getResult = pocket.getItems(cmd);
            List<PocketItem> items = getResult.getList();
            System.out.println(items);
            if (items != null) {
                loops++;
                offset = offset + total;
                if (items.size() != total) {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Read " + (total * loops));
    }
}
