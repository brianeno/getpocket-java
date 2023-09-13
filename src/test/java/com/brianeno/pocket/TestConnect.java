package com.brianeno.pocket;

import com.brianeno.pocket.read.DetailType;
import com.brianeno.pocket.read.GetItemsCommand;
import com.brianeno.pocket.read.GetItemsResult;
import com.brianeno.pocket.read.PocketEntry;
import com.brianeno.pocket.read.Sort;

import java.io.IOException;
import java.util.List;

public class TestConnect {

    public static void main(String[] args) throws IOException {
        // given
        String consumerKey = "<your key>";
        PocketAuthFactory factory = PocketAuthFactory.create(consumerKey, "https://getpocket.com/");
        String authCode = factory.getCode();
        String authorizationUrl = factory.getAuthUrl();
        System.out.println(authorizationUrl);
        // click on URL and proceed
        // set breakpoint after so can accept before the following line
        PocketAuth pocketAuth = PocketAuthFactory.createForCode(consumerKey, authCode);
        PocketMain pocketMain = new PocketMain(pocketAuth);
        int total = 100;
        int offset = 0;
        int loops = 0;
        int numRead = 0;
        while (true) {
            loops++;
            GetItemsCommand cmd = new GetItemsCommand.Builder()
                    .count(total)
                    .detailType(DetailType.complete)
                    .sort(Sort.newest)
                    .offset(offset)
                    .search("webflux")
                    .build();
            GetItemsResult getResult = pocketMain.getItems(cmd);
            List<PocketEntry> items = getResult.getList();
            System.out.println(items);
            if (items != null) {
                loops++;
                numRead = numRead + items.size();
                offset = offset + total;
                for(PocketEntry item : items) {
                    System.out.println(item.getResolvedTitle());
                }
                if (items.size() != total) {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Read " + numRead + "items in " + loops + " attempts");
    }
}
