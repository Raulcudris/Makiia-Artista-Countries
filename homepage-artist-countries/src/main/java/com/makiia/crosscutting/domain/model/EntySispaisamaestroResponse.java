package com.makiia.crosscutting.domain.model;
import com.makiia.crosscutting.persistence.entity.EntySispaisamaestro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntySispaisamaestroResponse {
    private  String rspValue ="OK";
    private  String rspMessage ="OK";
    private  PaginationResponse rspPagination;
    private  List<EntySispaisamaestro> rspData;
}

