package com.example.codeexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/execute")
public class CodeExecutionController {

    @Autowired
    private CodeSubmissionRepository codeSubmissionRepository;

    @PostMapping("/")
    public String executeCode(@RequestParam String language, @RequestParam String code, @RequestParam String input) {
        try {
            String fileName = "codeSnippet";
            String command = "";

            if ("java".equalsIgnoreCase(language)) {
                fileName += ".java";
                command = "javac " + fileName + " && java codeSnippet";
            } else if ("python".equalsIgnoreCase(language)) {
                fileName += ".py";
                command = "python3 " + fileName;
            } else if ("cpp".equalsIgnoreCase(language)) {
                fileName += ".cpp";
                command = "g++ " + fileName + " -o codeSnippet && ./codeSnippet";
            } else {
                return "Unsupported language";
            }

            Path filePath = Path.of(fileName);
            Files.writeString(filePath, code, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            ProcessBuilder builder = new ProcessBuilder("bash", "-c", command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();

            CodeSubmission submission = new CodeSubmission(language, code, input, output.toString());
            codeSubmissionRepository.save(submission);

            return output.toString();
        } catch (Exception e) {
            return "Execution error: " + e.getMessage();
        }
    }
}
