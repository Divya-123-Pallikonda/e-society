package com.example.e_society.service.impl;

import com.example.e_society.model.Notice;
import com.example.e_society.repository.NoticeRepository;
import com.example.e_society.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public Notice saveNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public Optional<Notice> getNoticeById(int id) {
        return noticeRepository.findById(id);
    }

    public void deleteNotice(int id) {
        noticeRepository.deleteById(id);
    }
}
