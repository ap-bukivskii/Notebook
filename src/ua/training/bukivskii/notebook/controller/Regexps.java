package ua.training.bukivskii.notebook.controller;

import sun.misc.Regexp;

public interface Regexps {
    String firstNameRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\.\\- `']{2,31}$"; // Martin Luther King, Jr. ; де Бальзак
    String lastNameRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\.\\- `']{1,31}$";
    String middleNameRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\.\\- `']{1,31}$"; // Martin Luther King, Sr. ; I Li ; Ю Лі
    String shortNameRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\.\\- `']{2,31}$";
    String nickNameRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\. \\-_0-9\\[\\]\\(\\)`']{1,31}$";
    String commentRegexp = ".*";
    String groupsRegexp = "^(([a-zA-Z]{5,6} ?)|([1-5] ?)){0,5}$";
    String homePhoneNumberRegexp = "^\\+\\([2-9]{1}\\d{2}\\)[ \\-]?\\d{2}[ \\-]?\\d{3}[ \\-]?\\d{4}$";
    String cellPhoneNumberRegexp = "^\\+\\([2-9]{1}\\d{2}\\)[ \\-]?\\d{2}[ \\-]?\\d{3}[ \\-]?\\d{4}$";
    String cellPhoneNumber2Regexp = "(^\\+\\([2-9]{1}\\d{2}\\)[ \\-]?\\d{3}[ \\-]?\\d{3}[ \\-]?\\d{4}$)|(^$)";
    String emailRegexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String skypeNameRegexp = "^[a-zA-Z][a-zA-Z0-9_\\-\\,\\.]{5,31}$";
    String indexRegexp = "^\\d{5}$";
    String cityRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\- `']{3,31}$"; //Rostov na Donu  ;  Буенос-Айрес
    String streetRegexp = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\- `']{3,31}$"; // Римського-Корсакова ; Льва Толстого
    String houseRegexp = "^\\d{1,5}( [a-zA-Zа-яА-ЯїЇєЄіІ]{1})?$";
    String appartmentRegexp = "^\\d{0,5}( [a-zA-Zа-яА-ЯїЇєЄіІ]{1})?$";
}
