

import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    @Test
    public void testPass() {
        System.out.println("Этот тест пройдет");
        Assert.assertTrue(true);
    }

    @Test
    public void testFail() {
        System.out.println("Этот тест должен упасть");
        Assert.assertTrue(false, "Принудительная ошибка");
    }
}
