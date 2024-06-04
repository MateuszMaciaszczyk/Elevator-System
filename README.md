# System Wind

System Wind to prosty symulator systemu wind napisany w języku Java.

## Uruchomienie

Aby uruchomić ten projekt, musisz mieć zainstalowane JDK i Gradle. Następnie wykonaj następujące kroki:

1. Sklonuj repozytorium: `git clone https://github.com/yourusername/elevator-system.git`
2. Przejdź do katalogu projektu: `cd elevator-system`
3. Uruchom projekt: `./gradlew run`

## Opis algorytmu

Algorytm symulacji systemu wind działa na zasadzie obsługi żądań od użytkowników. Każde żądanie jest reprezentowane jako para liczb całkowitych, gdzie pierwsza liczba to piętro, na którym użytkownik wezwał windę, a druga liczba to piętro docelowe.

Żądania są dodawane do kolejki i obsługiwane w kolejności ich dodania. W każdym kroku symulacji, system wind sprawdza, czy są jakiekolwiek żądania do obsłużenia. Jeśli tak, to wybiera windę, która jest najbliżej piętra startowego żądania.

Następnie, jeśli wybrana winda jest bezczynna, przypisuje jej nowe zadanie. Winda następnie wykonuje krok, przemieszczając się o jedno piętro w kierunku swojego celu.

Po obsłużeniu żądania, winda staje się bezczynna, dopóki nie otrzyma nowego zadania.

## Testy

Aby uruchomić testy jednostkowe, użyj polecenia `./gradlew test` w terminalu.
