package com.gteam.glog.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BadResponseDTO {
    private long ecode;
    private String msg;
}
