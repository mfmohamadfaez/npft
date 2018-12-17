import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Service.ParticipantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"classpath*:spring-mvc-npft-servlet.xml"})
@WebAppConfiguration
public class ParticipantTest {

    @Autowired
    ParticipantService participantService;

    @Test
    public void testParticipantList(){

        List<Participant> participants = participantService.getParticipant();
        Assert.assertNotNull(participants);

    }
}
