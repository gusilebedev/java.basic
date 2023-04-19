package practice;

import java.util.*;


public class PhoneBook {
    public static final String PHONE_VERIFICATION = "^[7][9][0-9]{2}[0-9]{3}[0-9]{4}$";
    public static final String NAME_VERIFICATION = "^[a-zA-Zа-яА-Я' ']{1,20}$";

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (name.matches(NAME_VERIFICATION) && phone.matches(PHONE_VERIFICATION)) {
            if (phoneBook.containsKey(name)) {
                phone = phoneBook.get(name) + ", " +  phone;
                phoneBook.put(name, phone);
            }
            if (phoneBook.containsValue(phone)) {
                for (Map.Entry entry: phoneBook.entrySet()) {
                    if (Objects.equals(phone, entry.getValue())) {
                        phoneBook.remove(entry.getKey());
                        phoneBook.put(name,phone);
                    }
                }
            } else {
                phoneBook.put(name,phone);
            }
        } else {
        }
    }
    // проверьте корректность формата имени и телефона
    // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
    // если такой номер уже есть в списке, то перезаписать имя абонента

    public String getContactByPhone(String phone) {
        if(phoneBook.containsValue(phone)) {
        for (Map.Entry entry: phoneBook.entrySet()) {
            if (Objects.equals(phone, entry.getValue())) {
                return entry.getKey() + " - " + phone;
            }
        }
        }
            return "";
       }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

    public Set<String> getContactByName(String name) {
        Set<String> setPhoneBook = new TreeSet<>();
        if (phoneBook.containsKey(name)) {
            for (Map.Entry entry : phoneBook.entrySet()) {
                if (Objects.equals(name, entry.getKey())) {
                    setPhoneBook.add(name + " - " + entry.getValue());
                    return setPhoneBook;
                }
            }
        }
        return new TreeSet<>();
    }
    // формат одного контакта "Имя - Телефон"
    // если контакт не найден - вернуть пустой TreeSet

    public Set<String> getAllContacts() {
        Set<String> setPhoneBook = new TreeSet<>();
        for(String key : phoneBook.keySet()) {
            setPhoneBook.add(key + " - " + phoneBook.get(key));
        }
        return setPhoneBook;
    }
}

// формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet



    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */

