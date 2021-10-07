package com.muhammederendemir.springbootpostgresqlfileupload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {

    private String id;
    private String name;
    private Long size;
    private String url;
    private String contentType;

}
