package com.markuvinicius.twitter.stream.utils;

import twitter4j.*;

import java.util.Date;

public class TwitterModels {

    public static class Place implements twitter4j.Place{

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getStreetAddress() {
            return null;
        }

        @Override
        public String getCountryCode() {
            return null;
        }

        @Override
        public String getId() {
            return null;
        }

        @Override
        public String getCountry() {
            return "Brazil";
        }

        @Override
        public String getPlaceType() {
            return null;
        }

        @Override
        public String getURL() {
            return null;
        }

        @Override
        public String getFullName() {
            return null;
        }

        @Override
        public String getBoundingBoxType() {
            return null;
        }

        @Override
        public GeoLocation[][] getBoundingBoxCoordinates() {
            return new GeoLocation[0][];
        }

        @Override
        public String getGeometryType() {
            return null;
        }

        @Override
        public GeoLocation[][] getGeometryCoordinates() {
            return new GeoLocation[0][];
        }

        @Override
        public twitter4j.Place[] getContainedWithIn() {
            return new twitter4j.Place[0];
        }

        @Override
        public int compareTo(twitter4j.Place o) {
            return 0;
        }

        @Override
        public RateLimitStatus getRateLimitStatus() {
            return null;
        }

        @Override
        public int getAccessLevel() {
            return 0;
        }
    }

    public static class User implements twitter4j.User{

        @Override
        public long getId() {
            return 0;
        }

        @Override
        public String getName() {
            return "Marku Vinicius";
        }

        @Override
        public String getEmail() {
            return "marku@vinicius.com.br";
        }

        @Override
        public String getScreenName() {
            return "marku";
        }

        @Override
        public String getLocation() {
            return null;
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public boolean isContributorsEnabled() {
            return false;
        }

        @Override
        public String getProfileImageURL() {
            return null;
        }

        @Override
        public String getBiggerProfileImageURL() {
            return null;
        }

        @Override
        public String getMiniProfileImageURL() {
            return null;
        }

        @Override
        public String getOriginalProfileImageURL() {
            return null;
        }

        @Override
        public String getProfileImageURLHttps() {
            return null;
        }

        @Override
        public String getBiggerProfileImageURLHttps() {
            return null;
        }

        @Override
        public String getMiniProfileImageURLHttps() {
            return null;
        }

        @Override
        public String getOriginalProfileImageURLHttps() {
            return null;
        }

        @Override
        public boolean isDefaultProfileImage() {
            return false;
        }

        @Override
        public String getURL() {
            return null;
        }

        @Override
        public boolean isProtected() {
            return false;
        }

        @Override
        public int getFollowersCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public twitter4j.Status getStatus() {
            return null;
        }

        @Override
        public String getProfileBackgroundColor() {
            return null;
        }

        @Override
        public String getProfileTextColor() {
            return null;
        }

        @Override
        public String getProfileLinkColor() {
            return null;
        }

        @Override
        public String getProfileSidebarFillColor() {
            return null;
        }

        @Override
        public String getProfileSidebarBorderColor() {
            return null;
        }

        @Override
        public boolean isProfileUseBackgroundImage() {
            return false;
        }

        @Override
        public boolean isDefaultProfile() {
            return false;
        }

        @Override
        public boolean isShowAllInlineMedia() {
            return false;
        }

        @Override
        public int getFriendsCount() {
            return 0;
        }

        @Override
        public Date getCreatedAt() {
            return new Date();
        }

        @Override
        public int getFavouritesCount() {
            return 0;
        }

        @Override
        public int getUtcOffset() {
            return 0;
        }

        @Override
        public String getTimeZone() {
            return null;
        }

        @Override
        public String getProfileBackgroundImageURL() {
            return null;
        }

        @Override
        public String getProfileBackgroundImageUrlHttps() {
            return null;
        }

        @Override
        public String getProfileBannerURL() {
            return null;
        }

        @Override
        public String getProfileBannerRetinaURL() {
            return null;
        }

        @Override
        public String getProfileBannerIPadURL() {
            return null;
        }

        @Override
        public String getProfileBannerIPadRetinaURL() {
            return null;
        }

        @Override
        public String getProfileBannerMobileURL() {
            return null;
        }

        @Override
        public String getProfileBannerMobileRetinaURL() {
            return null;
        }

        @Override
        public boolean isProfileBackgroundTiled() {
            return false;
        }

        @Override
        public String getLang() {
            return "PT";
        }

        @Override
        public int getStatusesCount() {
            return 0;
        }

        @Override
        public boolean isGeoEnabled() {
            return false;
        }

        @Override
        public boolean isVerified() {
            return false;
        }

        @Override
        public boolean isTranslator() {
            return false;
        }

        @Override
        public int getListedCount() {
            return 0;
        }

        @Override
        public boolean isFollowRequestSent() {
            return false;
        }

        @Override
        public URLEntity[] getDescriptionURLEntities() {
            return new URLEntity[0];
        }

        @Override
        public URLEntity getURLEntity() {
            return null;
        }

        @Override
        public String[] getWithheldInCountries() {
            return new String[0];
        }

        @Override
        public int compareTo(twitter4j.User o) {
            return 0;
        }

        @Override
        public RateLimitStatus getRateLimitStatus() {
            return null;
        }

        @Override
        public int getAccessLevel() {
            return 0;
        }
    }

    public static class Status implements twitter4j.Status{
        @Override
        public Date getCreatedAt() {
            return new Date();
        }

        @Override
        public long getId() {
            return 0;
        }

        @Override
        public String getText() {
            return "Dummy Tweet generated for test only";
        }

        @Override
        public int getDisplayTextRangeStart() {
            return 0;
        }

        @Override
        public int getDisplayTextRangeEnd() {
            return 0;
        }

        @Override
        public String getSource() {
            return null;
        }

        @Override
        public boolean isTruncated() {
            return false;
        }

        @Override
        public long getInReplyToStatusId() {
            return 0;
        }

        @Override
        public long getInReplyToUserId() {
            return 0;
        }

        @Override
        public String getInReplyToScreenName() {
            return null;
        }

        @Override
        public GeoLocation getGeoLocation() {
            return null;
        }

        @Override
        public Place getPlace() {
            return new Place();
        }

        @Override
        public boolean isFavorited() {
            return false;
        }

        @Override
        public boolean isRetweeted() {
            return false;
        }

        @Override
        public int getFavoriteCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public User getUser() {
            return new User();
        }

        @Override
        public boolean isRetweet() {
            return false;
        }

        @Override
        public twitter4j.Status getRetweetedStatus() {
            return null;
        }

        @Override
        public long[] getContributors() {
            return new long[0];
        }

        @Override
        public int getRetweetCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isRetweetedByMe() {
            return false;
        }

        @Override
        public long getCurrentUserRetweetId() {
            return 0;
        }

        @Override
        public boolean isPossiblySensitive() {
            return false;
        }

        @Override
        public String getLang() {
            return "PT";
        }

        @Override
        public Scopes getScopes() {
            return null;
        }

        @Override
        public String[] getWithheldInCountries() {
            return new String[0];
        }

        @Override
        public long getQuotedStatusId() {
            return 0;
        }

        @Override
        public twitter4j.Status getQuotedStatus() {
            return null;
        }

        @Override
        public int compareTo(twitter4j.Status o) {
            return 0;
        }

        @Override
        public UserMentionEntity[] getUserMentionEntities() {
            return new UserMentionEntity[0];
        }

        @Override
        public URLEntity[] getURLEntities() {
            return new URLEntity[0];
        }

        @Override
        public HashtagEntity[] getHashtagEntities() {
            return new HashtagEntity[0];
        }

        @Override
        public MediaEntity[] getMediaEntities() {
            return new MediaEntity[0];
        }

        @Override
        public SymbolEntity[] getSymbolEntities() {
            return new SymbolEntity[0];
        }

        @Override
        public RateLimitStatus getRateLimitStatus() {
            return null;
        }

        @Override
        public int getAccessLevel() {
            return 0;
        }
    }
}
