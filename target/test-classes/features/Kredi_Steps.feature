Feature: Web Test Otomasyon Proje - 1

  Scenario: Kredi hesaplama alaninda ana para bakiye kolonunun test edilmesi
    Given www.vakifbank.com.tr sitesine giris yapilir.
    When Bireysel tabanina tiklanir.
    And Hesaplama araclarinda kredi taksitleri butonuna tiklanir.
    And Kredi Combobox'indan KONUT KREDISI ADK secenegi tiklanir.
    And Vade olarak oniki ay yazilir.
    And Tutar olarak onbin tl girilir.
    And Hesapla butonuna basilir.
    And Gelen Kredi Bilgileri alaninda kredi tipinin “KONUT KREDİSİ ADK” yazili oldugu kontrol edilir.
    And Kredi Miktarinin onbin TL olarak yazili oldugu kontrol edilir.
    And Odeme planina tiklanir.
    Then Acilan ekranda Ana para bakiye kolonunun ilk elemaninin onbin TL yazili oldugu kontrol edilir.