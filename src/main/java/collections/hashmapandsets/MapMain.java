package collections.hashmapandsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {


    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("emails");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        // bu yerda contact va emails print bo'ladi chunki List dan contact ni chaqirib phones ga specify qildik kein list add method bilan emails ni ham qo'shdik natijada contact va emasil print bo'ldi
        fullList.forEach(System.out::println);
        System.out.println("------------------------------------------");

        // Map bilan contac ga access qildik va for enhanced loop bilan full list ni print qildik fulllist esa contact bilan emailni o'z ichiga oladi
        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
        System.out.println("------------------------------------------");

        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("------------------------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("------------------------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
    }
}
