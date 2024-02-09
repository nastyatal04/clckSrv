package com.example.clck.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class URLDomain {
    Long id;
    String fullURL;
    String reduceURL;
}
