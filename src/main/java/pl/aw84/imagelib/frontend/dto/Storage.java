package pl.aw84.imagelib.frontend.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "storageId")
public class Storage {
    private UUID storageId;

    private Image image;

    private String protocol;
    private String host;

    private String relativePath;

    private String hash;

    public Storage() {
    }

    public Storage(UUID storageId, Image image, String protocol, String host, String relativePath, String hash) {
        this.storageId = storageId;
        this.image = image;
        this.protocol = protocol;
        this.host = host;
        this.relativePath = relativePath;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Storage [hash=" + hash
                + ", host=" + host
                + ", protocol=" + protocol
                + ", relativePath=" + relativePath
                + ", storageId=" + storageId + "]";
    }

    public UUID getStorageId() {
        return storageId;
    }

    public void setStorageId(UUID storageId) {
        this.storageId = storageId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
