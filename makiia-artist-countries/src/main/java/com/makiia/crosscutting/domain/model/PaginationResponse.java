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
    @Builder.Default
    private int currentPage = 0;
    @Builder.Default
    private int totalPageSize = 0;
    @Builder.Default
    private long totalResults = 0;
    @Builder.Default
    private int totalPages = 0;
    @Builder.Default
    private boolean hasNextPage = false;
    @Builder.Default
    private boolean hasPreviousPage = false;
    @Builder.Default
    private String nextPageUrl = "localhost";
    @Builder.Default
    private String previousPageUrl = "localhost";
}
