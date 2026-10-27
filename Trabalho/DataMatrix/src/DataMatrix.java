public class DataMatrix {

    public static boolean validar(String dataMatrix) {

        if (dataMatrix == null || dataMatrix.length() != 31) {
            return false;
        }

        String codMedico = dataMatrix.substring(0, 14);
        String dtProd = dataMatrix.substring(14, 20);
        String serial = dataMatrix.substring(20, 25);
        String lote = dataMatrix.substring(25, 31);

        if (!dtProd.matches("[0-9]+")) {
            return false;
        }

        if (!lote.matches("[0-9]+")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String dataMatrix = "17898XY0660559260124ABCDE123459 ";

        String codMedico = dataMatrix.substring(0, 14);
        String dtProd = dataMatrix.substring(14, 20);
        String serial = dataMatrix.substring(20, 25);
        String lote = dataMatrix.substring(25, 31);

        System.out.println("DataMatrix: " + dataMatrix);
        System.out.println("CodMedico: " + codMedico);
        System.out.println("DtProd: " + dtProd);
        System.out.println("Serial: " + serial);
        System.out.println("Lote: " + lote);

        if (validar(dataMatrix)) {
            System.out.println("DataMatrix: VALIDA");
        } else {
            System.out.println("DataMatrix: INVALIDA");
        }
    }
}
