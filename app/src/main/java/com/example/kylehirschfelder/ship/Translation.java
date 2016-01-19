package com.example.kylehirschfelder.ship;
public class Translation {

    public String Letter_E2M(String english) {
        int vflag = 0;
        String ret_mar = "";
        char ch = english.charAt(english.length() - 1);
        char prev = '!';
        if(!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'M' || ch == 'A')) { // if last letter is a consonant append 'a'
            english += 'a';
        }
        else if(english.length() == 1) {
            vflag = 1;
        }
        for(int i = 0; i < english.length(); i++) {
            ch = english.charAt(i);
            switch(ch) {
                case '#':
                    return english.substring(1, english.length());
                case 'a':
                    if(i + 1 == english.length()) {
                        if(vflag != 1) {
                            break;
                        }
                        else {
                            ret_mar += "अ";
                            break;
                        }
                    }
                    char temp = english.charAt(i + 1);
                    if(i > 0) {
                        if (temp == 'a') {
                            if (vflag == 0) {
                                ret_mar = ret_mar + "ा";
                            } else
                                ret_mar = ret_mar + "आ";
                            i++;
                        } else if (temp == 'u') {
                            if (vflag == 0) {
                                ret_mar = ret_mar + "ौ";
                            } else
                                ret_mar = ret_mar + "औ";
                            i++;
                        } else if (temp == 'i') {
                            if (vflag == 0) {
                                ret_mar = ret_mar + "ै";
                            } else
                                ret_mar = ret_mar + "ऐ";
                            i++;
                        }
                    }
                    else {
                        if(temp == 'a'){
                            ret_mar = ret_mar + "आ";
                            i++;
                        }
                        else if(temp == 'u'){
                            ret_mar = ret_mar + "औ";
                            i++;
                        }
                        else if(temp == 'i'){
                            ret_mar = ret_mar + "ऐ";
                            i++;
                        }
                        else{
                            ret_mar = ret_mar + "अ";
                        }
                    }
                    break;
                case 'A':
                    ret_mar = ret_mar + "ः" ;
                    vflag = 1;
                    continue;
                case 'b':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्भ";
                                i++;
                            } else
                                ret_mar = ret_mar + "्ब";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "भ";
                                i++;
                            } else
                                ret_mar = ret_mar + "ब";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "भ";
                            i++;
                        } else
                            ret_mar = ret_mar + "ब";
                    }
                    break;
                case 'c':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 2) == 'h') {
                                ret_mar = ret_mar + "्छ";
                                i = i + 2;
                            } else {
                                ret_mar = ret_mar + "्च";
                                i++;
                            }
                        } else {
                            if (english.charAt(i + 2) == 'h') {
                                ret_mar = ret_mar + "छ";
                                i = i + 2;
                            } else {
                                ret_mar = ret_mar + "च";
                                i++;
                            }
                        }
                    } else {
                        if (english.charAt(i + 2) == 'h') {
                            ret_mar = ret_mar + "छ";
                            i = i + 2;
                        } else {
                            ret_mar = ret_mar + "च";
                            i++;
                        }
                    }

                    break;
                case 'd':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्ध";
                                i++;
                            } else
                                ret_mar = ret_mar + "्द";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "ध";
                                i++;
                            } else
                                ret_mar = ret_mar + "द";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "ध";
                            i++;
                        } else
                            ret_mar = ret_mar + "द";
                    }
                    break;
                case 'D':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्ढ";
                                i++;
                            } else
                                ret_mar = ret_mar + "्ड";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "ढ";
                                i++;
                            } else
                                ret_mar = ret_mar + "ड";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "ढ";
                            i++;
                        } else
                            ret_mar = ret_mar + "ड";
                    }
                    break;
                case 'e':

                    if (i + 1 == english.length()) {
                        if (vflag == 0)
                            ret_mar = ret_mar + "े";
                        else if(prev != 'e')
                            ret_mar = ret_mar + "ए";
                        else
                            ret_mar = ret_mar.substring(0, ret_mar.length() - 1) + "ई";

                    } else if (i > 0) {
                        if (english.charAt(i + 1) == 'e') {
                            if (vflag == 0)
                                ret_mar = ret_mar + "ी";
                            else
                                ret_mar = ret_mar + "ई";
                            i++;
                        } else {
                            if(prev != 'e') {
                                if (vflag == 1)
                                    ret_mar = ret_mar + "ए";
                                else
                                    ret_mar = ret_mar + "े";
                            }
                        }
                    } else if(english.charAt(i + 1) != 'e')
                        ret_mar = ret_mar + "ए";
                    else
                        ret_mar = ret_mar + "ई";
                    break;
                case 'f':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्फ";
                        } else
                            ret_mar = ret_mar + "फ";
                    } else
                        ret_mar = ret_mar + "फ";
                    break;
                case 'g':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्घ";
                                i++;
                            } else
                                ret_mar = ret_mar + "्ग";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "घ";
                                i++;
                            } else
                                ret_mar = ret_mar + "ग";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "घ";
                            i++;
                        } else
                            ret_mar = ret_mar + "ग";
                    }
                    break;

                case 'h':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्ह";
                        } else
                            ret_mar = ret_mar + "ह";
                    } else
                        ret_mar = ret_mar + "ह";
                    break;
                case 'H':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्ऋ";
                        } else
                            ret_mar = ret_mar + "ऋ";
                    } else
                        ret_mar = ret_mar + "ऋ";
                    i = i + 2;
                    vflag = 1;
                    continue;
                case 'i':
                    if (i > 0)
                        ret_mar = ret_mar + "ि";
                    else
                        ret_mar = ret_mar + "इ";
                    break;
                case 'j':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्झ";
                                i++;
                            } else if (english.charAt(i + 1) == 'n') {
                                ret_mar = ret_mar + "्ज्ञ";
                                i = i + 2;
                            } else
                                ret_mar = ret_mar + "्ज";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "झ";
                                i++;
                            } else if (english.charAt(i + 1) == 'n') {
                                ret_mar = ret_mar + "ज्ञ";
                                i = i + 1;
                            } else
                                ret_mar = ret_mar + "ज";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "झ";
                            i++;
                        } else
                            ret_mar = ret_mar + "ज";
                    }
                    break;
                case 'k':
                    if (i > 0) {
                        if (vflag == 0) {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "्ख";
                                i++;
                            } else
                                ret_mar = ret_mar + "्क";
                        } else {
                            if (english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "ख";
                                i++;
                            } else
                                ret_mar = ret_mar + "क";
                        }
                    } else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "ख";
                            i++;
                        } else
                            ret_mar = ret_mar + "क";
                    }
                    break;
                case 'l':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्ल";
                        } else
                            ret_mar = ret_mar + "ल";
                    } else
                        ret_mar = ret_mar + "ल";
                    break;
                case 'L':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्ळ";
                        } else
                            ret_mar = ret_mar + "ळ";
                    } else
                        ret_mar = ret_mar + "ळ";
                    break;
                case 'm':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्म";
                        } else
                            ret_mar = ret_mar + "म";
                    } else
                        ret_mar = ret_mar + "म";
                    break;
                case 'M':
                    ret_mar = ret_mar + "ं" ;
                    vflag = 1;
                    continue;
                case 'n':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्न";
                        } else
                            ret_mar = ret_mar + "न";
                    } else
                        ret_mar = ret_mar + "न";
                    break;
                case 'N':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्ण";
                        } else
                            ret_mar = ret_mar + "ण";
                    } else
                        ret_mar = ret_mar + "ण";
                    break;
                case 'o':
                    if (i + 1 == english.length()) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "ो";
                        } else
                            ret_mar = ret_mar + "ओ";
                        break;
                    }
/*					if(prev == 'o' && i == 1) {
						ret_mar += "ऊ";
						break;
					}
  */                  temp = english.charAt(i + 1);
                    if (temp == 'o') {
                        if (vflag == 0 && i != 0) {
                            ret_mar = ret_mar + "ू";
                        } else
                            ret_mar = ret_mar + "ऊ";
                        i++;
                    }
                    else if(temp == 'w'){
                        if(vflag == 0)
                            ret_mar = ret_mar + "ॉ" ;
                        else
                            ret_mar = ret_mar + "ऑ";
                        i++;
                    }
                    else {
                        if (i > 0) {
                            if (vflag == 0) {
                                ret_mar = ret_mar + "ो";
                            } else
                                ret_mar = ret_mar + "ओ";
                        } else
                            ret_mar = ret_mar + "ओ";
                    }
                    break;
                case 'O':
                    if(i == 0)
                        ret_mar = ret_mar + "ऑ";
                    else {
                        if(vflag == 0)
                            ret_mar = ret_mar + "ॉ" ;
                        else
                            ret_mar = ret_mar + "ऑ";
                    }
                    vflag = 1;
                    continue;
                case 'p':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्प";
                        } else
                            ret_mar = ret_mar + "प";
                    } else
                        ret_mar = ret_mar + "प";
                    break;

                case 'r':
                    if (i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्र";
                        } else
                            ret_mar = ret_mar + "र";
                    } else
                        ret_mar = ret_mar + "र";
                    break;
                case 'R':
                    ret_mar = ret_mar + 'ृ';
                    i++;
                    vflag = 1;
                    continue;
                case 's':
                    temp = english.charAt(i + 1);
                    if (i == 0) {
                        if (temp == 'h') {
                            ret_mar = ret_mar + "श";
                            i++;
                        }
                        else
                            ret_mar = ret_mar + "स";
                    }
                    else if(i > 0) {
                        if (vflag == 0) {
                            if(temp == 'h') {
                                ret_mar = ret_mar + "्श";
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "्स";
                        } else {

                            if(temp == 'h') {
                                ret_mar = ret_mar + "श";
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "स";
                        }
                    }   break;
                case 'S':
                    if(vflag == 0)
                        ret_mar = ret_mar + "्ष" ;
                    else
                        ret_mar = ret_mar + "ष";
                    i++;
                    break;
                case 't':
                    if(i > 0){
                        if(vflag == 0){
                            if(english.charAt(i + 1) == 'h'){
                                ret_mar = ret_mar + "्थ" ;
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "्त" ;
                        }
                        else {
                            if(english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "थ";
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "त";
                        }
                    }
                    else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "थ";
                            i++;
                        }
                        else
                            ret_mar = ret_mar + "त";
                    }
                    break;
                case 'T':
                    if(i > 0){
                        if(vflag == 0){
                            if(english.charAt(i + 1) == 'h'){
                                ret_mar = ret_mar + "्ठ" ;
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "्ट" ;
                        }
                        else {
                            if(english.charAt(i + 1) == 'h') {
                                ret_mar = ret_mar + "ठ";
                                i++;
                            }
                            else
                                ret_mar = ret_mar + "ट";
                        }
                    }
                    else {

                        if (english.charAt(i + 1) == 'h') {
                            ret_mar = ret_mar + "ठ";
                            i++;
                        }
                        else
                            ret_mar = ret_mar + "ट";
                    }
                    break;
                case 'u':
                    if(i > 0){
                        if(vflag == 0){
                            ret_mar = ret_mar + "ु";
                        }
                        else {
                            ret_mar = ret_mar + "उ";
                        }
                    }
                    else
                        ret_mar = ret_mar + "उ";
                    break;
                case 'U':
                    ret_mar = ret_mar + "ॐ";
                    vflag = 1;
                    continue;
                case 'v':
                    if(i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्व";
                        } else
                            ret_mar = ret_mar + "व";
                    }
                    else
                        ret_mar = ret_mar + "व";
                    break;

                case 'w':
                    if(i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्व";
                        } else
                            ret_mar = ret_mar + "व";
                    }
                    else
                        ret_mar = ret_mar + "व";
                    break;

                case 'y':
                    if(i > 0) {
                        if (vflag == 0) {
                            ret_mar = ret_mar + "्य" ;
                        } else
                            ret_mar = ret_mar + "य";
                    }
                    else
                        ret_mar = ret_mar + "य";
                    break;
                case 'Y':
                    if(i == 0)
                        ret_mar = ret_mar + "ऍ";
                    else {
                        if(vflag == 0)
                            ret_mar = ret_mar + "ॅ" ;
                        else
                            ret_mar = ret_mar + "ऍ";
                    }
                    vflag = 1;
                    continue;
                case ' ':
                    ret_mar = ret_mar + " ";
                    vflag = 0;
                    english = english.substring(i + 1, english.length());
                    i = -1;
                    continue;
            }
            prev = ch;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o')
                vflag = 1;
            else
                vflag = 0;
        }
        return ret_mar;
    }
    public int Number_M2E(String marathi) {
        int ret_int;
        String conv_mar = "";
        String enums = "0123456789";
        for(int i = 0; i < marathi.length(); i++) {
            char ch = marathi.charAt(i);
            switch(ch) {
                case '०':
                    conv_mar = conv_mar + enums.charAt(0);
                    break;
                case '१':
                    conv_mar = conv_mar + enums.charAt(1);
                    break;
                case '२':
                    conv_mar = conv_mar + enums.charAt(2);
                    break;
                case '३':
                    conv_mar = conv_mar + enums.charAt(3);
                    break;
                case '४':
                    conv_mar = conv_mar + enums.charAt(4);
                    break;
                case '५':
                    conv_mar = conv_mar + enums.charAt(5);
                    break;
                case '६':
                    conv_mar = conv_mar + enums.charAt(6);
                    break;
                case '७':
                    conv_mar = conv_mar + enums.charAt(7);
                    break;
                case '८':
                    conv_mar = conv_mar + enums.charAt(8);
                    break;
                case '९':
                    conv_mar = conv_mar + enums.charAt(9);
                    break;
            }
        }
        ret_int = Integer.parseInt(conv_mar);
        return ret_int;
    }
    public String Number_E2M(String english) {
        String ret_mar = "";
        String mnums = "०१२३४५६७८९";
        for(int i = 0; i < english.length(); i++) {
            char ch = english.charAt(i);

            switch(ch) {
                case '0':
                    ret_mar  = ret_mar + mnums.charAt(0);
                    break;
                case '1':
                    ret_mar  = ret_mar + mnums.charAt(1);
                    break;
                case '2':
                    ret_mar  = ret_mar + mnums.charAt(2);
                    break;
                case '3':
                    ret_mar  = ret_mar + mnums.charAt(3);
                    break;
                case '4':
                    ret_mar  = ret_mar + mnums.charAt(4);
                    break;
                case '5':
                    ret_mar  = ret_mar + mnums.charAt(5);
                    break;
                case '6':
                    ret_mar  = ret_mar + mnums.charAt(6);
                    break;
                case '7':
                    ret_mar  = ret_mar + mnums.charAt(7);
                    break;
                case '8':
                    ret_mar  = ret_mar + mnums.charAt(8);
                    break;
                case '9':
                    ret_mar  = ret_mar + mnums.charAt(9);
                    break;
                default:
                    ret_mar += ch;
            }
        }
        return ret_mar;
    }

    public String Letter_M2E(String marathi) {
        int len = marathi.length();
        String ret_eng = "";
        for(int i = 0; i < len; i++) {
            char a_char = marathi.charAt(i);
            switch(a_char) {
                case ' ':
                    ret_eng = ret_eng + " ";
                    break;
                case '\n':
                    ret_eng = ret_eng + "\n";
                    break;
                case 'अ':
                    ret_eng = ret_eng + "a";
                    break;
                case 'आ':
                    ret_eng = ret_eng + "aa";
                    break;
                case 'इ':
                    ret_eng = ret_eng + "i";
                    break;
                case 'ई':
                    ret_eng = ret_eng + "ee";
                    break;
                case 'उ':
                    ret_eng = ret_eng + "u";
                    break;
                case 'ऊ':
                    ret_eng = ret_eng + "oo";
                    break;
                case 'ए':
                    ret_eng = ret_eng + "e";
                    break;
                case 'ऐ':
                    ret_eng = ret_eng + "ai";
                    break;
                case 'ओ':
                    ret_eng = ret_eng + "o";
                    break;
                case 'औ':
                    ret_eng = ret_eng + "au";
                    break;
                case 'ा':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "aa";
                    break;
                case 'ं':
                    ret_eng = ret_eng + "M";
                    break;
                case 'ः':
                    ret_eng = ret_eng + "A";
                    break;
                case 'क':
                    ret_eng = ret_eng + "ka";
                    break;
                case 'ख':
                    ret_eng = ret_eng + "kha";
                    break;
                case 'ग':
                    ret_eng = ret_eng + "ga";
                    break;
                case 'घ':
                    ret_eng = ret_eng + "gha";
                    break;
                case 'ञ':
                    ret_eng = ret_eng + "na";
                    break;
                case 'च':
                    ret_eng = ret_eng + "cha";
                    break;
                case 'छ':
                    ret_eng = ret_eng + "chha";
                    break;
                case 'ऋ':
                    ret_eng = ret_eng + "HRu";
                    break;
                case 'ज':
                    ret_eng = ret_eng + "ja";
                    break;
                case 'झ':
                    ret_eng = ret_eng + "jha";
                    break;
                case 'ट':
                    ret_eng = ret_eng + "Ta";
                    break;
                case 'ठ':
                    ret_eng = ret_eng + "Tha";
                    break;
                case 'ड':
                    ret_eng = ret_eng + "Da";
                    break;
                case '़':
                    break;
                case 'ढ':
                    ret_eng = ret_eng + "Dha";
                    break;
                case 'ण':
                    ret_eng = ret_eng + "Na";
                    break;
                case '्' :
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    break;
                case 'त':
                    ret_eng = ret_eng + "ta";
                    break;
                case 'थ':
                    ret_eng = ret_eng + "tha";
                    break;
                case 'द':
                    ret_eng = ret_eng + "da";
                    break;
                case 'ध':
                    ret_eng = ret_eng + "dha";
                    break;
                case 'न':
                    ret_eng = ret_eng + "na";
                    break;
                case 'प':
                    ret_eng = ret_eng + "pa";
                    break;
                case 'फ':
                    ret_eng = ret_eng + "fa";
                    break;
                case 'ब':
                    ret_eng = ret_eng + "ba";
                    break;
                case 'भ':
                    ret_eng = ret_eng + "bha";
                    break;
                case 'म':
                    ret_eng = ret_eng + "ma";
                    break;
                case 'य':
                    ret_eng = ret_eng + "ya";
                    break;
                case 'र':
                    ret_eng = ret_eng + "ra";
                    break;
                case 'ल':
                    ret_eng = ret_eng + "la";
                    break;
                case 'व':
                    ret_eng = ret_eng + "va";
                    break;
                case 'श':
                    ret_eng = ret_eng + "sha";
                    break;
                case 'ष':
                    ret_eng = ret_eng + "Sha";
                    break;
                case 'स':
                    ret_eng = ret_eng + "sa";
                    break;
                case 'ह':
                    ret_eng = ret_eng + "ha";
                    break;
                case 'ळ':
                    ret_eng = ret_eng + "La";
                    break;
                case 'ॅ' :
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "Y";
                    break;
                case 'ऍ':
                    ret_eng = ret_eng + "Y";
                    break;
                case 'ॉ' :
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "O";
                    break;
                case 'ऑ':
                    ret_eng = ret_eng + "O";
                    break;
                case 'ो' :
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "o";
                    break;
                case 'ू':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "oo";
                    break;
                case 'ु':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "u";
                    break;
                case 'े':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "e";
                    break;
                case 'ै':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "ai";
                    break;
                case 'ृ':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "Ru";
                    break;
                case 'ौ':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "au";
                    break;
                case 'ि':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "i";
                    break;
                case 'ी':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "ee";
                    break;
                case 'ँ':
                    ret_eng = ret_eng.substring(0, ret_eng.length() - 1);
                    ret_eng = ret_eng + "am";
                    break;
                case 'ॐ':
                    ret_eng = ret_eng + 'U';
                    break;
                default:
                    ret_eng = ret_eng + a_char;

            }
        }

        return ret_eng;
    }

}
