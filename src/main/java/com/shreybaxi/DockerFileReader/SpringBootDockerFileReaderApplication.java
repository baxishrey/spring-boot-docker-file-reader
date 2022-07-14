package com.shreybaxi.DockerFileReader;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
public class SpringBootDockerFileReaderApplication {
	private final Logger logger = LoggerFactory.getLogger(SpringBootDockerFileReaderApplication.class);

	@Value("${filepath}")
	private Resource inputFile;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerFileReaderApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("File path: {}", this.inputFile.getFile().getAbsolutePath());
////		logger.info("File content: {}", IOUtils.toString(this.inputFile.getInputStream(), StandardCharsets.UTF_8));
//	}

	@GetMapping()
	public String getFileContent() throws IOException {
		return IOUtils.toString(this.inputFile.getInputStream(), StandardCharsets.UTF_8);
	}
}
