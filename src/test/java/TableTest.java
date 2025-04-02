import org.example.Table;
import org.junit.Assert;
import org.junit.Test;

public class TableTest {

    @Test
    public void testEncrypt() {
        String message = "London is the capital of Great Britain";
        String key = "phone";
        int columns = (int) Math.ceil((double) message.length() / key.length());
        String encryption = Table.table(message, key, columns);
        Assert.assertEquals("o ca tt o hp rBids tfai nieioernLntalG a", encryption);
    }

    @Test
    public void testDecrypt() {
        String message = "o ca tt o hp rBids tfai nieioernLntalG a";
        String key = "phone";
        int columns = (int) Math.ceil((double) message.length() / key.length());
        String encryption = Table.tableBack(message, key, columns);
        Assert.assertEquals("London is the capital of Great Britain", encryption);

    }
}
