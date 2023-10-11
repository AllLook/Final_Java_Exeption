import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * user_data
 */
public class user_data {

    public static void main(String[] args) {
        ArrayList<String> user_list_str = new ArrayList<>();
        ArrayList<Integer> user_list_int = new ArrayList<>();
        System.out.println("Введите поочередно:Фамилия Имя Отчество дата рождения  пол номер телефона ");
        for (int i = 0; i < 5; i++) {
            Scanner iScanner = new Scanner(System.in);
            String temp = iScanner.nextLine();
            user_list_str.add(temp);

        }

        try {
            Scanner iScanner = new Scanner(System.in);
            Integer number_phone = iScanner.nextInt();
            user_list_int.add(number_phone);
            System.out.println(user_list_str);
            System.out.println(user_list_int);
            iScanner.close();
        } catch (InputMismatchException e) {
            System.out.println(
                    "Неправильный ввод данных, требуется числовое значение или переполнение числового значения"); // переопределение
                                                                                                                  // исключения
        }

        // user_list_str.remove(4); проверка

        if (user_list_str.size() == 5 && user_list_int.size() == 1) {
            try {
                FileWriter fw = new FileWriter("user.txt", true);
                for (String item : user_list_str) {
                    fw.write(item);
                    fw.append(" ");
                }

                for (int i = 0; i < user_list_int.size(); i++) {
                    String item2 = Integer.toString(user_list_int.get(i));
                    fw.write(item2);
                    fw.append("\n");
                }
                fw.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage()); // если возникает ошибка при работе с файлом

            }

        } else {
            System.out.println("Количество введенных данных не соотвветствует"); // исключение
        }
    }
}