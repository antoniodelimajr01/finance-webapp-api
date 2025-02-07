package com.financewebapp.api.repository;

import com.financewebapp.api.model.Entry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByMonthAndYear(Integer month, Integer year);

    List<Entry> findByMonthAndYearAndCategoryId(Integer month, Integer year, Long category);
}
