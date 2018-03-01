package io.arklitium.matrix.client.rest.jsonmodel;

import java.util.List;

public class PublicRoomsChunk {

    private List<String> aliases;
    private String canonical_alias;
    private String name;
    private Long num_joined_members;
    private String room_id;
    private String topic;
    private Boolean world_readable;
    private Boolean guest_can_join;
    private String avatar_url;

    public PublicRoomsChunk() {
    }

    public PublicRoomsChunk(List<String> aliases, String canonical_alias, String name, Long num_joined_members,
                            String room_id, String topic, Boolean world_readable, Boolean guest_can_join,
                            String avatar_url) {
        this.aliases = aliases;
        this.canonical_alias = canonical_alias;
        this.name = name;
        this.num_joined_members = num_joined_members;
        this.room_id = room_id;
        this.topic = topic;
        this.world_readable = world_readable;
        this.guest_can_join = guest_can_join;
        this.avatar_url = avatar_url;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getCanonical_alias() {
        return canonical_alias;
    }

    public void setCanonical_alias(String canonical_alias) {
        this.canonical_alias = canonical_alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum_joined_members() {
        return num_joined_members;
    }

    public void setNum_joined_members(Long num_joined_members) {
        this.num_joined_members = num_joined_members;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Boolean getWorld_readable() {
        return world_readable;
    }

    public void setWorld_readable(Boolean world_readable) {
        this.world_readable = world_readable;
    }

    public Boolean getGuest_can_join() {
        return guest_can_join;
    }

    public void setGuest_can_join(Boolean guest_can_join) {
        this.guest_can_join = guest_can_join;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "PublicRoomsChunk{" +
                "aliases=" + aliases +
                ", canonical_alias='" + canonical_alias + '\'' +
                ", name='" + name + '\'' +
                ", num_joined_members=" + num_joined_members +
                ", room_id='" + room_id + '\'' +
                ", topic='" + topic + '\'' +
                ", world_readable=" + world_readable +
                ", guest_can_join=" + guest_can_join +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }

}
