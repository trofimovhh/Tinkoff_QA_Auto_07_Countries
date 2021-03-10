public enum Country {
    RUSSIA("Россия", true),
    USA("США", true),
    GERMANY("Германия", false);


    private final String ruName;
    private final boolean isOpen;

    Country(final String name, final boolean open) {
        ruName = name;
        isOpen = open;
    }

    public boolean getOpenInfo() {
        return isOpen;
    }

    public String openInfo() {
        if (getOpenInfo()) {
            return "Cтрана " + this.toString() + " открыта для посещения";
        } else {
            return "Cтрана " + this.toString() + " закрыта для посещения";
        }
    }


    public static Country getByRuName(final String ruName) throws NoSuchCountryException {
        Country country;
        switch (ruName) {
            case "Россия":
                country = RUSSIA;
                break;
            case "США":
                country = USA;
                break;
            case "Германия":
                country = GERMANY;
                break;
            default:
                throw new NoSuchCountryException();
        }
        return country;
    }

    public String toString() {
        String info = "";
        switch (this) {
            case RUSSIA:
                info += "[" + RUSSIA.name() + " (" + RUSSIA.ruName + ")" + "]";
                break;
            case USA:
                info += "[" + USA.name() + " (" + USA.ruName + ")" + "]";
                break;
            case GERMANY:
                info += "[" + GERMANY.name() + " (" + GERMANY.ruName + ")" + "]";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
        return info;
    }

    public static class NoSuchCountryException extends Exception {
    }
}
