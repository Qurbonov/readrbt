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
/*        generalService.parser(contractInfo());
        generalService.parser(resultatStr());
        generalService.parser(resultatArr());
        generalService.parser(requestEtp());
        generalService.parser(facturaInfo());
        generalService.parser(rkpPaysInfo());
        generalService.parser(successInfo());
        generalService.parser(errorInfo());
        generalService.parser(rkpEnd());
        generalService.parser(claimInfoEtp());
        generalService.parser(responseAuction());
        generalService.parser(rkpPays());
        generalService.parser(responseClaimInfo());
        generalService.parser(paysByLotId());
        generalService.parser(queryPlan());
        generalService.parser(queryKls());
        generalService.parser(planInfo());
        generalService.parser(noResult());*/
        generalService.parser(def());

    }

    private String contractInfo() {
        return """
                {
                  "RESPONSE_ID": 3564309,
                  "REQUEST_ID": 2262939,
                  "METHOD_NAME": "CONTRACT_INFO",
                  "PAYLOAD": {
                    "LOTID": 22110023678785,
                    "REGDAT": "16072022",
                    "GENID": 0,
                    "ID": 30093719,
                    "CONTRACTNUM": "57",
                    "VERSION": 0,
                    "SUMMA": 1260000000,
                    "LS": "100010860262777042107080001",
                    "MFO": "00121",
                    "ACC": "20208000100821867001",
                    "INN": "305126226",
                    "KLS": "",
                    "STATE": 2,
                    "ACTIONNAME": "Утвердить",
                    "ERRMSG": ""
                  }
                }""";
    }
    private String def() {
        return """
                  {
                    "DIGEST_ID": 3598592,
                    "REQUEST_ID": 3626301,
                    "TYPE": "MAN_ORGANIZATIONS",
                    "PAYLOAD": {
                      "ID": "E41437BC698EC54DE0530100007F9A0C",
                      "PAGENUM": 0,
                      "PAGECNT": 0,
                      "DATA": []
                    }
                  }
                """;
    }

    private String resultatStr() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2265697,
                  "METHOD_NAME": "RESULTAT",
                  "PAYLOAD": {
                    "LOTID": 22110010239781,
                    "PROC_ID": 19,
                    "GEN_ID": null,
                    "VERSION": 26,
                    "LOTDATE1": null,
                    "LOTDATE2": null,
                    "CONTRACTNUM": "доп сог№2 дог№TS-230",
                    "CONTRACTDAT": "05072022",
                    "DVR": 3,
                    "ORGAN": "00573001028",
                    "INN": "200935895",
                    "LS": "401421860262777073101054001",
                    "VENDORNAME": "ООО IT-Med",
                    "VENDORBANK": "00440",
                    "VENDORACC": "20208000300957658001",
                    "VENDORINN": "305926021",
                    "VENDORKLS": null,
                    "MALOY": "Y",
                    "SUMMA": 816000000,
                    "AVANS": 244800000,
                    "AVANSDAY": 30,
                    "CONTRACTBEG": "05012022",
                    "CONTRACTEND": "31122022",
                    "PURPOSE": "Ихтисослаштирилган ахборот тизимларини техник куллаб кувватлаш реквизит узгармокда",
                    "SROK": 30,
                    "VENDORTERR": "00000",
                    "LINKS": null,
                    "FINSRC": [
                      {
                        "NPOS": 1,
                        "KLS": "401421860262777073101054001",
                        "BANKCODE": "00014",
                        "BANKACC": "23402000300100001010",
                        "SUMMA": 816000000
                      }
                    ],
                    "SPECIFICATIONS": [
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 1,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 3,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 204000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 3,
                            "TOVARAMOUNT": 3
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 2,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 4,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 3,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 5,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 4,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 6,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 5,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 7,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 6,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 8,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 7,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 9,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 8,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 10,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 9,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 11,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      },
                      {
                        "FINYEAR": 2022,
                        "KLS": "401421860262777073101054001",
                        "NPOS": 10,
                        "TOVAR": "62.02.30.000-00001",
                        "TOVARNAME": "Услуги по технической поддержке информационных технологий",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 68000000,
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200",
                        "NOTE": "Интернет",
                        "SPLIT": [
                          {
                            "MONTH": 12,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      }
                    ],
                    "GRAFICS": [
                      {
                        "FINYEAR": 2022,
                        "MONTH": 3,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 204000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 4,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 5,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 6,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 7,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 8,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 9,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 10,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 11,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      },
                      {
                        "FINYEAR": 2022,
                        "MONTH": 12,
                        "KLS": "401421860262777073101054001",
                        "TOVARSUMMA": 68000000,
                        "EXPENSE": "44292200"
                      }
                    ],
                    "BENEFICIAR": "-",
                    "RASCHOT": null,
                    "REESTR_ID": 22110010679291,
                    "PNFL": null,
                    "CONTRACT_ID": 29255380,
                    "SUMNDS": null
                  }
                }""";
    }

    private String resultatArr() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2265943,
                  "METHOD_NAME": "RESULTAT",
                  "PAYLOAD": {
                    "LOTID": 22110021679344,
                    "PROC_ID": 19,
                    "LOTDATE1": null,
                    "LOTDATE2": null,
                    "CONTRACTNUM": "5623757",
                    "CONTRACTDAT": "16072022",
                    "DVR": 1,
                    "ORGAN": "00000024302",
                    "INN": "305362693",
                    "LS": "470010860064017045193118002",
                    "VENDORNAME": "O`ZBEKISTON RESPUBLIKASI TOVAR-XOMASHYO BIRJASI AKSIYADORLIK JAMIYATI",
                    "VENDORBANK": "00491",
                    "VENDORACC": "20208000300600257009",
                    "VENDORINN": "200933985",
                    "PNFL": null,
                    "VENDORKLS": null,
                    "MALOY": "Y",
                    "SUMMA": 16000000000,
                    "AVANS": 16000000000,
                    "AVANSDAY": 5,
                    "CONTRACTBEG": "16072022",
                    "CONTRACTEND": "31122022",
                    "PURPOSE": "16.07.2022 йдаги 20220716-сонли садо баённомасига асосан BUKHARA UNI-TRADE FLOW MCHJ (ИНН309210713) томонидан 25000 кг битум етказиб бериш учун шартноманинг 3.2 бандига асосан олдиндан 100% туловни оператор хисоб ракамига кучириш учун",
                    "SROK": 15,
                    "VENDORTERR": "26287",
                    "LINKS": null,
                    "FINSRC": [
                      {
                        "NPOS": 1,
                        "KLS": "470010860064017045193118002",
                        "BANKCODE": "00014",
                        "BANKACC": "23402000300100001010",
                        "SUMMA": 16000000000
                      }
                    ],
                    "SPECIFICATIONS": [
                      {
                        "FINYEAR": 2022,
                        "KLS": "470010860064017045193118002",
                        "NPOS": 1,
                        "TOVAR": "19.20.42.129-00001",
                        "TOVARNAME": "Битум",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 25000,
                        "TOVARPRICE": 640000,
                        "TOVARSUMMA": 16000000000,
                        "EXPENSE": "44821190",
                        "NOTE": [
                          {
                            "TECHSPEC": "Битум нефтяной дорожный вязкий марки BND 60/90"
                          }
                        ],
                        "SPLIT": [
                          {
                            "MONTH": 7,
                            "TOVARAMOUNT": 25000
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "кг"
                          }
                        ]
                      }
                    ],
                    "GRAFICS": [
                      {
                        "FINYEAR": 2022,
                        "MONTH": 7,
                        "KLS": "470010860064017045193118002",
                        "TOVARSUMMA": 16000000000,
                        "EXPENSE": "44821190"
                      }
                    ],
                    "BENEFICIAR": "-",
                    "RASCHOT": null,
                    "REESTR_ID": 679344,
                    "SUMNDS": 2086956522
                  }
                }""";
    }

    private String requestEtp() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2265701,
                  "METHOD_NAME": "REQUEST_ETP",
                  "PAYLOAD": {
                    "LOTID": 22111008544333,
                    "DOCDATE": "16072022",
                    "ORGAN": "31000000224",
                    "ACC": "302810860262627015300254001",
                    "SUMLOT": 678000000,
                    "PLTF": 2,
                    "MONTH": 7,
                    "SPECIFICATIONS": [
                      {
                        "NPOS": 1,
                        "TOVAR": "15.12.11.120-00004",
                        "TOVARNAME": "Жилет для собак",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 3,
                        "TOVARPRICE": 226000000,
                        "TOVARSUMMA": 678000000,
                        "EXPENSE": "44299990",
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "шт"
                          }
                        ]
                      }
                    ]
                  }
                }""";
    }

    private String facturaInfo() {
        return """
                {
                  "RESPONSE_ID": 3564314,
                  "REQUEST_ID": 992205,
                  "METHOD_NAME": "FACTURA_INFO",
                  "PAYLOAD": {
                    "COUNTS": 1,
                    "RECORDS": [
                      {
                        "INVOICEID": 30287616,
                        "LOTID": 22110024326350,
                        "CONTRACT": 29429662,
                        "KLS": "100010860262947056100144001",
                        "NUMBINVOICE": "871",
                        "DATEINVOICE": "30062022",
                        "CONAME": "ГФС ГКСИ и ТТРУз",
                        "COINN": "200898364",
                        "DATEDOC": "05012022",
                        "SUMPAY": 58155400,
                        "NAMEWARRANT": "",
                        "STATE": 2,
                        "GEN_ID": 0,
                        "SPECIFICATIONS": [
                          {
                            "NPOS": 1,
                            "TOVAR": "53.20.11.121-00001",
                            "TOVARNAME": "Услуги государственной фельдъегерской связи",
                            "TOVAREDIZM": "25",
                            "TOVARAMOUNT": 2,
                            "TOVARPRICE": 29077700,
                            "TOVARSUMMA": 58155400,
                            "EXPENSE": "44292100"
                          }
                        ]
                      }
                    ]
                  }
                }""";
    }

    private String rkpPaysInfo() {
        return """
                {
                  "RESPONSE_ID": 3564321,
                  "REQUEST_ID": 2265250,
                  "METHOD_NAME": "RKP_PAYS_INFO",
                  "PAYLOAD": {
                    "PAYID": 329167,
                    "ID": 560715169,
                    "LOTID": 22111008524716,
                    "OPERDAY": "16072022",
                    "DOCNUMB": "329167",
                    "DOCDATE": "16072022",
                    "ACC": "401021860274017049996225001",
                    "SUMPAY": 455997600,
                    "CONTRACT": 30073452,
                    "STATE": 7,
                    "ERRMSG": ""
                  }
                }""";
    }

    private String successInfo() {
        return """
                {
                  "REQUEST_ID": 2265845,
                  "RESPONSE_ID": 3564736,
                  "METHOD_NAME": "SUCCESS_INFO",
                  "PAYLOAD": {
                    "LOTID": 22110031679321,
                    "MSG": "Принято на рассмотрение"
                  }
                }""";
    }

    private String errorInfo() {
        return """
                {
                  "REQUEST_ID": 3564826,
                  "RESPONSE_ID_PARENT": 0,
                  "REQUEST_ID_PARENT": 2265929,
                  "METHOD_NAME": "ERROR_INFO",
                  "PAYLOAD": {
                    "LOTID": 22111008544386,
                    "ERRTXT": "Для лицевого счета `100022860222267042136250001` Недостаточно средств по статье 44299990 по месяцу 7 ! Сумма по смете = `3,737,000.00` Сумма всех договоров  = `3,202,511.50` + Сумма текущего документа = `1,000,000.00` ИТОГ `4,202,511.50` больше чем смета на `465,511.50` при проверки графика за `7` месяц"
                  }
                }""";
    }

    private String rkpEnd() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2265938,
                  "METHOD_NAME": "RKP_END",
                  "PAYLOAD": {
                    "LOTID": 22111008487305,
                    "GEN_ID": null,
                    "ID": 29991547,
                    "ACTION": 5,
                    "STRAF": "N",
                    "SITE": "N",
                    "MSG": "Взаимно согласия"
                  }
                }""";
    }

    private String claimInfoEtp() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2266075,
                  "METHOD_NAME": "CLAIM_INFO_ETP",
                  "PAYLOAD": {
                    "LOTID": 22110012123880,
                    "PROC_ID": 2,
                    "DATE1": "16072022",
                    "DATE2": "16072022",
                    "DVR": 3,
                    "ORGAN": "49585000002",
                    "INN": "304943564",
                    "SUMMA": 57600000,
                    "SROK": 10,
                    "KLS": "304521860274017045129118251",
                    "PURPOSE": "В электронном виде",
                    "FINSRC": [
                      {
                        "NPOS": 1,
                        "KLS": "304521860274017045129118251",
                        "BANKCODE": "00014",
                        "BANKACC": "23402000300100001010",
                        "SUMMA": 57600000
                      }
                    ],
                    "SPECIFICATIONS": [
                      {
                        "FINYEAR": 2022,
                        "KLS": "304521860274017045129118251",
                        "NPOS": 1,
                        "TOVAR": "71.12.12.130-00004",
                        "TOVARNAME": "Услуга по разработке проектно-сметных работ",
                        "TOVARNOTE": "Пискент туман  Тараққиёт МФЙ Ўрикзор кўчасини жорий таъмирлаш лойиҳа-смета ҳужжатларини ишлаб чиқиш",
                        "TOVAREDIZM": 0,
                        "TOVARAMOUNT": 1,
                        "TOVARPRICE": 57600000,
                        "TOVARSUMMA": 57600000,
                        "EXPENSE": "44239000",
                        "SPLIT": [
                          {
                            "MONTH": 7,
                            "TOVARAMOUNT": 1
                          }
                        ],
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      }
                    ],
                    "GRAFICS": [
                      {
                        "FINYEAR": 2022,
                        "MONTH": 7,
                        "KLS": "304521860274017045129118251",
                        "SUMMA": 57600000,
                        "EXPENSE": "44239000"
                      }
                    ]
                  }
                }""";
    }

    private String responseAuction() {
        return """
                {
                  "RESPONSE_ID": 3565054,
                  "REQUEST_ID": 2266047,
                  "METHOD_NAME": "RESPONSE_AUCTION",
                  "PAYLOAD": {
                    "LOTID": 22111008544419,
                    "STATE": 2,
                    "MSG": ""
                  }
                }""";
    }

    private String rkpPays() {
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2266080,
                  "METHOD_NAME": "RKP_PAYS",
                  "PAYLOAD": {
                    "PAYID": 329317,
                    "PAYTYPE": 3,
                    "DOCNUMB": "329317",
                    "DOCDATE": "16072022",
                    "SUMPAY": 23998000,
                    "CURRENCY": 860,
                    "CONTRACT": 30063349,
                    "LOTID": 22111008519463,
                    "ACCETP": "700110860262877950600262007",
                    "CONAME": "PARFUME LUXE MCHJ",
                    "COMFO": "00433",
                    "COACC": "20208000601001142001",
                    "COKLS": null,
                    "COINN": "306097967",
                    "VENDORPINFL": null,
                    "PURPOSE": "700110860262877950600262007~200933985~За Вещества химические и продукты химические, договор №450116 от 07.07.2022 от ИНН: 305866588(Национальная палата инновационного здравоохранения Республики Узбекист) xarid.uzex.uz (Электронный магазин)",
                    "CNTRSUM": "736D6D1A92AEEDE55FEB116F02C9AA390E7AD840"
                  }
                }""";
    }

    private String responseClaimInfo() {
        return """
                {
                  "RESPONSE_ID": 3565085,
                  "REQUEST_ID": 2266119,
                  "METHOD_NAME": "RESPONSE_CLAIM_INFO",
                  "PAYLOAD": {
                    "LOTID": 22110012123893,
                    "CLAIM_ID": 55538,
                    "ORGAN": "49585000002",
                    "INN": "304943564",
                    "KLS": "304521860274017045129118438",
                    "SUMMA": 414100000,
                    "STATE": 4,
                    "MSG": ""
                  }
                }""";
    }

    private String paysByLotId(){
        return """
                {
                  "RESPONSE_ID": 3565191,
                  "REQUEST_ID": 0,
                  "METHOD_NAME": "PAYS_BY_LOTID",
                  "PAYLOAD": [
                    {
                      "PAYID": 0,
                      "OPERDAY": "16072022",
                      "PAYTYPE": 3,
                      "ID": 560714899,
                      "DOCNUMB": "0530001093",
                      "DOCDATE": "16072022",
                      "SUMPAY": 70327500000,
                      "CONTRACT": 29791104,
                      "LOTID": 22411006009378,
                      "CLNAME": "Сирдаре вилояти хокимлигининг курилиш буиича ягона буюртмачи хизмати и",
                      "CLMFO": "00014",
                      "CLACC": "23402000300100001010",
                      "CLKLS": "100021860244017016801018046",
                      "CLINN": "204773938",
                      "CLPINFL": "",
                      "CONAME": "Sobirjon Davronjon Hamkor XK",
                      "COMFO": "00370",
                      "COACC": "20208000704885297001",
                      "COKLS": "",
                      "COINN": "301820205",
                      "COPINFL": "00000000000000",
                      "OPER": "2010",
                      "PURPOSE": "100021860244017016801018046~204773938~Сирдарё вилояти Ягона буюртмачи ХИК~16.05.2022 йил шартнома №113га асосан Янгиер шахри худудидан утувчи Жанубий Мирзачул каналининг жанубий ва шимолий киргоги буйлаб саломатлик йулакларини куришга баж иш 13,07,2022й хис фак №2га асосан  46.8% утказилди.; Ст.  43.22.900",
                      "ERRMSG": "000"
                    }
                  ]
                }""";
    }

    private String queryPlan(){
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2266719,
                  "METHOD_NAME": "QUERY_PLAN",
                  "PAYLOAD": {
                    "FINYEAR": 2022,
                    "KLS": "400121860262667063201110003",
                    "TOVARLIST": []
                  }
                }""";
    }

    private String queryKls(){
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2266725,
                  "METHOD_NAME": "QUERY_KLS",
                  "PAYLOAD": {
                    "INN": "200170038"
                  }
                }""";
    }

    private String planInfo(){
        return """
                {
                  "RESPONSE_ID": 3566336,
                  "REQUEST_ID": 48448,
                  "METHOD_NAME": "PLAN_INFO",
                  "PAYLOAD": {
                    "COUNTS": 1,
                    "RECORDS": [
                      {
                        "FINYEAR": 2022,
                        "MONTH": 7,
                        "KLS": "304521860304087045129118001",
                        "TOVAR": "41.20.40.900-00004",
                        "TOVARNAME": "Услуги по капитальному ремонту сооружений",
                        "EXPENSE": "44332100",
                        "TOVARAMOUNT": 1,
                        "TOVAREDIZM": 0,
                        "TOVARPRICE": 456900000000,
                        "SUMMA": 456900000000,
                        "CONDITIONS": "тез ва сифатли",
                        "ADRESS": "",
                        "SROK": 40,
                        "PROPERTIES": [
                          {
                            "PROP_NUMB": 0,
                            "PROP_NAME": "Единица измерения",
                            "VAL_NUMB": 0,
                            "VAL_NAME": "усл. ед"
                          }
                        ]
                      }
                    ]
                  }
                }""";
    }

    private String noResult(){
        return """
                {
                  "ETP_ID": 1,
                  "REQUEST_ID": 2266755,
                  "METHOD_NAME": "NO_RESULT",
                  "PAYLOAD": {
                    "LOTID": 22110012124061,
                    "PROC_ID": 4,
                    "PRICH": 3
                  }
                }""";
    }

}
