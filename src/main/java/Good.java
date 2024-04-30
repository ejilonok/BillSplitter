// import RubConverter;

public class Good {
    private final String name;
    private final double cost;

    public Good(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t%s", name, CostUtils.costToString(cost));
    }
}
