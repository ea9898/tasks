package chess;

class Move {

    private int departureX;
    private int departureY;
    private int arrivalX;
    private int arrivalY;

    public Move(int departureX, int departureY, int arrivalX, int arrivalY) {
        this.departureX = departureX;
        this.departureY = departureY;
        this.arrivalX = arrivalX;
        this.arrivalY = arrivalY;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Move other = (Move) obj;

        if (this.departureX != other.departureX) {
            return false;
        }

        if (this.departureY != other.departureY) {
            return false;
        }

        if (this.arrivalX != other.arrivalX) {
            return false;
        }

        if (this.arrivalY != other.arrivalY) {
            return false;
        }
        return true;
    }


    public int getDepartureX() {
        return departureX;
    }

    public int getDepartureY() {
        return departureY;
    }

    public int getArrivalX() {
        return arrivalX;
    }

    public int getArrivalY() {
        return arrivalY;
    }

    @Override
    public String toString() {
        return "departureX = " + departureX + " " +
                "departureY = " + departureY + " " +
                "arrivalX = " + arrivalX + " " +
                "arrivalY = " + arrivalY;
    }
}
