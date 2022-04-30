package pl.aw84.imagelib.frontend.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PaginatedResponse<T> extends PageImpl<T> {

    public PaginatedResponse(List<T> content,
            int number,
            int size,
            Long totalElements,
            Pageable pageable,
            boolean last,
            int totalPages,
            JsonNode sort,
            boolean first,
            boolean empty) {

        super(content, pageable, totalElements);
    }

    public PaginatedResponse(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PaginatedResponse(List<T> content) {
        super(content);
    }

    public PaginatedResponse() {
        super(new ArrayList<>());
    }

}
