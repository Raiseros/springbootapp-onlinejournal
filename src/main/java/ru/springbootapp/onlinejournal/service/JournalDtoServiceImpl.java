package ru.springbootapp.onlinejournal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootapp.onlinejournal.dto.JournalDto;
import ru.springbootapp.onlinejournal.repository.JournalRepository;


import java.util.List;
import java.util.Optional;

@Service
public class JournalDtoServiceImpl implements JournalDtoService {


    @Autowired
    private JournalRepository journalRepository;


    @Override
    public List<JournalDto> getListJournalDto(long theId) {
        return journalRepository.getListJournalDto(theId);
    }

    @Override
    public List<JournalDto> getListJournalDtoStudentNameAndDateLesson(long studentName, String dateLesson) {
        return journalRepository.getListJournalDtoStudentNameAndDateLesson(studentName, dateLesson);
    }

    /* @Override
    public JournalDto getJournalDto(long theId) {
        Optional<JournalDto> result = journalRepository.getJournalDto(theId);

        JournalDto theJournalDto = null;

        if(result.isPresent()){
            theJournalDto = result.get();

        } else{
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theJournalDto;
    }*/
}
