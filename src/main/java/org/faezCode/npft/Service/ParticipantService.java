package org.faezCode.npft.Service;

import org.faezCode.npft.Dao.ParticipantDao;
import org.faezCode.npft.Entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("participantService")
public class ParticipantService {

    @Autowired
    private ParticipantDao participantDao;

    public List<Participant> getParticipant(){
        List<Participant> participants = participantDao.getParticipant();
        return participants;
    }

    public Participant findById(int id){
        Participant participant = participantDao.findById(id);
        return participant;
    }

    public void deleteParticipant(int id){

        participantDao.deleteParticipant(id);

    }
}
