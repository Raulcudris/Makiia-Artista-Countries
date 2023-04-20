package com.makiia.crosscutting.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse {
    private int currentPage = 0;
    private int totalPageSize = 0;
    private long totalResults = 0;
    private int totalPages = 0;
    private boolean hasNextPage = false;
    private boolean hasPreviousPage = false;
    private String nextPageUrl = "localhost";
    private String previousPageUrl = "localhost";
}
