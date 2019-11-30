  /* public static void ozyineleme(String[] kelime) {

        int uzunluk = kelime.length - 1;
        int deger = 1;
        int basamak = 1;
        boolean deger_basamak_max_ulasildi = false;
        int deger_Max = 0;
        int deger_atlama_derecesi = 1;
        String arraya_eklenecek_kelime = "";
        for (int i = 0; i < kelime.length; i++) {
            arraya_eklenecek_kelime += kelime[i];
        }
        arraylist.add(arraya_eklenecek_kelime);

        // while (deger_Max != kelime.length - 1 && basamak != kelime.length - 1)
        {

            String[] gecici_harf = new String[1];
            gecici_harf[0] = kelime[uzunluk - basamak];
            kelime[uzunluk - basamak] = kelime[uzunluk];
            kelime[uzunluk] = gecici_harf[0];

            arraya_eklenecek_kelime = "";
            for (int i = 0; i < kelime.length; i++) {
                arraya_eklenecek_kelime += kelime[i];
            }
            arraylist.add(arraya_eklenecek_kelime);
            basamak++;
            deger++;
            if (deger == basamak) {
                basamak = 1;
                deger = 1;  //2 kere değişecek yani eger = 3 olacak  sağdan da 3. sıradan (1den başlayarak)
            }

        }
        System.out.println(arraylist.get(0));
        System.out.println(arraylist.get(1));
    }*/