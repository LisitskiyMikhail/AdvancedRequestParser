import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class RequestParser {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));
        allPeople.add(Person.createMale("Петров Петр", new Date()));
    }


    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 1) {
            throw new RuntimeException();
        }

        Person person;
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], dateParser(args[3])));
                } else {
                    allPeople.add(Person.createFemale(args[1], dateParser(args[3])));
                }
                System.out.println(allPeople.size() - 1);
                break;
            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " + SexEnumParse(person.getSex()) + " " + dateToString(person.getBirthDate()));
                break;
            case "-u":
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(args[2]);
                allPeople.get(id).setSex(SexEnumParse(args[3]));
                allPeople.get(id).setBirthDate(dateParser(args[4]));
                break;
            case "-d":
                Person currentPerson = allPeople.get(Integer.parseInt(args[1]));
                currentPerson.setName(null);
                currentPerson.setSex(null);
                currentPerson.setBirthDate(null);
                break;
        }

    }

    public static Date dateParser(String str) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            System.out.println("Wrong data format, Please input correct data!");
        }
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return simpleDateFormat2.format(date);
    }


    public static Sex SexEnumParse(String str) {
        return str.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    public static String SexEnumParse(Sex sex) {
        return sex.equals(Sex.MALE) ? "м" : "ж";
    }


}