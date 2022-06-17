package pojos;

public class Pojo {

    private String fact;
    private int length;

    public Pojo() {
    }

    public Pojo(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
