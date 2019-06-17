package principal;

public class ValidadorCPF {

    /**
     * <h2>Método válida um CPF completamente, ele possui todas as proteções possíveis.</h2>
     * <div>Este método verifica o número de digitos informados, também tem proteção contra CPF's com todos os dígitos repetidos, por fim, ele cálcula os dígitos verificadores e compara com os informados.</div>
     *
     * <h3>@param CPF - String do CPF que deve ser tratado.</h3>
     * <div>O CPF deve ser informado nos seguintes padrões: "XXX.XXX.XXX-YY" ou "XXXXXXXXX-YY". Os pontos não são obrigatorios, mas o traço <b>sim</b>.</div>
     *
     * <h3>@return boolean (BOLEANO).</h3>
     * <div><b>true</b> para CPF válido e <b>false</b> para um CPF inválido.</div>
     * 
     * @author Tuna
     * @version 0000.00.00
     */
    public static boolean validadorCPF(String CPF) {
        String cpfAnalise = CPF.replaceAll("[^0-9]", ""); //REMOVE PONTOS E TRAÇOS
        String[] array = new String[1];
        array = CPF.split("-");
        array[0] = array[0].replace(".", "");
        char arrayCharUm[] = array[0].toCharArray();
        int digGeradoUm = 0;
        int digGeradoDois = 0;

        if (cpfAnalise.length() != 11) {return false;} //VERIFICA O TAMANHO DA STRING
        if (cpfAnalise.matches("(\\d)\\1{10}")) {return false;} //VERIFICA SE NAO TEM VALORES REPETIDOS COMO EX: 111.111.111-11

        //CALCULANDO PRIMEIRO DIGITO VERIFICADOR.
        for (int sobe = 0, desce = 10; sobe <= arrayCharUm.length && desce >= 2; sobe++, desce--) {
            digGeradoUm += (arrayCharUm[sobe] - 48) * desce;
        }
        digGeradoUm = 11 - (digGeradoUm % 11);
        String strFirstDig = Integer.toString(digGeradoUm);
        String novaString = new String(arrayCharUm);
        novaString = novaString + strFirstDig;

        //CALCULANDO SEGUNDO DIGITO VERIFICADOR.
        char arrayCharDois[] = novaString.toCharArray();
        for (int sobe = 0, desce = 11; sobe <= arrayCharDois.length && desce >= 2; sobe++, desce--) {
            digGeradoDois += (arrayCharDois[sobe] - 48) * desce;
        }
        digGeradoDois = 11 - (digGeradoDois % 11);
        String strSecundDig = Integer.toString(digGeradoDois);

        return array[1].equals(strFirstDig + strSecundDig); //COMPARANDO OS DIGITOS VERIFICADORES.
    }
}
