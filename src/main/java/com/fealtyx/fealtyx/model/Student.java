package com.fealtyx.fealtyx.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Student {
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    @Min(value = 1, message = "Age must be greater than 0")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 1, message = "Age must be greater than 0") int age) {
        this.age = age;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    @Email(message = "Email should be valid")
    private String email;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
