package com.example.producer;

import com.example.producer.dto.JobRequest;
import com.example.producer.dto.JobTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/make-job")
    // 사용자는 Make Job을 통해 처리하고 싶은 파일의 정보를 전달
    public JobTicket makeJob(
            @RequestBody
            JobRequest request) {
        // 추후 작업의 처리 상태를 판단하기 위한 jobId를 담고 있는
        // JobTicket 객체 반환
        return producerService.send(request.getFilename());
    }
}
