package com.example.contents;

import com.example.contents.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@RestController
public class TestController {

    @PostMapping(
            value = "/multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseDto multipart(
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile multipartFile
    ) throws IOException {
        log.info(name);
        log.info(multipartFile.toString());

        // 저장할 경로를 생성한다
        Files.createDirectories(Path.of("media"));
        // 저장할 파일이름을 경로를 포함해 지정한다.
        Path path = Path.of("media/filename.png");
        // 저장한다.
        multipartFile.transferTo(path);

//        // 저장할 파일 이름
//        File file = new File("./media/filename.png");
//        // 파일에 저장하기 위한 OutputStream
//        try (OutputStream outputStream = new FileOutputStream(file)){
//            // byte[] 데이터를 받는다.
//            byte[] fileBytes = multipartFile.getBytes();
//            // TODO 작업 추가
//
//            // OutputStream에 MultipartFile의 byte[]를 저장한다.
//            outputStream.write(fileBytes);
//        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("hello world!");
        return responseDto;
    }
}
