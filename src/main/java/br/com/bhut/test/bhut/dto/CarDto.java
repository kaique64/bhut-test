package br.com.bhut.test.bhut.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class CarDto implements Serializable {

    @NotBlank
    @Size(min = 2, message = "É necessário no minimo 2 caracteres")
    private String title;

    @NotBlank
    @Size(min = 2, message = "É necessário no minimo 2 caracteres")
    private String brand;

    @NotBlank
    private String price;

    @NotNull
    private Integer age;

}
