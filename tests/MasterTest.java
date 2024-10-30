import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MasterTest {
    @Test
    void levelUp_noChange() {
        //given
        Expertise master = new Master();

        //when
        Expertise levelUp = master.levelUp();

        //then
        assertSame(master, levelUp);
    }
}
