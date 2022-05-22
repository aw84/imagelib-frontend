package pl.aw84.imagelib.frontend.dto;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "imageId")
public class Image {
    private UUID imageId;

    private String name;

    private Set<Storage> storages;

    public Image() {
    }

    public Image(UUID imageId, String name, Set<Storage> storages) {
        this.imageId = imageId;
        this.name = name;
        this.storages = storages;
    }

    @Override
    public String toString() {
        return "Image [imageId=" + imageId +
                ", name=" + name +
                ", storages=" + storages +
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

    public Set<Storage> getStorages() {
        return storages;
    }

    public void setStorages(Set<Storage> storages) {
        this.storages = storages;
    }
}
