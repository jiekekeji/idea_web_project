package com.mx.fm.chat.model;

/**
 * Created by jack on 16/5/28.
 */
public class UserEntity {

    private String uuid;
    private String type;
    private String created;
    private String modified;
    private String username;
    private String activated;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uuid='" + uuid + '\'' +
                ", type='" + type + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", username='" + username + '\'' +
                ", activated='" + activated + '\'' +
                '}';
    }

}
