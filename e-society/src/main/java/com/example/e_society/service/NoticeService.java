package com.example.e_society.service;

import com.example.e_society.model.Notice;
import java.util.List;
import java.util.Optional;

public interface NoticeService {
    Notice saveNotice(Notice notice);
    List<Notice> getAllNotices();
    Optional<Notice> getNoticeById(int id);
    void deleteNotice(int id);
}
