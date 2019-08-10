package holding.ex17;

class Gerbil {
    private int gerbilNumber;
    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    void hop() {
        System.out.println("hop()"+gerbilNumber);
    }
}