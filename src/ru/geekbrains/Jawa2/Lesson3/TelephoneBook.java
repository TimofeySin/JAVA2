package ru.geekbrains.Jawa2.Lesson3;

import java.util.*;


//2. Написать простой класс ТелефонныйСправочник,
// который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.
public class TelephoneBook {

   private HashMap<String,Integer> telephoneBook = new HashMap<>();


    public TelephoneBook(int tel, String fio) {
        this.telephoneBook.put(fio ,tel);
    }


    public void addTelephoneBook(int tel, String fio) {
        this.telephoneBook.put(fio ,tel);
    }


    private boolean initTel(){
        addTelephoneBook(1623030,"Никифорова Ов");
        addTelephoneBook(9621831,"Слинько Ми");
         addTelephoneBook(9621931,"Слинько Ми");
         addTelephoneBook(9630129,"Айгистова Ра");
         addTelephoneBook(9630130,"Бабак Сг");
         addTelephoneBook(9630132,"Полуян Ов");
         addTelephoneBook(9630139,"Чернобривцев Юа");
         addTelephoneBook(9630152,"Драгунова Ви");
         addTelephoneBook(9630155,"Бухонкин Ви");
         addTelephoneBook(630162,"Воронкова Тп");
         addTelephoneBook(9630183,"Маврина Мя");
         addTelephoneBook(9630184,"Федорова Ки");
         addTelephoneBook(9630188,"Сорокина Ею");
         addTelephoneBook(9630273,"Турова Рт");
         addTelephoneBook(9630337,"Журабаева Лд");
         addTelephoneBook(9630431,"Шадрухина Оф");
         addTelephoneBook(9630465,"Михеева Тм");
         addTelephoneBook(9630623,"Кузнецов Ев");
         addTelephoneBook(9630769,"Матвеева Вп");
         addTelephoneBook(9630782,"Борискова Ва");
         addTelephoneBook(1623030,"Никифорова Ов");
         addTelephoneBook(9621831,"Слинько Ми");
         addTelephoneBook(9621931,"Слинько Ми");
         addTelephoneBook(9630129,"Айгистова Ра");
         addTelephoneBook(9630130,"Бабак Сг");
         addTelephoneBook(9630132,"Полуян Ов");
         addTelephoneBook(9630139,"Чернобривцев Юа");
         addTelephoneBook(9630152,"Драгунова Ви");
         addTelephoneBook(9630155,"Бухонкин Ви");
         addTelephoneBook(630162,"Воронкова Тп");
         addTelephoneBook(9630183,"Маврина Мя");
         addTelephoneBook(9630184,"Федорова Ки");
         addTelephoneBook(9630188,"Сорокина Ею");
         addTelephoneBook(9630273,"Турова Рт");
         addTelephoneBook(9630337,"Журабаева Лд");
         addTelephoneBook(9630431,"Шадрухина Оф");
         addTelephoneBook(9630465,"Михеева Тм");
         addTelephoneBook(9630623,"Кузнецов Ев");
         addTelephoneBook(9630769,"Матвеева Вп");
         addTelephoneBook(9630782,"Борискова Ва");
return true;
    }

    public boolean emptyTel(){
        telephoneBook.clear();
        return true;
    }

    public TelephoneBook() {
        initTel();
    }

    public void getNumber(String fio){


        ////А вот без перерборов вообще возможно найти значение?


        for (Map.Entry<String, Integer> o :  this.telephoneBook.entrySet()) {
            if (fio.equals(o.getKey())) {
            System.out.print(o.getKey() + ": ");
            System.out.println(o.getValue());}
        }
    }
}
