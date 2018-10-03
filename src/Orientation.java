enum Orientation {

    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E", "N", "S"),
    WEST("W", "S", "N");

    private final String value;
    private final String left;
    private final String right;

    Orientation(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Orientation right() {
        return rotateToThe(right);
    }

    public Orientation left() {
        return rotateToThe(left);
    }

    public String value() {
        return value;
    }

    private Orientation rotateToThe(String rotationValue) {
        for (Orientation orientation : values()) {
            if (orientation.value == rotationValue) return orientation;
        }
        return null;
    }
}
