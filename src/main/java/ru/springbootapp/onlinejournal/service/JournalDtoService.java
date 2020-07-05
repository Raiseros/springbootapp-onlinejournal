package ru.springbootapp.onlinejournal.service;
import ru.springbootapp.onlinejournal.dto.JournalDto;

import java.util.List;

public interface JournalDtoService {
    public List<JournalDto> getListJournalDto(long theId);
 /*   public JournalDto getJournalDto(long theId);*/
}
