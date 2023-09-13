package com.brianeno.pocket.add;

import com.brianeno.pocket.AuthorizedCommand;

import java.util.List;

public class AddItemCommand extends AuthorizedCommand {
    private final String url;
    private final String title;
    private final String tags;
    private final String tweet_id;

    private AddItemCommand(String url, String title, String tags, String tweetId) {
        this.url = url;
        this.title = title;
        this.tags = tags;
        this.tweet_id = tweetId;
    }

    public static class Builder {
        private final String url;
        private String title;
        private String tags;
        private String tweetId;

        public Builder(String url) {
            this.url = url;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(List<String> tags) {
            if (tags != null) {
                this.tags = String.join(",", tags);
            }
            return this;
        }

        public Builder tweetId(String tweetId) {
            this.tweetId = tweetId;
            return this;
        }

        public AddItemCommand build() {
            return new AddItemCommand(url, title, tags, tweetId);
        }
    }
}
