import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DataMatrixTest {

    @Test
    public void testeValido() {

        String dataMatrix = "17898XY0660559260124ABCDE123459";

        assertTrue(DataMatrix.validar(dataMatrix));
    }

    @Test
    public void testeInvalido1() {

        String dataMatrix = "17A9856606559260124ABCDE12345A";

        assertFalse(DataMatrix.validar(dataMatrix));
    }

    @Test
    public void testeInvalido2() {

        String dataMatrix = "1789X560660559AB0124ABCDE123459";

        assertFalse(DataMatrix.validar(dataMatrix));
    }

    @Test
    public void testeInvalido3() {

        String dataMatrix = "1789Y560660559AB0124ABCDE1234598";

        assertFalse(DataMatrix.validar(dataMatrix));
    }
}
