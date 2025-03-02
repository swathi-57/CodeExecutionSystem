package com.example.codeexecution;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CodeSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String code;
    private String input;
    private String output;

    public CodeSubmission() {}

    public CodeSubmission(String language, String code, String input, String output) {
        this.language = language;
        this.code = code;
        this.input = input;
        this.output = output;
    }

    public Long getId() { return id; }
    public String getLanguage() { return language; }
    public String getCode() { return code; }
    public String getInput() { return input; }
    public String getOutput() { return output; }
}
