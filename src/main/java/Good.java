// import RubConverter;

public class Good {
    String name;
    double cost;

    public Good(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t%s", name, CostUtils.costToString(cost));
    }
}
