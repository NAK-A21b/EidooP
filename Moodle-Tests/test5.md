## ACHTUNG! Die Reihenfolge der Multiple-Choice Aufgabe ist zufällig! ##

## Frage 1 ##

Eine Arraylist soll als Exemplarvariable angelegt werden. Welche der Deklarationen ist korrekt, welche korrekt aber
problematisch und welche inkorrekt?

### Deklaration einer ArrayList ###

| Deklaration                                             | Bewertung                    |
|---------------------------------------------------------|------------------------------|
| private ArrayList list = new ArrayList();               | 🟠Korrekt aber Problematisch |
| private ArrayList list;                                 | 🟠Korrekt aber Problematisch |
| private ArrayList<> list = new ArrayList<String>();     | 🔴Nicht korrekt              |
| private ArrayList<String> list = new ArrayList<String>; | 🔴Nicht korrekt              |
| private ArrayList list = new ArrayList<String>;         | 🔴Nicht korrekt              |
| private ArrayList<String> list= new ArrayList<>();      | 🟢Korrekt                    |
| private ArrayList<int> list = new ArrayList<>();        | 🔴Nicht korrekt              |
| private ArrayList<String> list = new ArrayList();       | 🟠Korrekt aber Problematisch |
| private ArrayList list = new ArrayList<String>();       | 🟠Korrekt aber Problematisch |
| private ArrayList<String> list;                         | 🟢Korrekt                    |

## Frage 2 ##

Folgende Methode wurde zum Bearbeiten einer Liste von Posts geschrieben:

public void deleteTabu(ArrayList<String> posts, String tabu){ for (String post:posts) { if (post.contains(tabu)){
posts.remove(post); } } }

Die ArrayList<String> listOfPosts enthalte die vier Strings "Das Opfer abonnierte die Tageszeitung.", "Sie haben das
Opfer-Abo.", "Opfer-Abo für Java Programmierer." und "Kein Oper-Abo mehr verfügbar.".

Was passiert bei einem Aufruf

deleteTabu(listOfPosts, "Opfer-Abo")?

Wählen Sie eine Antwort:

- [ ] a. Der die Methode deleteTabu kann nicht compiliert werden, weil die Methode remove(String) nicht existiert.
- [ ] b. Die Methode läuft fehlerfrei durch, aber die Collection listOfPosts ändert sich nicht, da in der methode die
  Variable posts verändert wird und nicht listOfPosts.
- [x] c. Der Methodenaufruf bricht ab, da die Collection posts innerhalb einer for-each Schleife nicht verändert werden
  darf.
- [ ] d. Der Aufruf funktioniert fehlerfrei und die Liste listOfPosts hat nach dem Aufruf nur noch zwei Elemente.

## Frage 3 ##

Welche der folgenden Methoden kann man auf eine Liste anwenden? Der Typ-Parameter heißt Element. Wählen Sie eine oder
mehrere Antworten:

- [ ] a. void insert(Element element, int index)
- [x] b. Element get(int index)
- [ ] c. void delete(Element element)
- [x] d. Element remove(int index)
- [x] e. int size()
- [ ] f. int length()
- [x] g. boolean isEmpty()
- [x] h. boolean add(Element element)

## Frage 4 ##

Welche der folgenden Aussagen sind richtig? Wählen Sie eine oder mehrere Antworten:

- [x] a. Die Klasse ArrayList ist im java.util Package enthalten.
- [ ] b. Das import Statement "import java.util.ArrayList;" inkludiert den Sourcecode der ArrayList-Klasse in die Klasse
  hinein, in der es geschrieben wird. Der Java Compiler optimiert den Code, indem nicht genutzte Methoden der Klasse
  ArrayList gelöscht werden.
- [ ] c. Objekte vom Typ ArrayList sind in Java die einzige Möglichkeit, eine variable Anzahl von Objekten zu speichern,
  denn Arrays erlauben nur eine feste Anzahl von Objekten zu hinterlegen.
- [x] d. Damit die Deklaration "ArrayList liste = new ArrayList();" compiliert werden kann, muss ein import Statement "
  import java.util.ArrayList;" oder "import java.util.*;" vor der Klassendeklaration angegeben werden.

## Frage 5 ##

Erstellen Sie eine Methode ArrayList<String> unify(ArrayList<String> input), die Strings aus einer ArrayList input in
eine andere ArrayList result überträgt und dann zurückgibt. Dabei soll:

1. Jeder non-null String aus input kommt auch in result vor aber keine anderen.
2. Strings kommen in result nicht doppelt vor.

Verwenden sie eine for-each Schleife.

Tipp: Mit der Methode contains(Element e) kann überprüft werden, ob ein Element in einer ArrayList vorhanden ist.

```java
public class Main() {
    // Beginn der Lösung
    public ArrayList<String> unify(ArrayList<String> input) {

        ArrayList<String> result = new ArrayList<>();

        for (String str : input) {
            if (str != null && !result.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }
    // Ende der Lösung
}
```

## Frage 6 ##

Erstellen Sie eine Methode ArrayList<String> unify(ArrayList<String> input), die Strings aus einer ArrayList input in
eine andere ArrayList result überträgt und dann zurückgibt. Dabei soll:

1. Jeder non-null String aus input kommt auch in result vor aber keine anderen.
2. Strings kommen in result nicht doppelt vor.

Verwenden sie eine while Schleife.

Tipp: Mit der Methode contains(Element e) kann überprüft werden, ob ein Element in einer ArrayList vorhanden ist.

```java
public class Main() {
    // Beginn der Lösung
    public ArrayList<String> unify(ArrayList<String> input) {
        int index = 0;
        ArrayList<String> result = new ArrayList<>();
        while (index < input.size()) {
            if (input.get(index) != null && !result.contains(input.get(index))) {
                result.add(input.get(index));
            }
            index++;
        }
        return result;
    }
    // Ende der Lösung
}
```

## Frage 7 ##

Schreiben Sie eine verlässliche Methode, die alle posts einer ArrayListe löscht, die eine gegebene "tabu"-Zeichenkette
enthalten. Berücksichtigen Sie dabei die möglichen Werte, die in einer ArrayList<String> gespeichert werden können.

```java
public class Main() {
    // Beginn der Lösung
    public void deleteTabu(ArrayList<String> posts, String tabu) {
        String speicher;
        Iterator<String> i = posts.iterator();
        while (i.hasNext()) {
            speicher = i.next();
            if (speicher != null && speicher.contains(tabu)) {
                i.remove();
            }
        }
    }
    // Ende der Lösung
}
```

## Frage 8 ##

Für einen Online Shop soll ein ShoppingBasket realisiert werden. Für einen ersten Prototyp dieses Systems sollen die
Ausgaben auf die Konsole erfolgen. Der ShoppingBasket basiert auf einem Catalog, in dem der Preis von Product-Objekten
hinterlegt ist. Sie dürfen davon ausgehen, dass ein einmal zugewiesener Catalog nicht mehr geändert wird. Der Catalog (
Lösung der Aufgabe: Shopping Basket Catoalog Programmierung) ist in dieser Aufgabenstellung fertig und steht zur
Benutzung zur Verfügung. Parameter, Rückgabetypen, Exemplarvariablen und private Methoden sind nicht dargestellt und
gemäß Aufgabenstellung zu ergänzen.

Setzen Sie für den ShoppingBasket folgende Anforderungen durch:

1. In dem Konstruktor des ShoppingBasket wird ein Catalog übergeben, der von den Business Methoden des ShoppingBasket
   genutzt wird.
2. Der ShoppingBasket soll in der Lage sein, Produkte aufzunehmen.
3. Soll ein Produkt mehrfach bestellt werden, wird das Produkt mehrfach in den ShoppingBasket gelegt.
4. Der ShoppingBasket kann einen Gesamtpreis aller Produkte im ShoppingBasket berechnen. Der Inhalt des ShoppingBasket
   kann in der Reihenfolge des Hinzufügens aufgelistet werden. Jede Position im ShoppingBasket erhält eine
   Positionsnummer. Die Breiten der Spalten sind fix (bitte abzählen!) und lange Produktnamen werden bei der Ausgabe
   abgeschnitten.
5. Durch Angabe der Positionsnummer kann ein Element aus dem ShoppingBasket gelöscht werden. Wird eine nicht
   existierende Positionsnummer angegeben, wird die Meldung "There is no item at the position number given!" ausgegeben.
6. Alle zu einem Produkt gehörenden Positionen können gelöscht werden.
7. Der ShoppingBasket kann sortiert werden. Tipp: Es gibt eine Utility Klasse Collections.
8. Man kann einen Lieferschein ausdrucken. Der Lieferschein ist sortiert.

```java

public class ShoppingBasket {
    private final ArrayList<String> items;
    private final Catalog catalog;

    public ShoppingBasket(Catalog catalog) {
        this.catalog = catalog;
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public Integer calculateBasketPrice() {
        Integer price = 0;
        for (String item : items) {
            price += catalog.getProductPrice(item);
        }
        return price;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        String recordSeparator = "+-----------------------------------+-------+";
        String headerColumn = "|Pos|Produkt                        |Preis  |";
        sb.append(recordSeparator).append("\n");
        sb.append(headerColumn).append("\n");
        for (String item : items) {
            sb.append(String.format("|%-3s|%-35s|%-7s|\n", items.indexOf(item) + 1, item, catalog.getProductPrice(item)));
        }
        sb.append(recordSeparator).append("\n");
        sb.append(String.format("|%39s %-7s|\n", "Gesamt", calculateBasketPrice()));
        sb.append(recordSeparator).append("\n");
        System.out.println(sb);
    }

    public void deleteItem(int item) {
        if (item > 0 && item <= items.size()) {
            items.remove(item - 1);
        } else {
            System.out.println("There is no item at the position number given!");
        }
    }

    public void deleteItems(String item) {
        items.removeIf(i -> i.equals(item));
    }

    public void sortByName() {
        items.sort(String::compareTo);
    }

    public void printPackList() {
        StringBuilder sb = new StringBuilder();
        String recordSeparator = "+-------------------------------+-------+";
        String headerColumn = "|Produkt                        |Anzahl |";
        TreeMap<String, Integer> packList = new TreeMap<>();
        for (String item : items) {
            if (packList.containsKey(item)) {
                packList.put(item, packList.get(item) + 1);
            } else {
                packList.put(item, 1);
            }
        }
        sb.append(recordSeparator).append("\n");
        sb.append(headerColumn).append("\n");
        sb.append(recordSeparator).append("\n");
        for (String item : packList.keySet()) {
            sb.append(String.format("|%-31s|%-7s|\n", item, packList.get(item)));
        }
        sb.append(recordSeparator).append("\n");
        System.out.println(sb);
    }

}
```
