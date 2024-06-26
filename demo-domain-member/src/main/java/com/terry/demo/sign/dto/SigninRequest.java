package com.terry.demo.sign.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequest {

    @NotNull
    @Size(min = 3, max = 50)
    private String idEmail;

    @NotNull
    @Size(min = 3, max = 100)
    private String pwd;
}
