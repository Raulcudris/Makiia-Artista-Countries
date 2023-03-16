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
    private int currentPage;
    private int totalPageSize;
    private long totalResults;
    private int totalPages;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
}
