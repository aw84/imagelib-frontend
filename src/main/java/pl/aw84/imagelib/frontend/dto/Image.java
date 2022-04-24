package pl.aw84.imagelib.frontend.dto;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "imageId")
public class Image {
    private UUID imageId;

    private String name;

    private Set<Storage> storage;

    public Image() {
    }

    public Image(UUID imageId, String name, Set<Storage> storage) {
        this.imageId = imageId;
        this.name = name;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Image [imageId=" + imageId +
                ", name=" + name +
                ", storages=" + storage +
                "]";
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Storage> getStorage() {
        return storage;
    }

    public void setStorage(Set<Storage> storage) {
        this.storage = storage;
    }
}
