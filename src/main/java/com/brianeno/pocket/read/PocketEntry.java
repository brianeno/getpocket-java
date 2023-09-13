package com.brianeno.pocket.read;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@ToString
@EqualsAndHashCode
public class PocketEntry {

    private final String itemId;
    private final String resolvedId;
    private final String givenUrl;
    private final String givenTitle;
    private final short favorite;
    private final short status;
    private final long timeAdded;
    private final long timeUpdated;
    private final long timeRead;
    private final long timeFavorited;
    private final String resolvedTitle;
    private final String resolvedUrl;
    private final String excerpt;
    private final short isArticle;
    private final short isIndex;
    private final short hasVideo;
    private final short hasImage;
    private final int wordCount;
    private final String lang;
    private final String topImageUrl;
    private final long listenDurationEstimate;
    private final DomainMeta domainMetadata;
    private final Map<String, ItemTag> tags;
    private final Map<String, Image> images;
    private final Map<String, Video> videos;

    public PocketEntry(String itemId, String resolvedId, String givenUrl, String givenTitle, short favorite,
                       short status, long timeAdded, long timeUpdated, long timeRead, long timeFavorited, String resolvedTitle,
                       String resolvedUrl, String excerpt, short isArticle, short isIndex, short hasVideo, short hasImage,
                       int wordCount, String lang, String topImageUrl, long listenDurationEstimate, DomainMeta domainMetadata,
                       Map<String, ItemTag> tags, Map<String, Image> images, Map<String, Video> videos) {
        this.itemId = itemId;
        this.resolvedId = resolvedId;
        this.givenUrl = givenUrl;
        this.givenTitle = givenTitle;
        this.favorite = favorite;
        this.status = status;
        this.timeAdded = timeAdded;
        this.timeUpdated = timeUpdated;
        this.timeRead = timeRead;
        this.timeFavorited = timeFavorited;
        this.resolvedTitle = resolvedTitle;
        this.resolvedUrl = resolvedUrl;
        this.excerpt = excerpt;
        this.isArticle = isArticle;
        this.isIndex = isIndex;
        this.hasVideo = hasVideo;
        this.hasImage = hasImage;
        this.wordCount = wordCount;
        this.lang = lang;
        this.topImageUrl = topImageUrl;
        this.listenDurationEstimate = listenDurationEstimate;
        this.domainMetadata = domainMetadata;
        this.tags = tags;
        this.images = images;
        this.videos = videos;
    }

    public LocalDateTime getTimeAdded() {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timeAdded), ZoneId.of("UTC"));
    }

    public LocalDateTime getTimeUpdated() {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timeUpdated), ZoneId.of("UTC"));
    }

    public Optional<LocalDateTime> getTimeRead() {
        return Optional.of(timeRead)
                .map(t -> t == 0 ? null : LocalDateTime.ofInstant(Instant.ofEpochSecond(timeRead), ZoneId.of("UTC")));
    }

    public Optional<LocalDateTime> getTimeFavorited() {
        return Optional.of(timeFavorited)
                .map(t -> t == 0 ? null : LocalDateTime.ofInstant(Instant.ofEpochSecond(timeFavorited), ZoneId.of("UTC")));
    }

    public List<ItemTag> getTags() {
        return Optional.ofNullable(tags)
                .map(i -> Collections.unmodifiableList(new ArrayList<>(i.values())))
                .orElse(Collections.emptyList());
    }

    public List<Image> getImages() {
        return Optional.ofNullable(images)
                .map(i -> Collections.unmodifiableList(new ArrayList<>(i.values())))
                .orElse(Collections.emptyList());
    }

    public List<Video> getVideos() {
        return Optional.ofNullable(videos)
                .map(i -> Collections.unmodifiableList(new ArrayList<>(i.values())))
                .orElse(Collections.emptyList());
    }
}
