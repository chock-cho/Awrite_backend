package Awrite_project.Awrite.web.controller;

import Awrite_project.Awrite.service.DiaryService;
import Awrite_project.Awrite.web.dto.DiaryDTO.DiaryRequestDTO;
import Awrite_project.Awrite.web.dto.DiaryDTO.DiaryResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private static final Logger logger = Logger.getLogger(DiaryController.class.getName());
    private final DiaryService diaryService;

    // 일기 글 등록
    @PostMapping("/write")
    public void saveDiary(DiaryRequestDTO diaryRequestDTO, HttpServletRequest request) {
        // 세션에서 사용자 ID 가져오기
        Long currentUserId = (Long)request.getSession().getAttribute("userId");
        // 세션에 저장된 userId 로그로 출력
        diaryService.join(diaryRequestDTO, currentUserId);
    }

    // 일기 글 삭제
    @DeleteMapping("/delete/{diaryId}")
    public void deleteDiary(@PathVariable Long diaryId, HttpServletRequest request) {
        // 세션에서 사용자 ID 가져오기
        Long currentUserId = (Long)request.getSession().getAttribute("userId");
        diaryService.deleteDiary(diaryId, currentUserId);
    }
}
