INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(1, NULL, 'Procesory', 'procesory', 'Wszystko o jednostkach centralnych - nowości, testy i porównania.', 'bi-cpu', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, 'AMD', 'procesory-amd', 'Dyskusje o procesorach Ryzen, Threadripper oraz architekturze Zen.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 1, 'Intel', 'procesory-intel', 'Sekcja poświęcona procesorom Core, Xeon oraz technologiom niebieskich.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 1, 'Apple', 'procesory-apple', 'Analiza wydajności układów Apple Silicon z serii M1, M2 i M3.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(5, NULL, 'Karty graficzne', 'karty-graficzne', 'Dyskusje o GPU, ray tracingu i wydajności w grach oraz pracy.', 'bi-gpu-card', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 5, 'AMD', 'karty-graficzne-amd', 'Karty Radeon - sterowniki, technologie FSR i modele niereferencyjne.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 5, 'Intel', 'karty-graficzne-intel', 'Nowe układy Intel Arc - testy wydajności i wsparcie techniczne.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(8, NULL, 'Zestawy komputerowe', 'zestawy-komputerowe', 'Pomoc w doborze części i gotowe konfiguracje w różnych budżetach.', 'bi-pc-display', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, NULL, 'Płyty główne', 'plyty-glowne', 'Wybór odpowiedniego chipsetu, sekcje zasilania i aktualizacje BIOS.', 'bi-motherboard', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, NULL, 'Pamięci RAM', 'pamieci-ram', 'Taktowania, opóźnienia CL i dobór kości DDR4 oraz DDR5.', 'bi-memory', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, NULL, 'Dyski i nośniki', 'dyski-i-nosniki', 'Szybkie dyski NVMe, SSD SATA oraz magazyny danych HDD.', 'bi-device-ssd', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(12, NULL, 'Obudowy i zasilacze', 'obudowy-i-zasilacze', 'Kwestie estetyki, przewiewności oraz stabilnego zasilania PC.', 'bi-box', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 12, 'Obudowy', 'obudowy', 'Standardy ATX, ITX oraz zarządzanie okablowaniem.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 12, 'Zasilacze', 'zasilacze', 'Certyfikaty sprawności, moc i bezpieczeństwo Twojego sprzętu.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(15, NULL, 'Chłodzenie i podkręcanie', 'chlodzenie-i-podkrecanie', 'OC procesorów i kart oraz chłodzenie powietrzem i cieczą.', 'bi-snow', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(16, NULL, 'Laptopy', 'laptopy', 'Notebooki biurowe, gamingowe oraz ultrabooki.', 'bi-laptop', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(17, NULL, 'Monitory i projektory', 'monitory-i-projektory', 'Obraz w wysokiej rozdzielczości, matryce i odwzorowanie barw.', 'bi-display', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 17, 'Monitory', 'monitory', 'Panele IPS, OLED oraz monitory dla profesjonalnych graczy.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 17, 'Projektory', 'projektory', 'Kino domowe i rozwiązania prezentacyjne.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, NULL, 'Urządzenia audio', 'urzadzenia-audio', 'Karty dźwiękowe, głośniki, słuchawki i mikrofony.', 'bi-headphones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(21, NULL, 'Mobilne', 'mobilne', 'Technologie przenośne, ekosystemy i nowości rynkowe.', 'bi-phone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(22, 21, 'Tablety', 'tablety', 'Urządzenia do pracy kreatywnej i konsumpcji multimediów.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(23, 21, 'Smartfony', 'smartfony', 'Najnowsze flagowce i telefony ze średniej półki.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(24, 21, 'Telefony', 'telefony', 'Klasyczne telefony komórkowe i akcesoria.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(25, NULL, 'Sieci i komunikacja', 'sieci-i-komunikacja', 'Routery, modemy, konfiguracja Wi-Fi oraz sieci lokalne.', 'bi-router', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(26, NULL, 'Urządzenia wskazujące', 'urzadzenia-wskazujace', 'Myszki, klawiatury i inne peryferia wejścia.', 'bi-mouse', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(27, 26, 'Myszki', 'myszki', 'Sensory, DPI i ergonomia dla graczy i profesjonalistów.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(28, 26, 'Klawiatury', 'klawiatury', 'Klawiatury mechaniczne, membranowe i customowe.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(29, NULL, 'Pozostały sprzęt', 'pozostaly-sprzet', 'Akcesoria, drukarki i sprzęt nietypowy.', 'bi-plug', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(30, NULL, 'Awarie komputerów', 'awarie-komputerow', 'Pomoc techniczna w rozwiązywaniu problemów sprzętowych.', 'bi-exclamation-triangle', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(31, NULL, 'Poradniki komputerowe', 'poradniki-komputerowe', 'Instrukcje krok po kroku i triki ułatwiające życie.', 'bi-book', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(32, NULL, 'Oprogramowanie', 'oprogramowanie', 'Systemy, aplikacje użytkowe i narzędzia.', 'bi-window-stack', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(33, 32, 'Systemy operacyjne', 'systemy-operacyjne', 'Konfiguracja i wsparcie dla Windows, Linux i MacOS.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(34, 33, 'Windows', 'windows', 'Wszystko o Windows 10, 11 oraz starszych wersjach.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(35, 33, 'Linux', 'linux', 'Dystrybucje, terminal i wolne oprogramowanie.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(36, 33, 'MacOS', 'macos', 'System Apple - porady, triki i kompatybilność.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(37, 32, 'Programy', 'programy', 'Użyteczne aplikacje do biura, grafiki i multimediów.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(38, 32, 'Bezpieczeństwo', 'bezpieczenstwo', 'Antywirusy, firewale i ochrona prywatności w sieci.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(39, NULL, 'Gry wideo', 'gry-wideo', 'Świat rozrywki elektronicznej na PC i konsole.', 'bi-controller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(40, 39, 'Gry', 'gry', 'Recenzje, zapowiedzi i dyskusje o najnowszych tytułach.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(41, 39, 'Poradniki do gier', 'poradniki-do-gier', 'Solucje, opisy przejścia i pomoc w trudnych etapach.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(42, 39, 'Konsole', 'konsole', 'PlayStation, Xbox oraz Nintendo Switch.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(43, NULL, 'Programowanie', 'programowanie', 'Tworzenie kodu, architektura i nauka języków.', 'bi-code-slash', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(44, 43, 'Frontend', 'frontend', 'HTML, CSS, JavaScript i nowoczesne frameworki jak React.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(45, 43, 'Backend', 'backend', 'Logika serwerowa, bazy danych i Java, Python czy Node.js.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO yourpc_schema.sections (id, parent_id, name, slug, description, thumbnail, created_at, updated_at) VALUES
(46, NULL, 'Ogłoszenia', 'ogloszenia', 'Miejsce handlu i usług pomiędzy użytkownikami.', 'bi-megaphone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(47, 46, 'Sprzedam', 'sprzedam', 'Oferty sprzedaży sprzętu i oprogramowania.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(48, 46, 'Kupię', 'kupie', 'Szukasz konkretnej części? Złóż ofertę tutaj.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(49, 46, 'Wycena', 'wycena', 'Pomoc w ustaleniu rynkowej wartości podzespołów.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(50, 46, 'Wykonam', 'wykonam', 'Oferty usług serwisowych, programistycznych i graficznych.', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);