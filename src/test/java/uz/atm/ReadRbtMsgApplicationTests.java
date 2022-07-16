package uz.atm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.atm.services.GeneralService;

import java.util.Scanner;

@SpringBootTest
class ReadRbtMsgApplicationTests {
    @Autowired
    private GeneralService generalService;


    @Test
    void contextLoads() {
        generalService.parser(noResult());

    }

    private String contractInfo() {
        return "{\n" +
                "  \"RESPONSE_ID\": 3564309,\n" +
                "  \"REQUEST_ID\": 2262939,\n" +
                "  \"METHOD_NAME\": \"CONTRACT_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110023678785,\n" +
                "    \"REGDAT\": \"16072022\",\n" +
                "    \"GENID\": 0,\n" +
                "    \"ID\": 30093719,\n" +
                "    \"CONTRACTNUM\": \"57\",\n" +
                "    \"VERSION\": 0,\n" +
                "    \"SUMMA\": 1260000000,\n" +
                "    \"LS\": \"100010860262777042107080001\",\n" +
                "    \"MFO\": \"00121\",\n" +
                "    \"ACC\": \"20208000100821867001\",\n" +
                "    \"INN\": \"305126226\",\n" +
                "    \"KLS\": \"\",\n" +
                "    \"STATE\": 2,\n" +
                "    \"ACTIONNAME\": \"Утвердить\",\n" +
                "    \"ERRMSG\": \"\"\n" +
                "  }\n" +
                "}";
    }

    private String resultatStr() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2265697,\n" +
                "  \"METHOD_NAME\": \"RESULTAT\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110010239781,\n" +
                "    \"PROC_ID\": 19,\n" +
                "    \"GEN_ID\": null,\n" +
                "    \"VERSION\": 26,\n" +
                "    \"LOTDATE1\": null,\n" +
                "    \"LOTDATE2\": null,\n" +
                "    \"CONTRACTNUM\": \"доп сог№2 дог№TS-230\",\n" +
                "    \"CONTRACTDAT\": \"05072022\",\n" +
                "    \"DVR\": 3,\n" +
                "    \"ORGAN\": \"00573001028\",\n" +
                "    \"INN\": \"200935895\",\n" +
                "    \"LS\": \"401421860262777073101054001\",\n" +
                "    \"VENDORNAME\": \"ООО IT-Med\",\n" +
                "    \"VENDORBANK\": \"00440\",\n" +
                "    \"VENDORACC\": \"20208000300957658001\",\n" +
                "    \"VENDORINN\": \"305926021\",\n" +
                "    \"VENDORKLS\": null,\n" +
                "    \"MALOY\": \"Y\",\n" +
                "    \"SUMMA\": 816000000,\n" +
                "    \"AVANS\": 244800000,\n" +
                "    \"AVANSDAY\": 30,\n" +
                "    \"CONTRACTBEG\": \"05012022\",\n" +
                "    \"CONTRACTEND\": \"31122022\",\n" +
                "    \"PURPOSE\": \"Ихтисослаштирилган ахборот тизимларини техник куллаб кувватлаш реквизит узгармокда\",\n" +
                "    \"SROK\": 30,\n" +
                "    \"VENDORTERR\": \"00000\",\n" +
                "    \"LINKS\": null,\n" +
                "    \"FINSRC\": [\n" +
                "      {\n" +
                "        \"NPOS\": 1,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"BANKCODE\": \"00014\",\n" +
                "        \"BANKACC\": \"23402000300100001010\",\n" +
                "        \"SUMMA\": 816000000\n" +
                "      }\n" +
                "    ],\n" +
                "    \"SPECIFICATIONS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 1,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 3,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 204000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 3,\n" +
                "            \"TOVARAMOUNT\": 3\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 2,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 4,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 3,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 5,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 4,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 6,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 5,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 7,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 6,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 8,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 7,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 9,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 8,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 10,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 9,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 11,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"NPOS\": 10,\n" +
                "        \"TOVAR\": \"62.02.30.000-00001\",\n" +
                "        \"TOVARNAME\": \"Услуги по технической поддержке информационных технологий\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 68000000,\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\",\n" +
                "        \"NOTE\": \"Интернет\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 12,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"GRAFICS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 3,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 204000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 4,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 5,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 6,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 7,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 8,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 9,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 10,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 11,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 12,\n" +
                "        \"KLS\": \"401421860262777073101054001\",\n" +
                "        \"TOVARSUMMA\": 68000000,\n" +
                "        \"EXPENSE\": \"44292200\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"BENEFICIAR\": \"-\",\n" +
                "    \"RASCHOT\": null,\n" +
                "    \"REESTR_ID\": 22110010679291,\n" +
                "    \"PNFL\": null,\n" +
                "    \"CONTRACT_ID\": 29255380,\n" +
                "    \"SUMNDS\": null\n" +
                "  }\n" +
                "}";
    }

    private String resultatArr() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2265943,\n" +
                "  \"METHOD_NAME\": \"RESULTAT\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110021679344,\n" +
                "    \"PROC_ID\": 19,\n" +
                "    \"LOTDATE1\": null,\n" +
                "    \"LOTDATE2\": null,\n" +
                "    \"CONTRACTNUM\": \"5623757\",\n" +
                "    \"CONTRACTDAT\": \"16072022\",\n" +
                "    \"DVR\": 1,\n" +
                "    \"ORGAN\": \"00000024302\",\n" +
                "    \"INN\": \"305362693\",\n" +
                "    \"LS\": \"470010860064017045193118002\",\n" +
                "    \"VENDORNAME\": \"O`ZBEKISTON RESPUBLIKASI TOVAR-XOMASHYO BIRJASI AKSIYADORLIK JAMIYATI\",\n" +
                "    \"VENDORBANK\": \"00491\",\n" +
                "    \"VENDORACC\": \"20208000300600257009\",\n" +
                "    \"VENDORINN\": \"200933985\",\n" +
                "    \"PNFL\": null,\n" +
                "    \"VENDORKLS\": null,\n" +
                "    \"MALOY\": \"Y\",\n" +
                "    \"SUMMA\": 16000000000,\n" +
                "    \"AVANS\": 16000000000,\n" +
                "    \"AVANSDAY\": 5,\n" +
                "    \"CONTRACTBEG\": \"16072022\",\n" +
                "    \"CONTRACTEND\": \"31122022\",\n" +
                "    \"PURPOSE\": \"16.07.2022 йдаги 20220716-сонли садо баённомасига асосан BUKHARA UNI-TRADE FLOW MCHJ (ИНН309210713) томонидан 25000 кг битум етказиб бериш учун шартноманинг 3.2 бандига асосан олдиндан 100% туловни оператор хисоб ракамига кучириш учун\",\n" +
                "    \"SROK\": 15,\n" +
                "    \"VENDORTERR\": \"26287\",\n" +
                "    \"LINKS\": null,\n" +
                "    \"FINSRC\": [\n" +
                "      {\n" +
                "        \"NPOS\": 1,\n" +
                "        \"KLS\": \"470010860064017045193118002\",\n" +
                "        \"BANKCODE\": \"00014\",\n" +
                "        \"BANKACC\": \"23402000300100001010\",\n" +
                "        \"SUMMA\": 16000000000\n" +
                "      }\n" +
                "    ],\n" +
                "    \"SPECIFICATIONS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"470010860064017045193118002\",\n" +
                "        \"NPOS\": 1,\n" +
                "        \"TOVAR\": \"19.20.42.129-00001\",\n" +
                "        \"TOVARNAME\": \"Битум\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 25000,\n" +
                "        \"TOVARPRICE\": 640000,\n" +
                "        \"TOVARSUMMA\": 16000000000,\n" +
                "        \"EXPENSE\": \"44821190\",\n" +
                "        \"NOTE\": [\n" +
                "          {\n" +
                "            \"TECHSPEC\": \"Битум нефтяной дорожный вязкий марки BND 60/90\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 7,\n" +
                "            \"TOVARAMOUNT\": 25000\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"кг\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"GRAFICS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 7,\n" +
                "        \"KLS\": \"470010860064017045193118002\",\n" +
                "        \"TOVARSUMMA\": 16000000000,\n" +
                "        \"EXPENSE\": \"44821190\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"BENEFICIAR\": \"-\",\n" +
                "    \"RASCHOT\": null,\n" +
                "    \"REESTR_ID\": 679344,\n" +
                "    \"SUMNDS\": 2086956522\n" +
                "  }\n" +
                "}";
    }

    private String requestEtp() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2265701,\n" +
                "  \"METHOD_NAME\": \"REQUEST_ETP\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22111008544333,\n" +
                "    \"DOCDATE\": \"16072022\",\n" +
                "    \"ORGAN\": \"31000000224\",\n" +
                "    \"ACC\": \"302810860262627015300254001\",\n" +
                "    \"SUMLOT\": 678000000,\n" +
                "    \"PLTF\": 2,\n" +
                "    \"MONTH\": 7,\n" +
                "    \"SPECIFICATIONS\": [\n" +
                "      {\n" +
                "        \"NPOS\": 1,\n" +
                "        \"TOVAR\": \"15.12.11.120-00004\",\n" +
                "        \"TOVARNAME\": \"Жилет для собак\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 3,\n" +
                "        \"TOVARPRICE\": 226000000,\n" +
                "        \"TOVARSUMMA\": 678000000,\n" +
                "        \"EXPENSE\": \"44299990\",\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"шт\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

    private String facturaInfo() {
        return "{\n" +
                "  \"RESPONSE_ID\": 3564314,\n" +
                "  \"REQUEST_ID\": 992205,\n" +
                "  \"METHOD_NAME\": \"FACTURA_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"COUNTS\": 1,\n" +
                "    \"RECORDS\": [\n" +
                "      {\n" +
                "        \"INVOICEID\": 30287616,\n" +
                "        \"LOTID\": 22110024326350,\n" +
                "        \"CONTRACT\": 29429662,\n" +
                "        \"KLS\": \"100010860262947056100144001\",\n" +
                "        \"NUMBINVOICE\": \"871\",\n" +
                "        \"DATEINVOICE\": \"30062022\",\n" +
                "        \"CONAME\": \"ГФС ГКСИ и ТТРУз\",\n" +
                "        \"COINN\": \"200898364\",\n" +
                "        \"DATEDOC\": \"05012022\",\n" +
                "        \"SUMPAY\": 58155400,\n" +
                "        \"NAMEWARRANT\": \"\",\n" +
                "        \"STATE\": 2,\n" +
                "        \"GEN_ID\": 0,\n" +
                "        \"SPECIFICATIONS\": [\n" +
                "          {\n" +
                "            \"NPOS\": 1,\n" +
                "            \"TOVAR\": \"53.20.11.121-00001\",\n" +
                "            \"TOVARNAME\": \"Услуги государственной фельдъегерской связи\",\n" +
                "            \"TOVAREDIZM\": \"25\",\n" +
                "            \"TOVARAMOUNT\": 2,\n" +
                "            \"TOVARPRICE\": 29077700,\n" +
                "            \"TOVARSUMMA\": 58155400,\n" +
                "            \"EXPENSE\": \"44292100\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

    private String rkpPaysInfo() {
        return "{\n" +
                "  \"RESPONSE_ID\": 3564321,\n" +
                "  \"REQUEST_ID\": 2265250,\n" +
                "  \"METHOD_NAME\": \"RKP_PAYS_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"PAYID\": 329167,\n" +
                "    \"ID\": 560715169,\n" +
                "    \"LOTID\": 22111008524716,\n" +
                "    \"OPERDAY\": \"16072022\",\n" +
                "    \"DOCNUMB\": \"329167\",\n" +
                "    \"DOCDATE\": \"16072022\",\n" +
                "    \"ACC\": \"401021860274017049996225001\",\n" +
                "    \"SUMPAY\": 455997600,\n" +
                "    \"CONTRACT\": 30073452,\n" +
                "    \"STATE\": 7,\n" +
                "    \"ERRMSG\": \"\"\n" +
                "  }\n" +
                "}";
    }

    private String successInfo() {
        return "{\n" +
                "  \"REQUEST_ID\": 2265845,\n" +
                "  \"RESPONSE_ID\": 3564736,\n" +
                "  \"METHOD_NAME\": \"SUCCESS_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110031679321,\n" +
                "    \"MSG\": \"Принято на рассмотрение\"\n" +
                "  }\n" +
                "}";
    }

    private String errorInfo() {
        return "{\n" +
                "  \"REQUEST_ID\": 3564826,\n" +
                "  \"RESPONSE_ID_PARENT\": 0,\n" +
                "  \"REQUEST_ID_PARENT\": 2265929,\n" +
                "  \"METHOD_NAME\": \"ERROR_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22111008544386,\n" +
                "    \"ERRTXT\": \"Для лицевого счета `100022860222267042136250001` Недостаточно средств по статье 44299990 по месяцу 7 ! Сумма по смете = `3,737,000.00` Сумма всех договоров  = `3,202,511.50` + Сумма текущего документа = `1,000,000.00` ИТОГ `4,202,511.50` больше чем смета на `465,511.50` при проверки графика за `7` месяц\"\n" +
                "  }\n" +
                "}";
    }

    private String rkpEnd() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2265938,\n" +
                "  \"METHOD_NAME\": \"RKP_END\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22111008487305,\n" +
                "    \"GEN_ID\": null,\n" +
                "    \"ID\": 29991547,\n" +
                "    \"ACTION\": 5,\n" +
                "    \"STRAF\": \"N\",\n" +
                "    \"SITE\": \"N\",\n" +
                "    \"MSG\": \"Взаимно согласия\"\n" +
                "  }\n" +
                "}";
    }

    private String claimInfoEtp() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2266075,\n" +
                "  \"METHOD_NAME\": \"CLAIM_INFO_ETP\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110012123880,\n" +
                "    \"PROC_ID\": 2,\n" +
                "    \"DATE1\": \"16072022\",\n" +
                "    \"DATE2\": \"16072022\",\n" +
                "    \"DVR\": 3,\n" +
                "    \"ORGAN\": \"49585000002\",\n" +
                "    \"INN\": \"304943564\",\n" +
                "    \"SUMMA\": 57600000,\n" +
                "    \"SROK\": 10,\n" +
                "    \"KLS\": \"304521860274017045129118251\",\n" +
                "    \"PURPOSE\": \"В электронном виде\",\n" +
                "    \"FINSRC\": [\n" +
                "      {\n" +
                "        \"NPOS\": 1,\n" +
                "        \"KLS\": \"304521860274017045129118251\",\n" +
                "        \"BANKCODE\": \"00014\",\n" +
                "        \"BANKACC\": \"23402000300100001010\",\n" +
                "        \"SUMMA\": 57600000\n" +
                "      }\n" +
                "    ],\n" +
                "    \"SPECIFICATIONS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"KLS\": \"304521860274017045129118251\",\n" +
                "        \"NPOS\": 1,\n" +
                "        \"TOVAR\": \"71.12.12.130-00004\",\n" +
                "        \"TOVARNAME\": \"Услуга по разработке проектно-сметных работ\",\n" +
                "        \"TOVARNOTE\": \"Пискент туман  Тараққиёт МФЙ Ўрикзор кўчасини жорий таъмирлаш лойиҳа-смета ҳужжатларини ишлаб чиқиш\",\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVARPRICE\": 57600000,\n" +
                "        \"TOVARSUMMA\": 57600000,\n" +
                "        \"EXPENSE\": \"44239000\",\n" +
                "        \"SPLIT\": [\n" +
                "          {\n" +
                "            \"MONTH\": 7,\n" +
                "            \"TOVARAMOUNT\": 1\n" +
                "          }\n" +
                "        ],\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"GRAFICS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 7,\n" +
                "        \"KLS\": \"304521860274017045129118251\",\n" +
                "        \"SUMMA\": 57600000,\n" +
                "        \"EXPENSE\": \"44239000\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

    private String responseAuction() {
        return "{\n" +
                "  \"RESPONSE_ID\": 3565054,\n" +
                "  \"REQUEST_ID\": 2266047,\n" +
                "  \"METHOD_NAME\": \"RESPONSE_AUCTION\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22111008544419,\n" +
                "    \"STATE\": 2,\n" +
                "    \"MSG\": \"\"\n" +
                "  }\n" +
                "}";
    }

    private String rkpPays() {
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2266080,\n" +
                "  \"METHOD_NAME\": \"RKP_PAYS\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"PAYID\": 329317,\n" +
                "    \"PAYTYPE\": 3,\n" +
                "    \"DOCNUMB\": \"329317\",\n" +
                "    \"DOCDATE\": \"16072022\",\n" +
                "    \"SUMPAY\": 23998000,\n" +
                "    \"CURRENCY\": 860,\n" +
                "    \"CONTRACT\": 30063349,\n" +
                "    \"LOTID\": 22111008519463,\n" +
                "    \"ACCETP\": \"700110860262877950600262007\",\n" +
                "    \"CONAME\": \"PARFUME LUXE MCHJ\",\n" +
                "    \"COMFO\": \"00433\",\n" +
                "    \"COACC\": \"20208000601001142001\",\n" +
                "    \"COKLS\": null,\n" +
                "    \"COINN\": \"306097967\",\n" +
                "    \"VENDORPINFL\": null,\n" +
                "    \"PURPOSE\": \"700110860262877950600262007~200933985~За Вещества химические и продукты химические, договор №450116 от 07.07.2022 от ИНН: 305866588(Национальная палата инновационного здравоохранения Республики Узбекист) xarid.uzex.uz (Электронный магазин)\",\n" +
                "    \"CNTRSUM\": \"736D6D1A92AEEDE55FEB116F02C9AA390E7AD840\"\n" +
                "  }\n" +
                "}";
    }

    private String responseClaimInfo() {
        return "{\n" +
                "  \"RESPONSE_ID\": 3565085,\n" +
                "  \"REQUEST_ID\": 2266119,\n" +
                "  \"METHOD_NAME\": \"RESPONSE_CLAIM_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110012123893,\n" +
                "    \"CLAIM_ID\": 55538,\n" +
                "    \"ORGAN\": \"49585000002\",\n" +
                "    \"INN\": \"304943564\",\n" +
                "    \"KLS\": \"304521860274017045129118438\",\n" +
                "    \"SUMMA\": 414100000,\n" +
                "    \"STATE\": 4,\n" +
                "    \"MSG\": \"\"\n" +
                "  }\n" +
                "}";
    }

    private String paysByLotId(){
        return "{\n" +
                "  \"RESPONSE_ID\": 3565191,\n" +
                "  \"REQUEST_ID\": 0,\n" +
                "  \"METHOD_NAME\": \"PAYS_BY_LOTID\",\n" +
                "  \"PAYLOAD\": [\n" +
                "    {\n" +
                "      \"PAYID\": 0,\n" +
                "      \"OPERDAY\": \"16072022\",\n" +
                "      \"PAYTYPE\": 3,\n" +
                "      \"ID\": 560714899,\n" +
                "      \"DOCNUMB\": \"0530001093\",\n" +
                "      \"DOCDATE\": \"16072022\",\n" +
                "      \"SUMPAY\": 70327500000,\n" +
                "      \"CONTRACT\": 29791104,\n" +
                "      \"LOTID\": 22411006009378,\n" +
                "      \"CLNAME\": \"Сирдаре вилояти хокимлигининг курилиш буиича ягона буюртмачи хизмати и\",\n" +
                "      \"CLMFO\": \"00014\",\n" +
                "      \"CLACC\": \"23402000300100001010\",\n" +
                "      \"CLKLS\": \"100021860244017016801018046\",\n" +
                "      \"CLINN\": \"204773938\",\n" +
                "      \"CLPINFL\": \"\",\n" +
                "      \"CONAME\": \"Sobirjon Davronjon Hamkor XK\",\n" +
                "      \"COMFO\": \"00370\",\n" +
                "      \"COACC\": \"20208000704885297001\",\n" +
                "      \"COKLS\": \"\",\n" +
                "      \"COINN\": \"301820205\",\n" +
                "      \"COPINFL\": \"00000000000000\",\n" +
                "      \"OPER\": \"2010\",\n" +
                "      \"PURPOSE\": \"100021860244017016801018046~204773938~Сирдарё вилояти Ягона буюртмачи ХИК~16.05.2022 йил шартнома №113га асосан Янгиер шахри худудидан утувчи Жанубий Мирзачул каналининг жанубий ва шимолий киргоги буйлаб саломатлик йулакларини куришга баж иш 13,07,2022й хис фак №2га асосан  46.8% утказилди.; Ст.  43.22.900\",\n" +
                "      \"ERRMSG\": \"000\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private String queryPlan(){
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2266719,\n" +
                "  \"METHOD_NAME\": \"QUERY_PLAN\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"FINYEAR\": 2022,\n" +
                "    \"KLS\": \"400121860262667063201110003\",\n" +
                "    \"TOVARLIST\": []\n" +
                "  }\n" +
                "}";
    }

    private String queryKls(){
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2266725,\n" +
                "  \"METHOD_NAME\": \"QUERY_KLS\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"INN\": \"200170038\"\n" +
                "  }\n" +
                "}";
    }

    private String planInfo(){
        return "{\n" +
                "  \"RESPONSE_ID\": 3566336,\n" +
                "  \"REQUEST_ID\": 48448,\n" +
                "  \"METHOD_NAME\": \"PLAN_INFO\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"COUNTS\": 1,\n" +
                "    \"RECORDS\": [\n" +
                "      {\n" +
                "        \"FINYEAR\": 2022,\n" +
                "        \"MONTH\": 7,\n" +
                "        \"KLS\": \"304521860304087045129118001\",\n" +
                "        \"TOVAR\": \"41.20.40.900-00004\",\n" +
                "        \"TOVARNAME\": \"Услуги по капитальному ремонту сооружений\",\n" +
                "        \"EXPENSE\": \"44332100\",\n" +
                "        \"TOVARAMOUNT\": 1,\n" +
                "        \"TOVAREDIZM\": 0,\n" +
                "        \"TOVARPRICE\": 456900000000,\n" +
                "        \"SUMMA\": 456900000000,\n" +
                "        \"CONDITIONS\": \"тез ва сифатли\",\n" +
                "        \"ADRESS\": \"\",\n" +
                "        \"SROK\": 40,\n" +
                "        \"PROPERTIES\": [\n" +
                "          {\n" +
                "            \"PROP_NUMB\": 0,\n" +
                "            \"PROP_NAME\": \"Единица измерения\",\n" +
                "            \"VAL_NUMB\": 0,\n" +
                "            \"VAL_NAME\": \"усл. ед\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

    private String noResult(){
        return "{\n" +
                "  \"ETP_ID\": 1,\n" +
                "  \"REQUEST_ID\": 2266755,\n" +
                "  \"METHOD_NAME\": \"NO_RESULT\",\n" +
                "  \"PAYLOAD\": {\n" +
                "    \"LOTID\": 22110012124061,\n" +
                "    \"PROC_ID\": 4,\n" +
                "    \"PRICH\": 3\n" +
                "  }\n" +
                "}";
    }

}
