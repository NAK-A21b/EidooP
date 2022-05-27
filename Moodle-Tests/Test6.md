## Frage 1 ##

Bitte geben Sie korrekte Parameter und Rückgabetypen an:

|                       | ArrayList<String>     | ArrayList<String>     | ArrayList<MusicTrack> | ArrayList<MusicTrack> | ArrayList             | ArrayList             |
|-----------------------|-----------------------|-----------------------|-----------------------|-----------------------|-----------------------|-----------------------|
|                       | Parameter             | Return                | Parameter             | Return                | Parameter             | Return                |
| add                   | ```String```          | ```boolean```         | ```MusicTrack```      | ```boolean```         | ```Object```          | ```boolean```         |
| get                   | ```int```             | ```String```          | ```int```             | ```MusicTrack```      | ```int```             | ```Object```          |
| remove(Element)       | ```String```          | ```boolean```         | ```MusicTrack```      | ```boolean```         | ```Object```          | ```boolean```         |
| remove(Index)         | ```int```             | ```String```          | ```int```             | ```MusicTrack```      | ```int```             | ```Object```          |

## Frage 2 ##

Für einen Online Shop soll ein ShoppingBasket realisiert werden. Für einen ersten Prototyp dieses Systems sollen die Ausgaben auf die Konsole erfolgen. Der ShoppingBasket basiert auf einem Catalog, in dem der Preis von Product-Objekten hinterlegt ist. Sie dürfen davon ausgehen, dass ein einmal zugewiesener Catalog nicht mehr geändert wird. 
Parameter, Rückgabetypen, Exemplarvariablen und private Methoden sind nicht dargestellt und gemäß Aufgabenstellung zu ergänzen.

Setzen sie dabei folgende Punkte für die Klasse Catalog um. Die andere Klasse können sie in dieser Aufgabe ignorieren.

  1. Jedes Produkt wird durch seinen Namen identifiziert und ist deshalb als String zu implementieren. Beispiele:
     Tamagotchi mit integrierter Hupe, Pikachu untrainiert. Der identifizierende String wird in allen Methoden von
     Catalog als erster Parameter übergeben. Einige Methoden übergeben zusätzlich den Preis. Überlegen sie, welche das sind.
  2. Der Catalog kennt Methoden zum Hinzufügen (addProduct), Löschen (deleteProduct), Ändern (updateProduct),
     Anzeigen (showProduct) und zum Auslesen des Preises (getProductPrice) von Produkten.
  3. addProduct gibt eine Fehlermeldung „... already exists“ aus, wenn ein Produkt schon vorhanden ist. ... ist
     durch den Produktnamen zu ersetzen.
  4. deleteProduct, updateProduct und showProduct geben eine Fehlermeldung „... does not exist“ aus, wenn ein Produkt nicht
     vorhanden ist.
  5. Die Ausgabe von showProduct für ein untrainiertes Pikachu sieht  folgendermassen aus. Halten sie sich exakt an die Formatierung. :
     Pikachu untrainiert: 200,00€
  
```java
  public class Catalog {
    HashMap <String, Integer> catalog;
    
    public Catalog(){
        catalog = new HashMap<>();
    }
    
    public boolean hasProduct(String name){  //diese Methode ist nicht gefordert, wird aber für die späteren if-abfragen genutzt
        return catalog.containsKey(name);
    }
    
    public void addProduct(String name, int price){
        if(hasProduct(name)){
            System.out.println(name + " already exists");
        }else{
            catalog.put(name, price);
        }
    }
    
    public void deleteProduct(String name){
        if(!hasProduct(name)){
            System.out.println(name + " does not exist");
        }else{
            catalog.remove(name);
        }
    }
    
    public void updateProduct(String name, int price){
        if(!hasProduct(name)){
            System.out.println(name + " does not exist");
        }else{
            catalog.replace(name, price);
        }
    }
    
    public void showProduct(String name){
        if(!hasProduct(name)){
            System.out.println(name + " does not exist");
        }else{
            System.out.println(name + ": " + getPreis(name));
        }
    }
    
    private String getPreis(String name){ //Diese Methode dient als Ersatz für "getProductPrice", weil die einen int-Wert zurückgeben muss, ein ausgabefertiger String allerdings sinnvoller ist.
        int preis = catalog.get(name);
        String price = Integer.toString(preis);
        
        if(preis < 100){
            price = "0" + price;
        }
        if(preis < 10){
            price = "0" + price;
        }
        
        int lange = price.length();
        
        return price.substring(0,lange - 2) + "," + price.substring(lange - 2) + "€";
    }
    
    public int getProductPrice(String name){ //Diese Methode ist nur vorhanden, weil ihre Existenz geprüft wird.
        return catalog.get(name);
    }
}
```
