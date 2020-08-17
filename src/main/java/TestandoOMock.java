public class TestandoOMock {

    private int numeroDaClasseTestando;

    public TestandoOMock(int numeroDaClasseTestando) {
        this.numeroDaClasseTestando = numeroDaClasseTestando;
    }

    public int trocarONumeroQuantoTiverMock(int numeroParaRetornar){
        return 300;
    }

    public int getNumeroDaClasseTestando() {
        return numeroDaClasseTestando;
    }
}
