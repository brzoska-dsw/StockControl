INSTRUKCJA URUCHOMIENIA:
1. Sklonuj repozytorium
2. Uruchom backend (domyślnie na porcie 8080) -> klasa StockControlApplication oznaczona jako @SpringBootApplication
3. Uruchom frontend (domyślnie na porcie 3000)
3a. Przejdź w konsoli do src/main/webApp/reactpart
3b. npm install
3c. npm start
4. Aplikacja uruchomiona (backend na porcie 8080, frontend na porcie 3000)
5. Do pełnej funkcjonalności potrzebna jest oczywiście baza danych zdefiniowana w application.properties

PROJECT: 
StockControl - aplikacja do kontrolowania zapasów materiałowych

Funkcje systemu:

	Admin:
	- zarządzanie użytkownikami
	- dodawanie/usówanie/zmiana statusu części (Part)
	- dodawanie/usówanie/zmiana statusu wyrobu gotowego (Unit)
	- upload planów produkcyjnych
	
	User:
	- rejestracja
	- przeglądanie tabel
	- symulacja zmian planów prod.(możliwość cofnięcia zmian po analizie zapasów)
	
Encje:
	
	- konto użytkonika
	- Part (część)
	- Unit (FG - wyrób gotowy)
	- Bom (tabela Part/Unit)
	- StockControl (tabela days/Parts)
	- ProdPlan (ilość FG do wyprodukowania dziennie)
	
