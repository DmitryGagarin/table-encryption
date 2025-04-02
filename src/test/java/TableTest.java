import org.example.Table;
import org.junit.Assert;
import org.junit.Test;

public class TableTest {

    @Test
    public void testEncrypt() {
        String message = "London is the capital of Great Britain";
        int key = 6;
        int columns = (int) Math.ceil((double) message.length() / key);
        String encryption = Table.table(message, key, columns);
        Assert.assertEquals("L et  ioi aGBnnsclrr d a ei otpoat nhifta ", encryption);
    }

    @Test
    public void testDecrypt() {
        String message = "L et  ioi aGBnnsclrr d a ei otpoat nhifta ";
        int key = 6;
        int columns = (int) Math.ceil((double) message.length() / key);
        String encryption = Table.tableBack(message, key, columns);
        Assert.assertEquals("London is the capital of Great Britain", encryption);

    }
}
