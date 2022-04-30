package pl.aw84.imagelib.frontend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ImagePaginatedResponse extends PaginatedResponse<Image> {

    public ImagePaginatedResponse(List<Image> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public ImagePaginatedResponse(List<Image> content) {
        super(content);
    }

    public ImagePaginatedResponse() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ImagePaginatedResponse(@JsonProperty("content") List<Image> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("pageable") JsonNode pageable,
            @JsonProperty("last") boolean last,
            @JsonProperty("totalPages") int totalPages,
            @JsonProperty("sort") JsonNode sort,
            @JsonProperty("first") boolean first,
            @JsonProperty("empty") boolean empty) {
        super(content, number, size, totalElements, PageRequest.of(number, size), last, totalPages, sort, first, empty);
    }

}
