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
g	- przeglądanie tabel
	- symulacja zmian planów prod.(możliwość cofnięcia zmian po analizie zapasów)
	
Encje:
	
	- konto użytkonika
	- Part (część)
	- Unit (FG - wyrób gotowy)
	- Bom (tabela Part/Unit)
	- StockControl (tabela days/Parts)
	- ProdPlan (ilość FG do wyprodukowania dziennie)
	
