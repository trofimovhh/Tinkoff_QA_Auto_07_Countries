import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        System.out.println("Список стран:");
        for (Country cnt : Country.values()) {
            System.out.println(cnt.toString().substring(1, cnt.toString().length() - 1));
        }
        System.out.println("Для получения информации введите название страны на латинице:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        try {
            System.out.println(Country.valueOf(input).openInfo());
        } catch (NullPointerException e) {
            System.out.println("Каким-то образом введен null");
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }
        boolean gotInformed;
        try {
            gotInformed = input.equals(Country.valueOf(input).name());
        } catch (IllegalArgumentException e) {
            gotInformed = false;
        }
        if (!gotInformed) {
            try {
                System.out.println(Country.getByRuName(input).openInfo());

            } catch (Country.NoSuchCountryException e) {
                System.out.println("Страны '" + input + "'не существует.");
            }
        }
        in.close();
    }
}
