# Spring AI Audio Generator

## Overview
This service leverages Spring AI and OpenAI's text-to-speech capabilities to generate high-quality audio outputs from text inputs. Built with Java and Spring Boot, it provides a seamless way to convert text into natural-sounding speech using OpenAI's advanced speech synthesis models.

## Technologies Used
- Java 21
- Spring Boot
- Spring AI
- OpenAI API
- Lombok
- Maven (for dependency management)

## Prerequisites
Before running the application, ensure you have the following installed:
- Java Development Kit (JDK) 21 or later
- Maven
- An OpenAI API key

## Configuration
1. **Environment Variables Setup**
   Create an environment variable for your OpenAI API key:
   ```shell
   export OPENAI_API_KEY=your_openai_api_key
   ```

2. **Application Properties**
   The application is configured using `application.yml`. The essential configuration is already set up to use the OpenAI API key from environment variables.

## Features
- Text-to-Speech conversion using OpenAI's advanced models
- Customizable speech parameters:
    - Voice selection (default: ALLOY)
    - Speech speed adjustment
    - MP3 output format
    - Configurable TTS model

## Getting Started
1. Clone the repository
2. Set up the OPENAI_API_KEY environment variable
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Use the service to convert text to speech

## API Usage
The service exposes a REST API endpoint for text-to-speech conversion.

### Convert Text to Speech
**Endpoint:** `POST /audio`
**Content-Type:** `application/json`
**Produces:** `audio/mpeg`

#### Example using cURL
```bash
curl -X POST
[http://localhost:8080/audio](http://localhost:8080/audio)
-H 'Content-Type: application/json'
-d '{"question": "Hello, this is a test of the text to speech conversion."}'
--output output.mp3
```
This command will:
1. Send a POST request to the audio endpoint
2. Include the text to be converted in JSON format
3. Save the generated audio as 'output.mp3' in the current directory

#### Response
- Success: Returns the audio file in MP3 format
- The generated audio file can be played using any media player that supports MP3 format

#### Sample Request Body
```json 
{ "question": "Your text to be converted to speech goes here" }
```
**Note:** Make sure your server is running locally before testing the API endpoint. The default port is 8080 unless configured otherwise in your `application.yml`.

## Notes
- The service generates audio in MP3 format
- Speech generation is processed through OpenAI's API
- Ensure you have sufficient API credits in your OpenAI account
- Keep your API key secure and never commit it to version control

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
This project is open source and available under standard terms.

---

**Maintainer:** [Intercont](https://github.com/Intercont)

*Built with [Spring Boot](https://spring.io/projects/spring-boot) and [Spring AI](https://github.com/spring-projects/spring-ai).*

**Subscribe at [igorfragadev.com](https://igorfragadev.com) for more**