package com.sebastiao.clientcrudapi.dto;

import com.sebastiao.clientcrudapi.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String name;
    @NotBlank(message = "Campo Obrigatório")
    private String cpf;
    private Double income;
    @PastOrPresent(message = "A data não pode ser no futuro")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client obj) {
        id = obj.getId();
        name = obj.getName();
        cpf = obj.getCpf();
        income = obj.getIncome();
        birthDate = obj.getBirthDate();
        children = obj.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public String getCpf() {
        return cpf;
    }
}